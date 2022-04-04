import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.Serializable;

/**
 * @author Katlynn Chrans 904788
 * @author Adam Al-Najjar 678948
 * Class contains attributes and methods for a depot
 */

public class Depot implements Serializable {
	private Vehicle vehicle;
	private Driver driver;
	private WorkSchedule workSchedule;
	private String depotArea;
	
	/**
	 * Constructor creates a depot location object
	 * @param depotArea area of depot
	 * @throws Exception
	 */
	public Depot(String depotArea) throws Exception {
		this.depotArea = depotArea;
	}
	
	/**
	 * Creating Lists and ArrayLists to store information saved in file
	 */
	private ArrayList<Driver> drivers = new ArrayList<Driver>();
	private List<WorkSchedule> workSchedules = Collections.synchronizedList(new ArrayList<WorkSchedule>());
	private List<WorkSchedule> completedSchedules = Collections.synchronizedList(new ArrayList<WorkSchedule>());
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	/**
	 * Formats the depot area
	 */
	public String toString() {
		return depotArea;
	}
	
	/**
	 * Method verifies the username and password match an existing user
	 * @param uName username used to sign in
	 * @param pWord password used to sign in
	 * @return true if they match
	 */
	public boolean verify(String uName, String pWord) {
		for (Driver driver : drivers) {
			if (uName.equals(driver.userName) && pWord.equals(driver.passWord)) {
				System.out.println("Successful Login");
				return true;
			}
		} return false;
	}
	
