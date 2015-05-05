package com.tientm.hibernate.detached;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tientm.hibernate.entities.Employee;
import com.tientm.hibernate.persist.DataUtils;
import com.tientm.hibernate.query.HibernateUtils;

public class UpdateDetachedDemo {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		Employee emp = null;

		try {
			session.getTransaction().begin();
			emp = DataUtils.findEmployee(session, "E7499");
			session.getTransaction().commit(); // Session đóng, emp thành
												// detached
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		Session session2 = factory.getCurrentSession();
		try {
			session2.getTransaction().begin();
			System.out.println("- emp persistent? " + session2.contains(emp));

			System.out.println("Emp salary: " + emp.getSalary());
			emp.setSalary(emp.getSalary() + 100);

			// update(..) chỉ áp dụng cho đối tượng Detached.
			// (Không dùng được với đối tượng Transient).
			// Sử dụng update(emp) để đưa emp trở lại trạng thái Persistent.
			session2.update(emp);

			// Chủ động đẩy dữ liệu xuống DB.
			// Câu lệnh update sẽ được gọi.
			session2.flush();
			System.out.println("Emp salary after update: " + emp.getSalary());

			session2.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session2.getTransaction().rollback();
		}
	}
}
