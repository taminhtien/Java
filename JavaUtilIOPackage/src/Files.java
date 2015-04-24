import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Files {
	public static void main(String[] args) {
		try {
			BufferedReader input = new BufferedReader(new FileReader(
					"input.txt"));
			BufferedWriter output = new BufferedWriter(new FileWriter(
					"output.txt"));
			String line;
			while ((line = input.readLine()) != null) {
				output.write(line);
				System.out.println(line + " wrote..");
				output.newLine();
			}
			input.close();
			output.close();
			System.out.println("Done!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
