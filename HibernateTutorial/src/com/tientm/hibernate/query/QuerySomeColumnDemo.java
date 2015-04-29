package com.tientm.hibernate.query;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tientm.hibernate.entities.Employee;

public class QuerySomeColumnDemo {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.getTransaction().begin();
			// Query một vài cột
			// Việc lấy dữ liệu trong trường hợp này sẽ phức tạp hơn
			String sql = "Select e.empId, e.empNO, e.empName from "
					+ Employee.class.getName() + " e ";
			Query query = session.createQuery(sql);
			
			// Thực hiện truy vấn
			// Lấy ra danh sách các đối tượng Object[
			List<Object[]> datas = query.list();
			
			for (Object[] emp : datas) {
				System.out.println("Emp Id: " + emp[0]);
				System.out.println("Emp No: " + emp[1]);
				System.out.println("Emp Name: " + emp[2]);
			}
			
			// Commit dữ liệu
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
}
