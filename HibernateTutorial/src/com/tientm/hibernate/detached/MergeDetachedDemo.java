package com.tientm.hibernate.detached;

import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tientm.hibernate.entities.Employee;
import com.tientm.hibernate.persist.DataUtils;
import com.tientm.hibernate.query.HibernateUtils;

public class MergeDetachedDemo {
	public static void main(String[] args) {
		Employee emp = getDetached();
		System.out.println(" - GET EMP " + emp.getEmpId());

		// Ngẫu nhiên xóa hoặc không xóa Employee ứng với ID.
		boolean delete = deleteOrNotDelete(emp.getEmpId());

		System.out.println(" - DELETE? " + delete);

		// saveOrUpdate đối tượng Detached.
		saveOrUpdate(emp);
	}

	private static Employee getDetached() {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		Employee emp = null;

		try {
			session.getTransaction().begin();

			Employee emp2 = DataUtils.findEmployee(session, "E7944"); // Persistent
			System.out.println("- emp2 persistent? " + session.contains(emp2));

			Long maxEmpId = DataUtils.getMaxEmpId(session);
			System.out.println(" - Max Emp ID " + maxEmpId);

			emp = new Employee();
			emp.setEmpId(maxEmpId + 1);
			emp.setEmpNO("E" + (maxEmpId + 1));
			emp.setDepartment(emp2.getDepartment());
			emp.setEmpName("Name " + (maxEmpId + 1));
			emp.setHideDate(emp2.getHideDate());
			emp.setJob("Tester");
			emp.setSalary(1000F); // Transient

			System.out.println("- emp persistent? " + session.contains(emp));

			// emp đã được quản lý bởi Hibernate
			session.persist(emp);
			System.out.println("- emp persistent? " + session.contains(emp));

			// session đã bị đóng lại sau commit được gọi.
			// Một bản ghi Employee đã được insert vào DB.
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return emp;
	}

	// Xóa Employee theo ID cho bởi tham số.
	// Ngẫu nhiên xóa hoặc không xóa.
	private static boolean deleteOrNotDelete(Long empId) {
		// Một số ngẫu nhiên từ 0-9
		int random = new Random().nextInt(10);
		System.out.println("Random: " + random);
		if (random < 5) {
			return false;
		}
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.getTransaction().begin();

			String sql = "Delete " + Employee.class.getName()
					+ " e where e.empId=:empId";
			System.out.println(sql);
			Query query = session.createQuery(sql);
			query.setParameter("empId", empId);
			query.executeUpdate(); // Delete

			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}
	}

	private static void saveOrUpdate(Employee emp) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.getTransaction().begin();
			// Thực tế emp đang có trạng thái detached
			// Nó không được quản lý bởi Hibernate
			// Kiểm tra trạng thái của emp
			System.out.println("- emp persistent? " + session.contains(emp));
			System.out
					.println("- Emp salary before update: " + emp.getSalary());

			// Set salary mới cho đối tượng Detached emp
			emp.setSalary(emp.getSalary() + 1000);

			// merge(Object) trả về empMerge, một bản copy của emp
			// emp vẫn trong tình trạng detached
			// Lúc này vẫn chưa có sử lý gì liên quan DB.
			Employee empMerge = (Employee) session.merge(emp);

			// Chủ động đẩy dữ liệu xuống DB.
			// Tại đây có thể có thể tạo ra câu Insert hoặc Update vào DB.
			// Nếu bản ghi tương ứng đã bị xóa bởi ai đó, câu lệnh Insert sẽ
			// được tạo ra.
			// Ngược lại sẽ là một câu lệnh Update.
			session.flush();
			System.out.println("- emp persistent? " + session.contains(emp));
			System.out
					.println(" - Emp salary after update: " + emp.getSalary());

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
}
