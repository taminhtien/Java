package com.tientm.hibernate.persist;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.tientm.hibernate.entities.Department;
import com.tientm.hibernate.query.HibernateUtils;

// Update 1 đối tượng Persistent thì dùng flush hoặc session commit
// Insert 1 đối tượng Transient thì dùng persist, save
public class UpdateDataDemo {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.getTransaction().begin();
			Criteria crit = session.createCriteria(Department.class);
			crit.add(Restrictions.eq("deptNo", "D10"));
			Department dept = (Department) crit.uniqueResult();
			// System.out.println(dept.getDeptName());
			Department d1 = new Department();
			d1.setDeptName("CODER 3");
			d1.setDeptId(50);
			d1.setDeptNo("D50");
			d1.setLocation("Viet Nam");
			// session.persist(d1); // Chỉ dùng để insert
			// session.save(d1); // Chỉ dùng để insert
			// session.saveOrUpdate(d1); // Nếu trùng thì update
			session.merge(d1); // Nếu trùng thì update
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
}
