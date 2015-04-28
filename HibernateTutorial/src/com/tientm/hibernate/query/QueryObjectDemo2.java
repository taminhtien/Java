package com.tientm.hibernate.query;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tientm.hibernate.entities.Employee;

public class QueryObjectDemo2 {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			// Tất cả các lệnh hành động với Hibernate đều phải nằm trong 1
			// Transaction
			// Bắt đầu giao dịch
			session.getTransaction().begin();

			// Tạo câu lệnh HQL query object
			// HQL có tham số
			// Tương đương với Native SQL
			// Select e.* from EMPLOYEE e cross join DEPARTMENT d
			// where e.DEPT_ID = d.DEPT_ID and d.DEPT_NO = :deptNo;
			String sql = "Select e from " + Employee.class.getName() + " e "
					+ " where e.department.deptNo=:deptNo ";

			// Tạo đối tượng Query
			Query query = session.createQuery(sql);
			query.setParameter("deptNo", "D10");

			// Thực hiện truy vấn
			List<Employee> employees = query.list();

			for (Employee employee : employees) {
				System.out.println("Emp: " + employee.getEmpNO() + " : "
						+ employee.getEmpName());
			}

			// Commit dữ liệu
			// session.getTransaction().commit();
			// session.getTransaction().begin(); // Không được đóng session, nếu
			// không sẽ không truy vấn tiếp được

			String sql2 = "Select e from " + Employee.class.getName() + " e "
					+ " where e.empId=:empId ";
			query = session.createQuery(sql2);
			query.setParameter("empId", ((Number) 7369).longValue());
			employees = query.list();

			for (Employee employee : employees) {
				System.out.println("Emp: " + employee.getEmpNO() + " : "
						+ employee.getEmpName());
			}
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// Rollback trong trường hợp có lỗi xảy ra
			session.getTransaction().rollback();
		}
	}
}
