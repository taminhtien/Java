package com.tientm.hibernate.persist;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tientm.hibernate.entities.Employee;
import com.tientm.hibernate.entities.Timekeeper;
import com.tientm.hibernate.query.HibernateUtils;

public class SaveOrUpdateTransientDemo {
	private static DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

	private static Timekeeper persistTransient(Session session, Employee emp) {
		// Hãy chú ý:
		// timekeeperId cấu hình tự động được tạo ra bởi UUID.
		// @GeneratedValue(generator = "uuid")
		// @GenericGenerator(name = "uuid", strategy = "uuid2")
		// Tạo một đối tượng, nó đang có tình trạng Transient.
		Timekeeper tk3 = new Timekeeper();
		tk3.setEmployee(emp);
		tk3.setInOut(Timekeeper.IN);
		tk3.setDateTime(new Date());

		// Lúc này "tk3" đang có tình trạng Transient
		System.out.println("- tk3 persistent? " + session.contains(tk3));

		System.out.println("- Call saveOrUpdate(tk3)...");
		// Tại đây Hibernate sẽ kiểm tra, tk3 có ID chưa (timekeeperId)
		// Nếu chưa có nó tự gán ID vào.
		session.saveOrUpdate(tk3);

		// tk3 đã được gắn ID
		System.out
				.println("- tk3.getTimekeeperId() = " + tk3.getTimekeeperId());

		// Lúc này "tk3" đã có trạng thái Persistent
		// Nó đã được quản lý trong Session
		// Nhưng chưa có hành động gì insert, hoặc update xuống DB
		System.out.println("- tk3 persistent? " + session.contains(tk3));

		System.out.println("- Call flush...");
		// Chủ động đẩy dữ liệu xuống DB, gọi flush().
		// Nếu không gọi flush() dữ liệu sẽ được đẩy xuống tại lệnh commit().
		// Lúc này có thể có Insert hoặc Update xuống DB. (!!!)
		// Tùy thuộc vào ID của 'tk3' có trên DB chưa.
		session.flush();

		System.out.println("- timekeeperId = " + tk3.getTimekeeperId());
		System.out.println("- inOut = " + tk3.getInOut());
		System.out.println("- dateTime = " + df.format(tk3.getDateTime()));
		return tk3;

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
