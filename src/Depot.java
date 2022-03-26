import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Depot {
	private Vehicle vehicle;
	private Driver driver;
	private WorkSchedule workSchedule;
	private String depotArea;
	
	private ArrayList<Driver> drivers = new ArrayList<Driver>();
	private List<WorkSchedule> workSchedules = Collections.synchronizedList(new ArrayList<WorkSchedule>());
	private List<WorkSchedule> completedSchedules = Collections.synchronizedList(new ArrayList<WorkSchedule>());
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	
	public Depot(String depotArea) throws Exception {
		this.depotArea = depotArea;
	}
	
	// Verifying the correct login details are entered--------------------------------------------------------
	public boolean verify(String uName, String pWord) {
		for (Driver driver : drivers) {
			if (uName.equals(driver.userName) && pWord.equals(driver.passWord)) {
				System.out.println("Successful Login");
				return true;
			}
		} return false;
	}
	
	//---------VEHICLE SECTION--------------------------------------------------------------------------------
	// Getting a specific vehicle-----------------------------------------------------------------------------
	public Vehicle getVehicle(String regNo) {
		for (Vehicle veh : vehicles) {
			if (regNo.equals(veh.regNo)) {
				return veh;
			}
		} return null;
	}
	
	// Allows us to add vehicles into the system--------------------------------------------------------------
	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}
	
	// Allows us to remove vehicles from the system-----------------------------------------------------------
	public void removeVehicle(String regNo) {
		vehicles.removeIf(veh -> veh.getRegNo().equals(regNo));
	}
	
	// Lists all the vehicles in the system-------------------------------------------------------------------
	public void vehicleList() {
		for (Vehicle vehicle : vehicles) {
			System.out.printf("%-10s %-10s %-15s %8s %10s %10s %10s %n", vehicle.make, vehicle.model, vehicle.getRegNo(), vehicle.depot, vehicle.getClass().getName(), vehicle.driver, vehicle.workSchedule);
		}
	}
	
	// Lists unAssigned vehicles in the system----------------------------------------------------------------
	public void unAssignedVehicleList() {
		System.out.printf("%-10s %-10s %-15s %8s %10s %10s %10s %n", "Make", "Model", "Reg No", "Depot", "Type", "Driver", "Work Schedule");
		for (Vehicle vehicle : vehicles) {
			System.out.printf("%-10s %-10s %-15s %8s %10s %10s %10s %n", vehicle.make, vehicle.model, vehicle.regNo, vehicle.depot, vehicle.getClass().getName(), vehicle.driver, vehicle.workSchedule);
		}
	}
	
	// Gets all the vehicles----------------------------------------------------------------------------------
	public List<Vehicle> getVehicles() {
		return vehicles;
	}
	
	public ArrayList(Vehicle> getUnassignedVehicles() {
		ArrayList<Vehicle> unAssignedVehicles = new ArrayList<>();
		for (Vehicle v : vehicles) {
			if (v.unAssignedVehicles.getDriver() == null && v.getSchedule() == null) {
				unAssignedVehicles.add(v);
			}
		} return unAssignedVehicles;
	}
	
	//-----DRIVER SECTION-------------------------------------------------------------------------------------
	// Lists all the drivers in the system--------------------------------------------------------------------
	public void driverList() {
		for (Driver driver : drivers) {
			System.out.println(driver.toString());
		}
	}
	
	// Gets a driver by username------------------------------------------------------------------------------
	public Driver getDriver(String username) {
		for (Driver driver : drivers) {
			if (username.equals(driver.userName)) {
				return driver;
			}
		}
		return null;
	}
	
	// Gets all the drivers-----------------------------------------------------------------------------------
	public ArrayList<Driver> getDrivers() {
		return drivers;
	}
	
	// Allows us to add a driver to the system----------------------------------------------------------------
	public void addDriver(Driver driver) {
		drivers.add(driver);
	}
	
	
	//-----SCHEDULE SECTION-----------------------------------------------------------------------------------
	// Lists the COMPLETED work schedules-------------------------------------------------------------------------------
	public void completedScheduleList() {
		System.out.printf("%-10s %-10s %10s %17s %12s %n", "Client", "Start Date", "End Date", "Assigned to", "Vehicle");
		for (WorkSchedule workSchedule : completedSchedules) {
			System.out.println(workSchedule.toString());
		}	
	}
	
	// Lists the CREATED work schedules-----------------------------------------------------------------------
	public void scheduleList () {
		System.out.printf("%-10s %-10s %10s %17s %12s %n", "Client", "Start Date", "End Date", "Assigned to", "Vehicle");
		for (WorkSchedule workSchedule : workSchedules) {
			System.out.println(workSchedule.toString());
		}
	}
	
	// Lists the UNASSIGNED work schedules--------------------------------------------------------------------
	public void unassignedScheduleList() {
		System.out.printf("%-10s %-10s %10s %17s %12s %n", "Client", "Start Date", "End Date", "Assigned to", "Vehicle");
			for (WorkSchedule workSchedule : workSchedules) {
				if (workSchedule.getDriverAssigned() == null) {
					System.out.println(workSchedule.toString());
				}
			}
	}
	
	// Get UNASSIGNED work schedules--------------------------------------------------------------------------
	public ArrayList<WorkSchedule> getUnassignedSchedules() {
		ArrayList<WorkSchedule> unassignedSchedules = new ArrayList<>();
		for (WorkSchedule workSchedule : workSchedules) {
			if (workSchedule.getDriverAssigned() == null) {
				unassignedSchedules.add(workSchedule);
			}
		} return unassignedSchedules;
	}
	
	// Gets the CREATED work schedules------------------------------------------------------------------------
	public List<WorkSchedule> getSchedules() {
		return workSchedules;
	}
	
	// Allows us to add a CREATED work schedule to array------------------------------------------------------
	public void addCreatedSchedule(WorkSchedule ws) {
		workSchedules.add(ws);
	}
	
	// Gets COMPLETED schedules-------------------------------------------------------------------------------
	public List<WorkSchedule>getCompletedSchedules() {
		return completedSchedules;
	}
	
	// Allows us to get a specific schedule by client name
	public WorkSchedule getWSchedule(String clientName) {
		for (WorkSchedule workSchedule : workSchedules) {
			if (clientName.equals(workSchedule.client)) {
				return workSchedule;
			}
		} return null;
	}
	
	//-----AREA SECTION---------------------------------------------------------------------------------------
	// This gets a depot area---------------------------------------------------------------------------------
	public String getDepotArea() {
		return depotArea;
	}
	
	public String toString() {
		return depotArea;
	}
}
