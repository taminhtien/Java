package com.tientm.hibernate.query;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.tientm.hibernate.entities.Employee;

public class CriteriaQueryDemo {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.getTransaction().begin();
			/**
			 * Thay vì viết một câu HQL như sau: Select e from Employee e where
			 * e.empName like '%A%' order by e.empName asc. Chúng ta sử dụng đối
			 * tượng Criteria. Criteria giúp bạn xây dựng một câu HQL theo hướng
			 * mô tả.
			 */
			Criteria crit = session.createCriteria(Employee.class);
			// Thêm điều kiện like
			crit.add(Restrictions.like("empName", "%A%"));
			// Thêm order
			crit.addOrder(Order.asc("empName"));
			// Truy vấn
			List<Employee> employees = crit.list();
			
			// Duyệt dữ liệu
			for (Employee employee : employees) {
				System.out.println("EmpName: " + employee.getEmpName());
			}

			// Commit dữ liệu
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
}
