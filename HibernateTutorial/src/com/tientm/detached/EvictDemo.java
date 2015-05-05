package com.tientm.detached;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tientm.hibernate.entities.Employee;
import com.tientm.hibernate.persist.DataUtils;
import com.tientm.hibernate.query.HibernateUtils;

public class EvictDemo {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		Employee emp = null;
		try {
			session.getTransaction().begin();

			// Đây là một đối tượng Persistent
			emp = DataUtils.findEmployee(session, "E7499");
			System.out.println("- emp persistent? " + session.contains(emp));

			// Sử dụng evict(Object để đuổi cổ đối tượng persistent)
			session.evict(emp); // => chuyển sang trạng thái detached
			System.out.println("- emp persistent? " + session.contains(emp));

			// Mọi thay đổi trên emp khi cập nhật sẽ không có hiệu quả
			emp.setJob("Code thue");
			session.flush(); // => Không có thay đổi
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
}
