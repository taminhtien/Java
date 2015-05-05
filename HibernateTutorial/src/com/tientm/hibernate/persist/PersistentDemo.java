package com.tientm.hibernate.persist;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tientm.hibernate.entities.Department;
import com.tientm.hibernate.query.HibernateUtils;

public class PersistentDemo {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();

		Department department = null;
		try {
			session.getTransaction().begin();
			System.out.println("- Finding Department deptNo = D10...");
			department = DataUtils.findDepartment(session, "D10");

			System.out.println("- First change Location");
			// Thay đổi gì đó trên đối tượng Persistent
			department.setLocation("Chicago " + System.currentTimeMillis());
			System.out.println("- Location = " + department.getLocation());

			// Đẩy các thay đổi xuống DB
			System.out.println("- Calling flush...");
			session.flush();
			// Sử dụng session.flush() để chủ động đẩy các thay đổi xuống DB.
			// Có tác dụng trên tất cả các đối tượng Persistent có thay đổi.
			
			System.out.println("- Flush OK");
			System.out.println("- Second change Location");
			// Thay đổi gì đó trên đối tượng Persistent
			// Dữ liệu sẽ được đẩy xuống DB theo lệnh update sau khi session đóng lại (commit)
			department.setLocation("Chicago " + System.currentTimeMillis());
			
			// In ra location
			System.out.println("- Location: " + department.getLocation());
			
			System.out.println("- Calling commit...");
			// Lệnh commit sẽ làm tất cả những thay đổi được đẩy vào DB
			session.getTransaction().commit();
			System.out.println("- Commit OK");
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		// Tạo lại session sau khi nó đã bị đóng trước đó
		// Do commit or rollback
		
		session = factory.getCurrentSession();
		try {
			session.getTransaction().begin();
			System.out.println("- Finding Department deptNo = D10...");
			// Query lại Deparment D10
			department = DataUtils.findDepartment(session, "D10");
			
			// In ra thông tin location
			System.out.println("- D10 location: " + department.getLocation());
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
}
