import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class OnlineSystem {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new OnlineSystem().logInMenu();

	}

	
	public static ArrayList<Driver> drivers = new ArrayList<>();
	Scanner console = new Scanner(System.in);
	
	
	
//	private static void getDrivers() throws FileNotFoundException {
//		 Scanner file = new Scanner(new File("/Users/adamal-najjar/Desktop/OO CW/csvfile_oo.csv"));
//		 file.useDelimiter(",");
	
//	file = new BufferedReader(new FileReader("/Users/adamal-najjar/Desktop/OO CW/csvfile_oo.csv"))
	
	//importing csv file that needs to be parsed.
	String fileToParse = "/Users/adamal-najjar/Desktop/OO CW/csvfile_oo.csv";
	BufferedReader fileReader = null;
	
	//delimiter
	final String DELIMITER = ",";
	
	try
	{
		String line = " ";
		// Create the file reader
		fileReader = new BufferedReader(new FileReader(fileToParse));
		
		//read the file line by line
		 while ((line = fileReader.readLine()) != null) 
		 {
			 String[] tokens = line.split(DELIMITER);
			 for (String token : tokens)
			 {
				 //print all tokens
				 System.out.println(token);
			 }
			 
		 }
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	finally
    {
        try {
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

	
		
		
		
//		while (file.hasNext()) {
//			Driver driverData = new Driver(
//					file.next(), 
//					file.next(), 
//					file.next(), 
//					file.next(),
//					file.nextBoolean(), 
//					file.nextBoolean());
//			drivers.add(driverData);
//			
//		}
//		for (Driver driver : drivers) {
//		 //System.out.println(drivers.toString());
//		}
//	
//	}
//	
	
	private final String PATH =
	public final Scanner S = new Scanner(System.in);
	private Driver driver;
	
	public void logInMenu() throws Exception {
		String choice;
		
		do {
			System.out.println("Please Log In to view Menu");
			System.out.println("1 - Log In");
			System.out.println("1 - Exit");
			System.out.print("Enter option: ");
			choice = S.nextLine();
			
			switch (choice) {
				
				case "1":
					logIn();
					break;
			}
		} while (!choice.equals("2"));
		S.close();
	}
	
	public void logIn() throws Exception {
		
	}

}
