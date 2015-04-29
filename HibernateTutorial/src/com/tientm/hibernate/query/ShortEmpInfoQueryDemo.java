package com.tientm.hibernate.query;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tientm.hibernate.beans.ShortEmpInfo;
import com.tientm.hibernate.entities.Employee;

public class ShortEmpInfoQueryDemo {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.getTransaction().begin();

			// Sử dụng cấu tử của class ShortEmpInfo để truy vấn
			String sql = "Select new " + ShortEmpInfo.class.getName()
					+ "(e.empId, e.empNO, e.empName) from "
					+ Employee.class.getName() + " e";
			Query query = session.createQuery(sql);
			
			// Thực hiện truy vấn
			// Lấy danh sách các đối tượng ShortEmpInfo
			
			List<ShortEmpInfo> employees = query.list();
			
			for (ShortEmpInfo emp : employees) {
				System.out.println(emp.toString());
			}
			
			// Commit dữ liệu
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
}
