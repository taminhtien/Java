package com.tientm.hibernate.persist;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tientm.hibernate.entities.Employee;
import com.tientm.hibernate.entities.Timekeeper;
import com.tientm.hibernate.query.HibernateUtils;

public class PersistTransientDemo {
	private static DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

	private static Timekeeper persistTransient(Session session, Employee emp) {
		// Hãy chú ý:
		// timekeeperId cấu hình tự động được tạo ra bởi UUID.
		// @GeneratedValue(generator = "uuid")
		// @GenericGenerator(name = "uuid", strategy = "uuid2")
		// Tạo một đối tượng, nó đang có tình trạng Transient.
		Timekeeper tk1 = new Timekeeper();
		tk1.setEmployee(emp);
		tk1.setInOut(Timekeeper.IN);
		tk1.setDateTime(new Date());

		// Lúc này "tk1" đang có tình trạng Transient
		System.out.println("- tk1 persistent? " + session.contains(tk1));
		
		System.out.println("- Call persist(tk1)...");
		// Hibernate gắn Id cho "tk1", chưa có insert
		session.persist(tk1);
		
		// tk1 đã được gắn ID
		System.out.println("- tk1.getTimekeeperId() = " + tk1.getTimekeeperId());

		// Lúc này "tk1" đã có trạng thái Persistent
		// Nó đã được quản lý trong Session
		// Nhưng chưa có hành động gì insert xuống DB
		System.out.println("- tk1 persistent? " + session.contains(tk1));
		
		System.out.println("- Call flush...");
		// Chủ động đẩy dữ liệu xuống DB, gọi flush().
		// Nếu không gọi flush() dữ liệu sẽ được đẩy xuống tại lệnh commit().
		// Lúc này mới có insert.
		session.flush();
		
		System.out.println("- timekeeperId = " + tk1.getTimekeeperId());
		System.out.println("- inOut = " + tk1.getInOut());
		System.out.println("- dateTime = " + df.format(tk1.getDateTime()));
		return tk1;

	}

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		Employee emp = null;
		try {
			session.getTransaction().begin();
			emp = DataUtils.findEmployee(session, "E7499");
			// Thêm vào bảng TimeKeeper thời gian hoạt động của emp
			persistTransient(session, emp);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
}
