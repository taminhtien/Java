package com.tientm.hibernate.persist;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tientm.hibernate.entities.Employee;
import com.tientm.hibernate.entities.Timekeeper;
import com.tientm.hibernate.query.HibernateUtils;

/**
 * Change Transient data to Persistent data using save(Object)
 * 
 * @author tientm
 *
 */
public class SaveTransientDemo {
	private static DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

	private static Timekeeper persistTransient(Session session, Employee emp) {
		// Hãy chú ý:
		// timekeeperId cấu hình tự động được tạo ra bởi UUID.
		// @GeneratedValue(generator = "uuid")
		// @GenericGenerator(name = "uuid", strategy = "uuid2")
		// Tạo một đối tượng, nó đang có tình trạng Transient.
		Timekeeper tk2 = new Timekeeper();
		tk2.setEmployee(emp);
		tk2.setInOut(Timekeeper.OUT);
		tk2.setDateTime(new Date());

		// Lúc này "tk2" đang có tình trạng Transient
		System.out.println("- tk2 persistent? " + session.contains(tk2));

		System.out.println("- Call save(tk2)...");
		// Sử dụng save function để chuyển đối tượng thành persistent
		// save() rất giống với persist()
		// save() trả về ID còn persist() là void.
		// Hibernate gán Id vào 'tk2', sẽ chưa có insert gì cả
		// Nó trả về ID của 'tk2'.
		String id = (String) session.save(tk2);

		// tk2 đã được gắn ID
		System.out.println("- session.save(tk2) = " + id);
		System.out
				.println("- tk2.getTimekeeperId() = " + tk2.getTimekeeperId());

		// Lúc này "tk2" đã có trạng thái Persistent
		// Nó đã được quản lý trong Session
		// Nhưng chưa có hành động gì insert xuống DB
		System.out.println("- tk2 persistent? " + session.contains(tk2));

		System.out.println("- Call flush...");
		// Chủ động đẩy dữ liệu xuống DB, gọi flush().
		// Nếu không gọi flush() dữ liệu sẽ được đẩy xuống tại lệnh commit().
		// Lúc này mới có insert.
		session.flush();

		System.out.println("- timekeeperId = " + tk2.getTimekeeperId());
		System.out.println("- inOut = " + tk2.getInOut());
		System.out.println("- dateTime = " + df.format(tk2.getDateTime()));
		return tk2;

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
