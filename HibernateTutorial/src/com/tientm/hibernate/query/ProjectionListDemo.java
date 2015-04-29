package com.tientm.hibernate.query;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.tientm.hibernate.entities.Employee;

public class ProjectionListDemo {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.getTransaction().begin();

			/**
			 *  Thay vì viết một câu HQL như sau:
			 *  Select e.empId, e.empNo, e.empName
			 *  from Employee e where e.empName like '%A%' order by e.empName
			 *  Chúng ta sử dụng đối tượng Criteria & ProjectionList
			 *  Criteria giúp bạn xây dựng một câu HQL theo hướng mô tả.
			 */
			
			Criteria crit = session.createCriteria(Employee.class);
			
			// Tạo đối tượng ProjectionList để định nghĩa các cột
			ProjectionList proj = Projections.projectionList();
			proj.add(Projections.property("empId"));
			proj.add(Projections.property("empNO"));
			proj.add(Projections.property("empName"));
			
			crit.setProjection(proj);
			
			// Thêm điều kiện like
			crit.add(Restrictions.like("empName", "%A%"));
			
			// Thêm order
			crit.addOrder(Order.asc("empName"));
			
			// Truy vấn
			// Danh sách Object[]
			List<Object[]> objs = crit.list();
			
			// Duyệt dữ liệu
			for (Object[] obj : objs) {
				System.out.println("Emp Name: " + obj[2]);
			}
			
			// Commit dữ liệu
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
}
