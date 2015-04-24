import java.util.Scanner;


public class StringTokenizer {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("Input a number phone: ");
		String numberPhone = new Scanner(System.in).nextLine();
		//String numberPhone = "(091) 022-6758080";
		java.util.StringTokenizer st = new java.util.StringTokenizer(numberPhone, "()-");
		System.out.println("Nation Code: " + st.nextToken().trim());
		System.out.println("Region Code: " + st.nextToken().trim());
		System.out.println("Number Phone: " + st.nextToken().trim());
	}
}
