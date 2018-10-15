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
		Scanner formulas;
		PrintWriter results;
		try{
			File f = new File("formulas.txt");
			File r = new File("results.txt");
			formulas = new Scanner(f);
			results = new PrintWriter(r);

			while (formulas.hasNextLine()){
				String line = formulas.nextLine();
				System.out.println("read <" + line + ">");

				List<String> list = new ArrayList<>(Arrays.asList(line.split(" ")));
				double a = Double.parseDouble(list.get(0));
				double b = Double.parseDouble(list.get(2));
				double res;

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

				System.out.println(list.get(0) + ' ' + list.get(1) + ' ' + list.get(2) + " = " + res);
				results.println(list.get(0) + ' ' + list.get(1) + ' ' + list.get(2) + " = " + res);
			}
		}
		catch (FileNotFoundException e){
			System.out.println("File not found " + e.toString());
		}
	}
}
