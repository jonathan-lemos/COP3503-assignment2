import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.lang.IllegalArgumentException;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class ReadFileLineByLine{
	public static void main(String[] args) {
		try{
			// opens "formulas.txt"
			File fileFormulas = new File("formulas.txt");
			// opens "results.txt"
			File fileResults = new File("results.txt");
			// opens "formulas.txt" for reading. this will throw a FileNotFoundException if it does not exist. said exception is caught below
			Scanner scannerFormulas = new Scanner(fileFormulas);
			// opens "results.txt" for writing. this file will be overwritten if it already exists
			PrintWriter pwResults = new PrintWriter(fileResults);

			// while there are lines in "formulas.txt"
			while (scannerFormulas.hasNextLine()){
				// read a line
				String line = scannerFormulas.nextLine();
				// display the line we read
				System.out.println("read <" + line + ">");

				// this has to be an arraylist for some bizarre reason even though a regular array would have been just fine
				// this makes an array list of out the line split with the regex "\s+" which matches one or more whitespace chars
				List<String> list = new ArrayList<>(Arrays.asList(line.split("\\s+")));

				// ain't nobody got time to make sure there's 3 tokens lmao

				// parse first number
				double a = Double.parseDouble(list.get(0));
				// parse second number
				double b = Double.parseDouble(list.get(2));
				double res;

				// switch based on the operator
				switch (list.get(1)){
					case "+":
						res = a + b;
						break;
					case "-":
						res = a - b;
						break;
					case "*":
						res = a * b;
						break;
					case "/":
						res = a / b;
						break;
					default:
						throw new IllegalArgumentException("Only operators +-*/ are supported");
				}

				// write line to stdout
				System.out.println(list.get(0) + ' ' + list.get(1) + ' ' + list.get(2) + " = " + res);
				// also write line to PrintWriter
				pwResults.println(list.get(0) + ' ' + list.get(1) + ' ' + list.get(2) + " = " + res);
			}

			scannerFormulas.close();
			// this line makes sure the data is flushed out of the PrintWriter into our file
			pwResults.close();
		}
		catch (FileNotFoundException e){
			System.out.println("File not found " + e.toString());
		}
	}
}
