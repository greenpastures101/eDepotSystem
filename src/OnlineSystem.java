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
	
	private final String PATH = "C:\\Users\\katec\\eclipse-workspace-OOSD\\OOSD CW Two\\src\\csvfile_oo.csv";
	public final Scanner S = new Scanner(System.in);
	private Driver driver;
	private Depot depot;
	
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
		driver = null;
		String username;
		String password;
		boolean exit = false;
		boolean match = false;
		
		do {
			System.out.println("Enter username: ");
			username = S.nextLine();
			
			System.out.println("Enter password: ");
			password = S.nextLine();
			if (depot.verify(username.trim(), password.trim())) {
				//driver = depot.getDrivers(username);
				exit = true;
				match = true;
				break;
			} if (!match) {
				System.out.print("Incorrect username or password!");
			}
			
		} while (!exit);
		mainMenu();
	}
	
	private void mainMenu () throws Exception {
		String choice;
		
		System.out.println("test");
		choice = S.nextLine();
	}

}
