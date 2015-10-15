import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class Attendance {

	public static void main(String[] args) throws FileNotFoundException {
		String first_name = " ", last_name = " ";
		char answer = ' ';


		File members = new File("java_members");
		FileInputStream fis = new FileInputStream(members);
		Scanner keyboard = new Scanner(System.in);
		Scanner reader = new Scanner(fis);

		String name_of_file = "Attendance date_" + cal();
		FileOutputStream fos = new FileOutputStream(name_of_file);
		PrintWriter pw = new PrintWriter(fos);


		while(reader.hasNextLine())
		{
			first_name = reader.next();
			last_name = reader.next();

			System.out.printf("Is %s %s present or absent?%n", first_name, last_name);
			System.out.println("Type 'P' or 'A': ");
			answer = keyboard.next().toUpperCase().charAt(0);

			if (answer == 'P')
				pw.printf("%s %s Present%n", first_name, last_name);
			else if (answer == 'A')
				pw.printf("%s %s Absent%n", first_name, last_name);
			else
				pw.printf("%s %s ???%n", first_name, last_name);



		}

		pw.close();
		reader.close();
		keyboard.close();
	}

	public static String cal()
	{

		Calendar cal = Calendar.getInstance();
		Date date_object = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		String date_formatted = sdf.format(date_object);

		return date_formatted;
	}

}
