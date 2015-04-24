import java.util.HashMap;

public class Collections {
	public static void main(String[] args) {
		HashMap<String, Integer> contact = new HashMap<String, Integer>();
		contact.put("Joy", 34543);
		contact.put("Jack", 56765);
		contact.put("Tina", 34567);
		
		System.out.println(contact);
		System.out.println(contact.containsValue("3443") ? "Exist 3443!" : "Not Exist 3443!");
		System.out.println(contact.containsKey("Jack") ? "Exist Jack!" : "Not Exist Jack!");
		System.out.println("Tina: " + contact.get("Tina"));
		contact.remove("Joy");
		System.out.println(contact);
	}
}
