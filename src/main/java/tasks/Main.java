package tasks;

import java.io.*;

public class Main {
	public static void main(String[] args) {

		File file=new File("src/main/resources/text.csv");

		try (FileReader fileReader = new FileReader(file)) {

			BufferedReader bufferedReader=new BufferedReader(fileReader);

			String line;


			while ((line=bufferedReader.readLine())!=null){

				String[] words = line.split(",");

				for (String word : words) {
					System.out.println(word);
				}
			}

			bufferedReader.close();

		} catch (IOException e) {
			throw new RuntimeException(e);
		}


	}


}
