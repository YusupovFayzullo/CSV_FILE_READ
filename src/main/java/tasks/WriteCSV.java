package tasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteCSV {
	public static void main(String[] args) {
		File file=new File("src/main/resources/hello.csv");

		String text="kjrkej kejir  kfherihij okewokfo";

		try (PrintWriter printWriter = new PrintWriter(file)) {


			for (int i = 0; i < text.length(); i++) {
				if(text.charAt(i)==' ') printWriter.print(",");
				else printWriter.print(text.charAt(i));
			}


			printWriter.flush();

		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
