package com.tientm.hibernate.persist;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.tientm.hibernate.entities.Department;
import com.tientm.hibernate.entities.Employee;

public class DataUtils {

	public static Department findDepartment(Session session, String deptNo) {

		Criteria crit = session.createCriteria(Department.class);
		crit.add(Restrictions.eq("deptNo", deptNo));
		return (Department) crit.uniqueResult();

		/*
		 * String sql = "Select d from " + Department.class.getName() +
		 * " d where d.deptNo=:deptNo"; Query query = session.createQuery(sql);
		 * query.setParameter("deptNo", deptNo); return (Department)
		 * query.uniqueResult();
		 */
	}

	public static Long getMaxEmpId(Session session) {
		String sql = "Select max(e.empId) from " + Employee.class.getName()
				+ " e";
		Query query = session.createQuery(sql);
		Long value = (Long) query.uniqueResult();
		if (value == null) {
			return 0L;
		} else {
			return value;
		}
	}

	public static Employee findEmployee(Session session, String empNO) {
		Criteria crit = session.createCriteria(Employee.class);
		crit.add(Restrictions.eq("empNO", empNO));
		return (Employee) crit.uniqueResult();
	}
}
