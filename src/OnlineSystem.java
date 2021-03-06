import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Katlynn Chrans 904788
 * @author Adam Al-Najjar 678948
 * Class contains the menus used to navigate the methods for system function
 */

/**
 * Main method which calls the initial log in menu
 */
public class OnlineSystem {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new OnlineSystem().logInMenu();
	}
	
	public OnlineSystem() throws Exception {
		deSerialize();
		
		// NOTE: Debugging
		/*
		WorkSchedule boJack = new WorkSchedule("BoJack", LocalDate.parse("2022-04-04"), LocalDate.parse("2022-04-05"));
		depots.get(0).addCreatedSchedule(boJack);
		*/
		
		/*
		depots.add(new Depot("LPool")); // 0
		depots.add(new Depot("Leeds")); // 1
		depots.add(new Depot("MChester")); // 2
		
		depots.get(0).addDriver(new Driver("Glyn", "glyn1", true, true, getDepot("LPool"))); // available, manager
		depots.get(0).addDriver(new Driver("Kirsty", "kirsty1", true, false, getDepot("LPool"))); // available, not manager
		depots.get(0).addDriver(new Driver("Samwise", "samwise1", false, false, getDepot("LPool"))); // unavailable, not manager
		depots.get(0).addDriver(new Driver("Smaug", "smaug1", false, false, getDepot("LPool"))); // unavailable, not manager
		
		depots.get(1).addDriver(new Driver("Frodo", "frodo1", true, true, getDepot("Leeds"))); // available, manager
		depots.get(1).addDriver(new Driver("Mark", "mark1", false, false, getDepot("Leeds"))); // unavailable, not manager
		depots.get(1).addDriver(new Driver("Gandalf", "gandalf1", true, false, getDepot("Leeds"))); // available, not manager
		depots.get(1).addDriver(new Driver("Legolas", "legolas1", false, false, getDepot("Leeds"))); // unavailable, not manager
		
		depots.get(2).addDriver(new Driver("Sorren", "sorren1",false, true, getDepot("MChester"))); // unavailable, manager
		depots.get(2).addDriver(new Driver("Andy", "andy1", true, false, getDepot("MChester"))); // available, not manager
		depots.get(2).addDriver(new Driver("Aragorn", "aragorn1", true, false, getDepot("MChester"))); // available, not manager
		depots.get(2).addDriver(new Driver("Gollum", "gollum1", false, false, getDepot("MChester"))); // not available, not manager

		Vehicle lPoolTanker = new Tanker("Volvo", "XC90", 14000.5, "WM15GUK", getDepot("LPool"), 2000.2, "Petrol");
		Vehicle lPoolTanker2 = new Tanker("Tesla", "69", 32000.5, "ET10EVN", getDepot("LPool"), 3100.7, "Rocket Fuel");
		Vehicle lPoolTruck = new Truck("BMW", "G7", 10000.5, "JK19DFF", getDepot("LPool"), 1300.4);
		Vehicle lPoolTruck2 = new Truck("Volvo", "HD3", 27000.5, "MN18JJJ", getDepot("LPool"), 4100.6);
		Vehicle lPoolTruck3 = new Truck("Jaguar", "3X", 30000.8, "DV12NMA", getDepot("LPool"), 5000.5);
		
		Vehicle leedsTanker = new Tanker("Volkswagon", "P50", 35000.9, "YR12MUN", getDepot("Leeds"), 4700.4, "Oil");
		Vehicle leedsTruck = new Truck("Farrari", "T7X4000", 37000.1, "II90BLL", getDepot("Leeds"), 4900.7);
		Vehicle leedsTruck2 = new Truck("Peugeot", "5DS", 17000.3, "TV15ERW", getDepot("Leeds"), 2400.2);
		
		Vehicle mChesterTanker = new Tanker("Honda", "XL7", 23000.2, "TH88KGN", getDepot("MChester"), 1200.9, "Diesel");
		Vehicle mChesterTanker2 = new Tanker("Audi", "K7", 46000.5, "QW12ERT", getDepot("MChester"), 2100.7, "Petrol");
		Vehicle mChesterTanker3 = new Tanker("Mercedes", "90V", 20000.4, "TW47FUC", getDepot("MChester"), 3400.0, "Oil");
		Vehicle mChesterTruck = new Truck("Porsche", "R80", 17000.9, "LN21DMV", getDepot("MChester"), 2600.6);
		Vehicle mChesterTruck2 = new Truck("Ford", "JX20", 34000.3, "MN19NFJ", getDepot("MChester"), 1700.2);
		
		depots.get(0).addVehicle(lPoolTanker);
		depots.get(0).addVehicle(lPoolTanker2);
		depots.get(0).addVehicle(lPoolTruck);
		depots.get(0).addVehicle(lPoolTruck2);
		depots.get(0).addVehicle(lPoolTruck3);
		
		depots.get(1).addVehicle(leedsTanker);
		depots.get(1).addVehicle(leedsTruck);
		depots.get(1).addVehicle(leedsTruck2);
		
		depots.get(2).addVehicle(mChesterTanker);
		depots.get(2).addVehicle(mChesterTanker2);
		depots.get(2).addVehicle(mChesterTanker3);
		depots.get(2).addVehicle(mChesterTruck);
		depots.get(2).addVehicle(mChesterTruck2);
		*/
	}	
	
	/**
	 * File path
	 */
	private final String PATH = "C:\\Users\\katec\\eclipse-workspace-OOSD\\OOSD CW Two\\src\\";
	
	/**
	 * Creating scanner and ArrayList for depot info
	 */
	public final Scanner S = new Scanner(System.in);
	private Driver driver;
	private List<Depot> depots = new ArrayList<Depot>();
	private Depot depot;
	private int depotNo = 0;
	
	/**
	 * Method lists depots
	 */
	public void depotList() {
		for (Depot depot : depots) {
			System.out.println(depot);
		}
	}
	
	/**
	 * Method for the initial log in menu allows user to log in or exit
	 * When exit is selected, any changes made during run are saved before termination of run
	 * @throws Exception
	 */
	public void logInMenu() throws Exception {
		String choice;
		
		do {
			System.out.println("Please Log In to view Menu");
			System.out.println("1 - Log In");
			System.out.println("2 - Exit");
			System.out.print("Enter option: ");
			choice = S.nextLine();
			
			switch (choice) {
				
				case "1":
					logIn();
					break;
			}
		} while (!choice.equals("2"));
		S.close();
		serialize();
		System.exit(0);
	}
	
	/**
	 * Method allows for serialization of objects before system terminates
	 */
	private void serialize() {
		ObjectOutputStream oos;
		try {
			
			oos = new ObjectOutputStream (new FileOutputStream(PATH + "depotInfo.ser"));
			oos.writeObject(depots);
			oos.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Methods allows for deserialization of objects before system start
	 */
	private void deSerialize() {
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream (new FileInputStream(PATH + "depotInfo.ser"));
			depots = (List<Depot>)ois.readObject();
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Method for a user to log in
	 * @throws Exception
	 */
	public void logIn() throws Exception {
		driver = null;
		String uName;
		String pWord;
		boolean exit = false;
		boolean valid = false;
		
		do {
			System.out.println("Please enter your username: ");
			uName = S.nextLine();
			System.out.println("Please enter your password: ");
			pWord = S.nextLine();
			for (depotNo = 0; depotNo < depots.size(); depotNo++) {
				depot = depots.get(depotNo);
				if (depot.verify(uName.trim(), pWord.trim())) {
				driver = depot.getDriver(uName);
				exit = true;
				valid = true;
				break;
			}
			} if (!valid) {
				System.out.println("Invalid login details please try again!");
			}
		} while (!exit);
		mainMenu();
	}
	
	/**
	 * Method outputs one of two menus depending is user logging in is a manger or not
	 * Menu contains all options within the system and calls other needed methods
	 * @throws Exception
	 */
	private void mainMenu () throws Exception {
		String choice;
		
		if (driver.getIsManager()) {
			do {
				System.out.println("Welcome to the " + depot.toString() + " online depot system! Please select an option: ");
				System.out.println("1 - Schedule Menu");
				System.out.println("2 - Vehicle Menu");
				System.out.println("3 - View Drivers");
				System.out.println("4 - Add Driver to System");
				System.out.println("5 - Quit");
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
						depot.driverList();
						break;
					case "4":
						addDriver();
						break;
					case "5":
						logInMenu();
						break;
				}
			} while (true);
		} else {
			do {
				System.out.println("Welcome " + driver.toString() + "!" + " Please select an option");
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
	
	/**
	 * Method which stores all the options to do with schedules
	 * Only viewable by managers, when quitting it directs back to the main menu
	 * @throws Exception
	 */
	public void scheduleOptions() throws Exception {
		String choice;
		
		do {
			System.out.println("Please select an option");
			System.out.println("1 - View Your Work Schedule");
			System.out.println("2 - View All Created Schedules");
			System.out.println("3 - Create Work Schedule");
			System.out.println("4 - Set Work Schedule");
			System.out.println("5 - Change Work Schedule To Complete");
			System.out.println("6 - View Completed Work Schedules");
			System.out.println("7 - Quit");
			System.out.println("Enter option: ");
			choice = S.nextLine();
			
			switch (choice) {
			
				case "1":
					System.out.println(driver.getSchedule());
					break;
				case "2":
					depot.scheduleList();
					break;
				case "3":
					createSchedule();
					break;
				case "4":
					setSchedule();
					break;
				case "5":
					setScheduleAsComplete();
				case"6":
					depot.completedScheduleList();
					break;
				case "7":
					mainMenu();
					break;
			}
		} while (true);
	}
	
	/**
	 * Method which stores all the options to do with vehicles
	 * Only viewable by managers, when quitting it directs back to the main menu
	 * @throws Exception
	 */
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
			}
		} while (true);
	}
	
	/**
	 * Method allows manager to add a new driver to the system (ArrayList)
	 */
	public void addDriver() {
		String name;
		String password;
		String newManager;
		boolean isManager = false;
		boolean exit = false;
		do {
			System.out.println("Please enter name: ");
			name = S.nextLine().trim();
			if (!name.matches(".*\\d.*") && isUserNameUnique(name)) {
				
				System.out.println("please enter password: ");
				password = S.nextLine().trim();
				
				System.out.println("Make " + name + " a manager?: (yes or no)");
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
				System.out.println("Username already exists please try again!");
			}
		} while (!exit);
	}
	
	/**
	 * Method ensures a driver is not adding using a duplicate name
	 * @param userName username used to create driver, searches to see if exists already
	 * @return returns false if a duplication is not found, returns true is duplication is found
	 */
	public boolean isUserNameUnique(String userName) {
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
	
	/**
	 * Method creates and adds a schedule to the system (ArrayList)
	 */
	public void createSchedule() {
		String client;
		String startDate;
		String endDate;
		
		
		do {
			System.out.print("Please enter client name: ");
			client = S.nextLine();
			System.out.println("Please enter start date [i.e. yyyy-mm-dd]: ");
			startDate = S.nextLine();
			System.out.println("Please enter end date [i.e. yyyy-mm-dd]: ");
			endDate = S.nextLine();
			
			try {
				depot.addCreatedSchedule(new WorkSchedule(client, LocalDate.parse(startDate), LocalDate.parse(endDate)));
				sortSchedule();
				System.out.println("New work schedule for " + client + " has been created!");
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Invalid date entered please try again!");
			}
		} while (true);
	}
	
	/**
	 * Method sorts the schedules in the system (ArrayList) by dates
	 */
	public void sortSchedule() {
		depot.getSchedules().sort(Comparator.comparing(WorkSchedule::getStartDate));
		depot.getCompletedSchedules().sort(Comparator.comparing(WorkSchedule::getStartDate));
	}
	
	/**
	 * Method sets a created schedule to a driver
	 */
	public void setSchedule() {
		String client;
		String driver;
		boolean exit = false;
		boolean registeredClient = false;
		boolean availableDriver = false;
		
		if(depot.getSchedules().isEmpty() && !depot.getUnassignedSchedules().isEmpty()) {
			System.out.println("All Schedules have been assigned!");
			return;
		}
		depot.unassignedScheduleList();
		System.out.println("Please enter client name of schedule to be assigned");
		client = S.nextLine();
		for (WorkSchedule ws : depot.getSchedules()) {
			if (client.equals(ws.getClient())) {
				registeredClient = true;
				System.out.println("Drivers currently at " + depot.toString() + "depot: ");
				depot.driverList();
				System.out.println("Please select a driver to assign " + client + "'s schedule to: ");
				driver = S.nextLine();
				
				for (Driver drivers : depot.getDrivers()) {
					if (driver.equals(drivers.userName) && drivers.getSchedule() == null) {
						availableDriver = true;
						System.out.println("The work schedule for " + client + "has been assigned to " + driver + "!");
						depot.getDriver(driver).setSchedule(depot.getWSchedule(client));
						drivers.setAssigned(true);
						ws.setDriverAssigned(depot.getDriver(driver));
						exit = true;
						assignVehicle(depot.getDriver(driver), ws);
						break;
					} else if ((!driver.equals(drivers.userName) && drivers.getSchedule() != null)) {
						availableDriver = false;
					}
				} break;
			} else {
				registeredClient = false;
			}
		}
		if (!registeredClient) {
			System.out.println("Invalid client please try again!");
		} else if (!availableDriver) {
			System.out.println("Invalid driver please try again!");
		}
	}
	
	/**
	 * Method used to assign a vehicle and driver to a created schedule
	 * @param driver driver to set schedule to
	 * @param ws schedule to be set
	 */
	public void assignVehicle(Driver driver, WorkSchedule ws) {
		boolean exit = false;
		
		if (depot.getVehicles().isEmpty() && depot.getUnassignedVehicles().isEmpty()) {
			System.out.println("No vehicles available please try again!");
			return;
		}
		
		do {
			depot.unAssignedVehicleList();
			System.out.println("Please enter registration number");
			String regNo = S.nextLine();
			
			for (Vehicle v : depot.getVehicles()) {
				if (regNo.equals(v.regNo) && v.driver == null && !regNo.isEmpty() && v.getWorkSchedule() == null) {
					v.setDriver(driver);
					v.setWorkSchedule(ws);
					ws.setVehicleAssigned(v);
					System.out.println("Vehicle " + regNo + " successfully assigned!");
					exit = true;
					return;
				} else {
					System.out.println("Invalid registration number please try again!");
				}
			}
			
		} while (exit);
	}
	
	/**
	 * Method to set a schedule as complete
	 * @throws Exception
	 */
	public void setScheduleAsComplete() throws Exception {
		String clientName;
		WorkSchedule ws;
		boolean exists = false;
		boolean assigned = false;
		boolean valid;
		
		if (depot.getSchedules().isEmpty()) {
			System.out.println("No active work schedules currently exist!");
			return;
		}
		depot.scheduleList();
		System.out.println("Please enter name of client of schedule to be set as complete: ");
		clientName = S.nextLine();
		for (WorkSchedule schedule : depot.getSchedules()) {
			if (clientName.equals(schedule.client) && schedule.getDriverAssigned() != null) {
				exists = true;
				assigned = true;
			} else {
				assigned = false;
			}
		} if (!assigned) {
			System.out.println("Invalid schedule no driver assigned please try again!");
			exists = true;
			return;
		}
		ws = depot.getWSchedule(clientName);
		depot.addCompletedSchedule(ws);
		depot.getSchedules().remove(ws);
		
		for (Driver driver : depot.getDrivers()) {
			if (driver.getSchedule() != null) {
				WorkSchedule ws1 = driver.getSchedule();
				String client = ws1.getClient();
				if (client.equals(ws.getClient())) {
					driver.setSchedule(null);
					driver.setAssigned(false);
					System.out.println(client + "'s schedule has been set as complete!");
					sortSchedule();
					removeVehicle(ws);
				} else {
					System.out.println("Invalid date please try again!");
				}
			}
		}
	}
	
	/**
	 * Removes a vehicle from a schedule which has been set as complete
	 * This is so the vehicle becomes available for new schedules
	 * @param ws schedule vehicle is removed from
	 */
	public void removeVehicle(WorkSchedule ws) {
		Vehicle v = depot.getVehicle(ws.getVehicleAssigned());
		v.setDriver(null);
		v.setWorkSchedule(null);
		return;
	}
	
	/**
	 * Method allows a manager to add a new vehicle to the system (ArrayList)
	 * @throws Exception
	 */
	public void addVehicle() throws Exception {
		String vehicleMake;
		String vehicleModel;
		String vehicleRegNo;
		String type;
		double weight = 0;
		double capacity = 0;
		boolean exit = false;
		boolean validEntry = false;
		
		do {
			System.out.println("Please enter vehicles make: ");
			vehicleMake = S.nextLine();
			if (!vehicleMake.matches(".*\\d.*") && !vehicleMake.isEmpty()) {
				System.out.println("Please enter vehicles model: ");
				vehicleModel = S.nextLine();
				System.out.println("Please enter the vehicles registration number: ");
				vehicleRegNo = S.nextLine().toUpperCase();
				if (isRegistrationUnique(vehicleRegNo) && !vehicleRegNo.isEmpty()) {
					System.out.println("Please enter the vehicles capacity between 0 and 5000: ");
					double enterCapacity = Double.parseDouble(S.nextLine());
					System.out.println("Please enter the vehicles weight between 0 and 37000: ");
					if (enterCapacity > 0 && enterCapacity < 5000) {
						capacity = enterCapacity;
						validEntry = true;
					}
					double enterWeight = Double.parseDouble(S.nextLine());
					if (enterWeight > 0 && enterWeight < 37000) {
						weight = enterWeight;
						validEntry = true;
					} if (!validEntry) {
						System.out.println("Invalid weight or capacity please try again!");
							break;
						}
					} else {
						System.out.println("Invalid registration number please try again!");
						break;
				}
				System.out.println("Please enter the vehicle type: ");
				type = S.nextLine().toLowerCase();
				if (type.equals("truck")) {
					depot.addVehicle(new Truck(vehicleMake, vehicleModel, weight, vehicleRegNo, getDepot(), capacity));
					exit = true;
					break;
				} if (type.equals("tanker")) {
					System.out.println("Please enter the liquid type: ");
					String liquidType = S.nextLine();
					depot.addVehicle(new Tanker(vehicleMake, vehicleModel, weight, vehicleRegNo, getDepot(), capacity, liquidType));
					exit = true;
					break;
				} else 
					System.out.println("Invalid vehicle type entered please try again!");
					break;
				} else {
					System.out.println("Invalid type please try again!!");
				}
		} while (!exit);
		
	}
	
	/**
	 * Method ensures a vehicle is not adding using a duplicate registration number
	 * @param registration registration used to create vehicle, searches to see if exists already
	 * @return returns false if a duplication is not found, returns true is duplication is found
	 */
	public boolean isRegistrationUnique(String registration) {
		List<Vehicle> vehicles;
		for (Depot depot : depots) {
			vehicles = depot.getVehicles();
			for (Vehicle v : vehicles) {
				if (registration.equals(v.regNo)) {
					return false;
				}
			}
		} return true;
	}
	
	/**
	 * Method reassigns a vehicle to a new depot
	 */
	public void reAssignVehicle() {
		String selectVehicle;
		String selectDepot = "";
		boolean exit = false;
		boolean validRegNo = false;
		boolean validArea = false;
		int count = 0;
		Vehicle v;
		
		if (depot.getVehicles().isEmpty()) {
			System.out.println("No available vehicles to re-assign!");
			return;
		}
		do {
			System.out.println("Depots: ");
			depot.vehicleList();
			System.out.println("Please enter registration number of vehicle to be re-assigned: ");
			selectVehicle = S.nextLine();
			for (Vehicle vehicle : depot.getVehicles()) {
				if (selectVehicle.equals(vehicle.getRegNo())) {
					validRegNo = true;
					System.out.println(selectVehicle + " has been selected");
					depotList();
					System.out.println("Please enter depot you would like to re-assign " + selectVehicle + " to: ");
					selectDepot = S.nextLine();
					
					for (Depot d : depots) {
						if (selectDepot.equals(d.getDepotArea()) && !selectDepot.equals(vehicle.getDepot())) {
							validArea = true;
							validRegNo = true;
							System.out.println(selectVehicle + " has been re-assigned to depot " + selectDepot + "!");
							exit = true;
							break;
						} else {
							validArea = false;
						}
						count++;
					}
				} else {
					validRegNo = false; 
				}
			}
			
			if (!validRegNo) {
				System.out.println("Invalid registration number please try again!");
			}
			if (!validArea) {
				System.out.println("Invalid depot or vehicle is already assigned to this depot please try again!");
			}
			if (validArea) {
				v = depot.getVehicle(selectVehicle);
				v.setDepot(getDepot(selectDepot));
				depots.get(count).addVehicle(v);
				depot.getVehicles().remove(v);
			}
			
		} while (!exit);
	}
	
	// GETTERS AND SETTERS //
	/**
	 * Method gets the depot value
	 * @return returns the depot
	 */
	public Depot getDepot() {
		return depot;
	}
	
	/**
	 * Method gets info on specific depot by area
	 * @param area area of specific depot
	 * @return returns a depot is parameter match is of the same area
	 */
	public Depot getDepot(String area) {
		for (Depot depot : depots) {
			if (area.equals(depot.getDepotArea())) {
				return depot;
			}
		} return null;
	}
	
	/**
	 * Method renames a specific depot
	 * @param s name of depot
	 * @throws Exception
	 */
	public void setDepot(String s) throws Exception {
		depot = new Depot(s);
	}
	
}