	/**
	 * Method adds a vehicle to the ArrayList
	 * @param vehicle vehicle added
	 */
	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}
	
	/**
	 * Method removes vehicle using the registration number from ArrayList
	 * @param regNo specific registration number of the vehicle to remove
	 */
	public void removeVehicle(String regNo) {
		vehicles.removeIf(veh -> veh.getRegNo().equals(regNo));
	}
	
	/**
	 * Method prints a table with all vehicle in specific depot
	 */
	public void vehicleList() {
		for (Vehicle vehicle : vehicles) {
			System.out.printf("%-10s %-10s %-15s %8s %10s %10s %10s %n", vehicle.make, vehicle.model, vehicle.getRegNo(), vehicle.depot, vehicle.getClass().getName(), vehicle.driver, vehicle.workSchedule);
		}
	}
	
	/**
	 * Method prints a table with all unassigned vehicles in specific depot
	 */
	public void unAssignedVehicleList() {
		System.out.printf("%-10s %-10s %-15s %8s %10s %10s %10s %n", "Make", "Model", "Reg No", "Depot", "Type", "Driver", "Work Schedule");
		for (Vehicle vehicle : vehicles) {
			System.out.printf("%-10s %-10s %-15s %8s %10s %10s %10s %n", vehicle.make, vehicle.model, vehicle.regNo, vehicle.depot, vehicle.getClass().getName(), vehicle.driver, vehicle.workSchedule);
		}
	}
	
	/**
	 * Method prints a list of drivers in specific depot
	 */
	public void driverList() {
		for (Driver driver : drivers) {
			System.out.println(driver.toString());
		}
	}
	
	/**
	 * Method adds a driver to the ArrayList
	 * @param driver driver added
	 */
	public void addDriver(Driver driver) {
		drivers.add(driver);
	}
	
	/**
	 * Method prints schedules which are set as complete
	 */
	public void completedScheduleList() {
		System.out.printf("%-10s %-10s %10s %17s %12s %n", "Client", "Start Date", "End Date", "Assigned to", "Vehicle");
		for (WorkSchedule workSchedule : completedSchedules) {
			System.out.println(workSchedule.toString());
		}	
	}
	
	/**
	 * Method prints schedules
	 */
	public void scheduleList () {
		System.out.printf("%-10s %-10s %10s %17s %12s %n", "Client", "Start Date", "End Date", "Assigned to", "Vehicle");
		for (WorkSchedule workSchedule : workSchedules) {
			System.out.println(workSchedule.toString());
		}
	}
	
	/**
	 * Method prints schedules which are not yet set to a driver
	 */
	public void unassignedScheduleList() {
		System.out.printf("%-10s %-10s %10s %17s %12s %n", "Client", "Start Date", "End Date", "Assigned to", "Vehicle");
			for (WorkSchedule workSchedule : workSchedules) {
				if (workSchedule.getDriverAssigned() == null) {
					System.out.println(workSchedule.toString());
				}
			}
	}
	
	/**
	 * Method adds schedule to the ArrayList
	 * @param ws schedule added
	 */
	public void addCreatedSchedule(WorkSchedule ws) {
		workSchedules.add(ws);
	}
	
	/**
	 * Method adds a schedule set as complete to the ArrayList
	 * @param ws completed schedule added
	 */
	public void addCompletedSchedule(WorkSchedule ws) {
		completedSchedules.add(ws);
	}
	
	// GETTERS AND SETTERS //
	/**
	 * Method gets a specific vehicle by registration number
	 * @param regNo registration number of vehicle to get
	 * @return returns the vehicle if found
	 */
	public Vehicle getVehicle(String regNo) {
		for (Vehicle veh : vehicles) {
			if (regNo.equals(veh.regNo)) {
				return veh;
			}
		} return null;
	}
	
	/**
	 * Method gets all vehicles in specific depot
	 * @return returns the list of vehicles
	 */
	public List<Vehicle> getVehicles() {
		return vehicles;
	}
	
	/**
	 * Method gets unassigned vehicles in specific depot
	 * @return returns the list of unassigned vehicles
	 */
	public ArrayList<Vehicle> getUnassignedVehicles() {
		ArrayList<Vehicle> unAssignedVehicles = new ArrayList<>();
		for (Vehicle v : vehicles) {
			if (v.getDriver() == null && v.getWorkSchedule() == null) {
				unAssignedVehicles.add(v);
			}
		} return unAssignedVehicles;
	}
	
	/**
	 * Method gets a specific driver by username
	 * @param username username of driver to get
	 * @return returns the driver if found
	 */
	public Driver getDriver(String username) {
		for (Driver driver : drivers) {
			if (username.equals(driver.userName)) {
				return driver;
			}
		}
		return null;
	}
	
	/**
	 * Method gets all drivers in specific depot
	 * @return returns the drivers
	 */
	public ArrayList<Driver> getDrivers() {
		return drivers;
	}
	
	/**
	 * Method gets a specific schedule by client name
	 * @param clientName name of client 
	 * @return returns the schedule if found
	 */
	public WorkSchedule getWSchedule(String clientName) {
		for (WorkSchedule workSchedule : workSchedules) {
			if (clientName.equals(workSchedule.client)) {
				return workSchedule;
			}
		} return null;
	}
	
	/**
	 * Method gets all unassigned schedules in specific depot
	 * @return returns unassigned schedules
	 */
	public ArrayList<WorkSchedule> getUnassignedSchedules() {
		ArrayList<WorkSchedule> unassignedSchedules = new ArrayList<>();
		for (WorkSchedule workSchedule : workSchedules) {
			if (workSchedule.getDriverAssigned() == null) {
				unassignedSchedules.add(workSchedule);
			}
		} return unassignedSchedules;
	}
	
	/**
	 * Method gets active schedules in specific depot
	 * @return returns the active schedules
	 */
	public List<WorkSchedule> getSchedules() {
		return workSchedules;
	}
	
	/**
	 * Method gets schedules set as complete in specific depot
	 * @return returns the completed schedules
	 */
	public List<WorkSchedule>getCompletedSchedules() {
		return completedSchedules;
	}
	
	/**
	 * Method gets the depot area
	 * @return returns the depot area
	 */
	public String getDepotArea() {
		return depotArea;
	}
	
}
