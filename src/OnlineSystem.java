import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.nio.file.Files;


public class OnlineSystem {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new OnlineSystem().logInMenu();
	}
	
	// File reading and Scanner-------------------------------------------------------------------------------
	//private final String PATH = "C:\\Users\\katec\\eclipse-workspace-OOSD\\OOSD CW Two\\src\\csvfile_oo.csv";
	
	// FIRST ATTEMPT AT FILE REFERENCING----------------------------------------------------------------------
	String fileToParse = "/OOSD CW Two/src/csvfile_oo.csv";
	BufferedReader fileReader = null;
	final String DELIMITER =","; {
		try {
			String line = " ";
			fileReader = new BufferedReader(new FileReader(fileToParse));
			
			while ((line = fileReader.readLine()) != null) {
				String[] tokens = line.split(DELIMITER);
				
				for(String token : tokens) {
					System.out.println(token);
				}
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			try {
				fileReader.close();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// SECOND ATTEMPT AT FILE REFERENCING
	static ArrayList<Driver> driversArray = new ArrayList<Driver>();
	public static void loadDrivers() throws Exception {
		Driver drivers = new Driver(null, null, false, false, null);
		FileReader file = new FileReader("C:\\Users\\katec\\eclipse-workspace-OOSD\\OOSD CW Two\\src\\csvfile_oo.csv");
		Scanner readFile = new Scanner(file);
		int index = 0;
		
		while (readFile.hasNext()) {
			String userName = readFile.next();
			String passWord = readFile.next();
			boolean assigned = readFile.nextBoolean();
			boolean isManager = readFile.nextBoolean();
			String depotID = readFile.next();
			
			driversArray.add(new Driver (userName, passWord, assigned, isManager, depotID));
			driversArray[index] = new Driver(userName, passWord, assigned, isManager, depotID);
			index++;
		}
		for (int = 0; i < driversArray.length; i++) {
			System.out.println(rooms[i].toString());
		}
		System.out.println(driversArray);
		readFile.close();
	}
	
	// Scanner------------------------------------------------------------------------------------------------
	public final Scanner S = new Scanner(System.in);
	private Driver driver;
	private List<Depot> depots = new ArrayList<Depot>();
	private Depot depot;
	
	// Initial menu-------------------------------------------------------------------------------------------
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
		System.exit(0);
	}
	
	// Method for log in--------------------------------------------------------------------------------------
	public void logIn() throws Exception {

		
	}
	
	// Main interface menu, more options for managers---------------------------------------------------------
	private void mainMenu () throws Exception {
		String choice;
		
		if (driver.getIsManager()) {
			do {
				System.out.println("Welcome! Please select an option: ");
				System.out.println("1 - Create, Set or View Work Schedule");
				System.out.println("2 - View, Re-Assign or Add Vehicles");
				System.out.println("3 - Add Driver to System");
				System.out.println("4 - Quit");
				System.out.println("Enter option: ");
				choice = S.nextLine();
				
				switch (choice) {
					
					case "1":
						scheduleOptions();
						break;
					case "2":
						vehicleOptions();
						break;
					case "3":
						addDriver();
						break;
					case "4":
						logInMenu();
						break;
				}
			} while (true);
		} else {
			do {
				System.out.println("Welcome! Please select an option");
				System.out.println("1 - View Work Schedule");
				System.out.println("2 - Quit");
				System.out.println("Enter option: ");
				choice = S.nextLine();
				
				switch (choice) {
				
					case "1":
						System.out.println(driver.getSchedule());
						break;
					case "2":
						logInMenu();
						break;
				}
			} while (true);
		}
	}
	
	// Schedule Menu for Managers-------------------------------------------------------------------------
	public void scheduleOptions() throws Exception {
		String choice;
		
		do {
			System.out.println("Please select an option");
			System.out.println("1 - View Work Schedule");
			System.out.println("2 - Create Work Schedule");
			System.out.println("3 - Set Work Schedule");
			System.out.println("4 - View Completed Work Schedules");
			System.out.println("5 - Quit");
			System.out.println("Enter option: ");
			choice = S.nextLine();
			
			switch (choice) {
			
				case "1":
					System.out.println(driver.getSchedule());
					break;
				case "2":
					createSchedule();
					break;
				case "3":
					setSchedule();
					break;
				case"4":
					depot.completedScheduleList();
					break;
				case "5":
					mainMenu();
					break;
			}
		} while (true);
	}
	
	// Vehicle Menu for managers--------------------------------------------------------------------------
	public void vehicleOptions() throws Exception {
		String choice;
		
		do {
			System.out.println("Please select an option: ");
			System.out.println("1 - View Vehicles");
			System.out.println("2 - Add Vehicle");
			System.out.println("3 - Re-Assign Vehicle");
			System.out.println("4 - Quit");
			System.out.println("Enter option: ");
			choice = S.nextLine();
			
			switch (choice) {
			
				case "1":
					depot.vehicleList();
					break;
				case "2":
					addVehicle();
					break;
				case "3":
					reAssignVehicle();
					break;
				case "4":
					mainMenu();
					break;
			}
		} while (true);
	}
	
	// Method for setting a created schedule--------------------------------------------------------------
	public void setSchedule() {
		String client;
		String driver;
		boolean exit = false;
		boolean availableClient = false;
		boolean availableDriver = false;
		
		if(depot.getSchedules().isEmpty() && !depot.getUnassignedSchedules().isEmpty()) {
			System.out.println("No unssigned work schedules to view!");
			return;
		}
		depot.unassignedScheduleList();
		System.out.println("Enter the name of the client associated with the schedule you want to assign: ");
		client = S.nextLine();
		
		for(WorkSchedule ws : depot.getSchedules()) {
			if (client.equals(ws.getClient())) {
				availableClient = true;
				System.out.printf("%n%20s%n", "Drivers List");
				depot.driverList();
				System.out.println("Please select a driver: ");
				driver = S.nextLine();
				for (Driver drivers : depot.getDrivers()) {
					if (driver.equals(drivers.userName) && drivers.getSchedule() == null) {
						availableDriver = true;
						System.out.println(driver + " has been assigned to the schedule set for " + client);
						depot.getDriver(driver).setSchedule(depot.getWSchedule(client));
						drivers.setAssigned(true);
						ws.setDriverAssigned(depot.getDriver(driver));
						exit = true;
						assignVehicle(depot.getDriver(driver), ws);
						break;
					} else if ((!driver.equals(driver.userName) && drivers.getSchedule() != null)) {
						availableDriver = false;
					}
				}
				break;
			} else {
				availableClient = false;
			}
		}
		if (!availableClient) {
			System.out.println("Invalid client!")
		} else if (!availableDriver) {
			System.out.println("Invalid or unavailable driver!")
		}
	}
	
	public void assignVehicle(Driver driver, WorkSchedule ws) {
		boolean exit = false;
		if (depot.getVehicles().isEmpty() && depot.getUnassignedVehicles().isEmpty()) {
			System.out.println("No vehicles found!");
			return;
		}
		do {
			depot.Un
		}
	}
	// This method allows us to add a new driver to the system--------------------------------------------
	public void addDriver() {
		String name;
		String password;
		String newManager;
		boolean isManager = false;
		boolean exit = false;
		do {
			System.out.println("Enter name: ");
			name = S.nextLine().trim();
			if (!name.matches(".*\\d.*") && isUserNameUnique(name)) {
				
				System.out.println("Enter password: ");
				password = S.nextLine().trim();
				
				System.out.println("Make new driver a manager?: (yes or no)");
				newManager = S.nextLine().toLowerCase();
				if (newManager.contains("yes")) {
					isManager = true;
				} else if (newManager.contains("no")) {
					isManager = false;
				}
				depot.addDriver(new Driver(name, password, false, isManager, getDepot()));
				System.out.println(name + " has been added to the system as a new driver!");
				exit = true;
				break;
			} else {
				System.out.println("Username already exists!");
			}
		} while (!exit);
	}
	
	// This method allows us to create a schedule---------------------------------------------------------
	public void createSchedule() {
		String client;
		String startDate;
		String endDate;
		
		do {
			System.out.print("Client name: ");
			client = S.nextLine();
			System.out.println("Start date: ");
			startDate = S.nextLine();
			System.out.println("End date: ");
			endDate = S.nextLine();
			
			try {
				depot.addCreatedSchedule(new WorkSchedule(client, LocalDate.parse(startDate), LocalDate.parse(endDate)));
				sortSchedule();
				System.out.println("New work schedule created!");
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Invalid date entered!");
			}
		} while (true);
	}
	
	public void sortSchedule() {
		
	}
	
	public void reAssignVehicle() {
		
	}
	
	public void addVehicle() throws Exception {
		
	}
	
	public void isUserNameUnique(String userName) {
		ArrayList<Driver> drivers;
		for (Depot depot : depots) {
			drivers = depot.getDrivers();
			for (Driver d : drivers) {
				if (userName.equals(d.userName)) {
					return false;
				}
			}
		} return true;
	}
	

	
}
