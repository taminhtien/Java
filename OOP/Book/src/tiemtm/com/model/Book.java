package tiemtm.com.model;

public class Book {
	private String name;
	private Author author;
	private double price;
	private int qtyInSock;

	public Book(String name, Author author, double price) {
		super();
		this.name = name;
		this.author = author;
		this.price = price;
	}

	public Book(String name, Author author, double price, int qtyInSock) {
		super();
		this.name = name;
		this.author = author;
		this.price = price;
		this.qtyInSock = qtyInSock;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQtyInSock() {
		return qtyInSock;
	}

	public void setQtyInSock(int qtyInSock) {
		this.qtyInSock = qtyInSock;
	}

	public String getName() {
		return name;
	}

	public Author getAuthor() {
		return author;
	}

	public String toString() {
		return name + " by " + author.getName() + " (" + author.getGender()
				+ ")" + " at " + author.getEmail();
	}

}
