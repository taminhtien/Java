package com.tientm.hibernate.persist;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tientm.hibernate.entities.Employee;
import com.tientm.hibernate.entities.Timekeeper;
import com.tientm.hibernate.query.HibernateUtils;

public class MergeTransientDemo {
	private static DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

	private static Timekeeper saveOrUpdate_Transient(Session session,
			Employee emp) {
		// Hãy chú ý:
		// timekeeperId cấu hình tự động được tạo ra bởi UUID.
		// @GeneratedValue(generator = "uuid")
		// @GenericGenerator(name = "uuid", strategy = "uuid2")
		// Tạo một đối tượng, nó đang có tình trạng Transient.
		Timekeeper tk4 = new Timekeeper();

		tk4.setEmployee(emp);
		tk4.setInOut(Timekeeper.IN);
		tk4.setDateTime(new Date());

		// Lúc này 'tk4' đang có tình trạng Transient.
		System.out.println("- tk4 Persistent? " + session.contains(tk4));

		System.out.println("====== CALL merge(tk).... ===========");

		// Hibernate2 có method copyOrUpdateCopy
		// phiên bản 3 trở nó đổi tên thành merge.
		// (Vì vậy sẽ có sự tương đồng).
		// Tại đây Hibernate sẽ kiểm tra, tk4 có ID (timekeeperId) chưa
		// Nếu chưa có nó tự gán ID vào.
		// Sau đó tạo ra một bản copy và trả về.
		Timekeeper tk4Copy = (Timekeeper) session.merge(tk4);

		System.out
				.println("- tk4.getTimekeeperId() = " + tk4.getTimekeeperId());

		// Chú ý:
		// Lúc này 'tk4' vẫn có trạng thái Transient.
		// còn 'tk4Copy' thì có trạng thái Persistent.
		// Nhưng chưa có hành động gì insert, hoặc update xuống DB.
		// ==> false
		System.out.println("- tk4 Persistent? " + session.contains(tk4));

		// 'tk4Copy' có trạng thái Persistent.
		// ==> true
		System.out
				.println("- tk4Copy Persistent? " + session.contains(tk4Copy));

		System.out.println("- Call flush..");
		// Chủ động đẩy dữ liệu xuống DB, gọi flush().
		// Nếu không gọi flush() dữ liệu sẽ được đẩy xuống tại lệnh commit().
		// Lúc này có thể có Insert hoặc Update xuống DB. (!!!)
		// Tùy thuộc vào ID của 'tk4' có trên DB chưa.
		session.flush();

		// 'tk4' vẫn là Transient, sau khi flush().
		// Nhận xét: merge(..) an toàn hơn so với saveOrUpdate().
		System.out.println("- tk4 Persistent? " + session.contains(tk4));

		//
		String timekeeperId = tk4.getTimekeeperId();
		System.out.println("- timekeeperId = " + timekeeperId);
		System.out.println("- inOut = " + tk4.getInOut());
		System.out.println("- dateTime = " + df.format(tk4.getDateTime()));
		System.out.println();
		return tk4;
	}

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();

		Session session = factory.getCurrentSession();
		Employee emp = null;
		try {
			session.getTransaction().begin();

			emp = DataUtils.findEmployee(session, "E7499");

			saveOrUpdate_Transient(session, emp);

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
}
