import java.util.Arrays;
import java.util.Scanner;

public class Square {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("Input intefer array: ");
		String line = new Scanner(System.in).nextLine();
		String arrLine[] = line.split(" ");
		int arr[] = new int[arrLine.length];
		for (int i = 0; i < arrLine.length; i++) {
			arr[i] = Integer.parseInt(arrLine[i].toString());
		}
		Arrays.sort(arr);
		System.out.println("Max: " + arr[arr.length - 1]);
		System.out.println("Square of Max: " + Math.pow(arr[arr.length - 1], 2));
		System.out.println("Min: " + arr[0]);
		System.out.println("Square of Min: " + Math.pow(arr[0], 2));

	}
}