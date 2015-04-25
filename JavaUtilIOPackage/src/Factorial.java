import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Factorial {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("Input n: ");
		int n = new Scanner(System.in).nextInt();
		BigInteger factorial = new BigInteger("1");
		for (int i = 1; i <= n; i++) {
			factorial = factorial.multiply(new BigInteger(Integer.toString(i)));
		}
		System.out.println(n + "! = " + factorial);
	}

}
