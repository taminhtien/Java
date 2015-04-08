package tientm.com.test;

import tiemtm.com.model.Author;
import tiemtm.com.model.Book;

public class TestAuthor {
	public static void main(String[] args) {
		Author anAuthor = new Author("Tan Ah Teck", "ahteck@somewhere.com", 'm');
		System.out.println(anAuthor);
		anAuthor.setEmail("taminhtien1993@gmail.com");
		System.out.println(anAuthor);
		Book aBook = new Book("Java for dummy", anAuthor, 19.95, 1000);
		System.out.println(aBook);
		// User anonymous instance
		Book aBook1 = new Book("Java for dummy 2", new Author("Tien Ta",
				"taminhtien1993@gmail.com", 'm'), 21.95, 3000);
		System.out.println(aBook1);
	}
}
