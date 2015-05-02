package com.tientm.hibernate.query;

import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.tientm.hibernate.entities.Department;
import com.tientm.hibernate.entities.Employee;

public class UniqueResultDemo {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.getTransaction().begin();
			Department dept = getDepartment(session, "D20");
			Set<Employee> emps = dept.getEmployees();
			System.out.println("Dept Name: " + dept.getDeptName());

			for (Employee emp : emps) {
				System.out.println("Emp Name: " + emp.getEmpName());
			}

			Employee emp = getEmployee(session, 7839L);
			System.out.println("Emp Name: " + emp.getEmpName());
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}

	private static Employee getEmployee(Session session, long empId) {
		Criteria crit = session.createCriteria(Employee.class);
		crit.add(Restrictions.eq("empId", empId));
		return (Employee) crit.uniqueResult();
	}

	private static Department getDepartment(Session session, String deptNo) {
		String sql = "Select d from " + Department.class.getName()
				+ " d where d.deptNo=:deptNo";
		Query query = session.createQuery(sql);
		query.setParameter("deptNo", deptNo);
		return (Department) query.uniqueResult();
	}

}
