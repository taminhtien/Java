package com.tientm.hibernate.detached;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tientm.hibernate.entities.Employee;
import com.tientm.hibernate.persist.DataUtils;
import com.tientm.hibernate.query.HibernateUtils;

public class RefreshDetachedDemo {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		Employee emp = null;
		try {
			session.getTransaction().begin();
			emp = DataUtils.findEmployee(session, "E7954");
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		System.out.println("- EmpId: " + emp.getEmpId());

		Session session2 = factory.getCurrentSession();
		try {
			session2.getTransaction().begin();
			System.out.println("- Emp persistent? " + session2.contains(emp));
			System.out.println("- Emp salary befor update: " + emp.getSalary());

			// Set salary cho đối tượng detached
			emp.setSalary(emp.getSalary() + 1000);

			// Refresh tạo ra câu truy vấn và đưa đối tượng detached ->
			// Persistent
			// Các thay đổi KHÔNG được lưu lại
			session2.refresh(emp);
			
			System.out.println("- Emp persistent? " + session2.contains(emp));
			System.out.println("- Emp salary after refresh: " + emp.getSalary());
			session2.getTransaction().commit();

		} catch (Exception e) {
			session2.getTransaction().rollback();
		}
	}
}
