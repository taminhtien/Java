package com.tientm.hibernate.persist;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tientm.hibernate.entities.Department;
import com.tientm.hibernate.entities.Employee;
import com.tientm.hibernate.query.HibernateUtils;

public class PersistDemo {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();

		Department department = null;
		Employee emp = null;
		try {
			session.getTransaction().begin();
			Long maxEmpId = DataUtils.getMaxEmpId(session);
			Long empId = maxEmpId + 1;

			// Tìm phòng ban với mã số D10
			// Nó là đối tượng chịu sự quản lý của session
			// Và nó được gọi là đối tượng persistent
			department = DataUtils.findDepartment(session, "D10");

			// Tạo mới đối tượng Employee
			// Đối tượng này chưa chịu sự quản lý của session
			// Nó được coi là đối tượng Transient
			emp = new Employee();
			emp.setEmpId(empId);
			emp.setEmpNO("E" + empId);
			emp.setEmpName("Name " + empId);
			emp.setJob("Coder");
			emp.setSalary(1000f);
			emp.setManager(null);
			emp.setHideDate(new Date());
			emp.setDepartment(department);

			// Sử dụng persist(...) để insert một đối tượng Transient vào DB
			// Insert emp vào DB
			// Lúc này "emp" đã chịu sự quản lý của session
			// nó được gọi là persistent object
			session.persist(emp);
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		// Sau khi session bị đóng lại (commit, rollback, close)
		// Đối tượng 'emp', 'dept' trở thành đối tượng Detached.
		// Nó không còn trong sự quản lý của session nữa.
		System.out.println("Emp No: " + emp.getEmpNO());
	}
}
