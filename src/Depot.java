import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Depot {
	private Vehicle vehicle;
	private Driver driver;
	private WorkSchedule workschedule;
	private String depotArea;
	
	private ArrayList<Driver> drivers = new ArrayList<Driver>();
	private List<WorkSchedule> workSchedules = Collections.synchronizedList(new ArrayList<WorkSchedule>());
	private List<WorkSchedule> completedWorkSchedules = Collections.synchronizedList(new ArrayList<WorkSchedule>());
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	
	public Depot(String depotArea) throws Exception {
		this.depotArea = depotArea;
	}
	
	// Verifying the correct login details are entered--------------------------------------------------------
	public boolean verify(String username, String password) {
		for (Driver driver : drivers) {
			if (username.equals(driver.userName) && password.equals(driver.passWord)) {
				System.out.println("Successful Login");
				return true;
			}
		} return false;
	}
	
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
	
	// Lists all the drivers in the system--------------------------------------------------------------------
	public void driverList() {
		for (Driver driver : drivers) {
			System.out.println(driver.toString());
		}
	}
	
	// Lists the work schedules-------------------------------------------------------------------------------
	public void workScheduleList() {
		System.out.printf("%-10s %-10s %10s %17s %12s %n", "Client", "Start Date", "End Date", "Assigned to", "Vehicle");
		for (WorkSchedule workSchedule : workSchedules) {
			System.out.println(workSchedule.toString());
		}
	}
	
	public String toString() {
		return depotArea;
	}
	
	// Gets all the vehicles----------------------------------------------------------------------------------
	public List<Vehicle> getVehicles() {
		return vehicles;
	}
	
	// Gets all the drivers-----------------------------------------------------------------------------------
	public ArrayList<Driver> getDrivers() {
		return drivers;
	}
	
	// Allows us to add a driver to the system----------------------------------------------------------------
	public void addDriver(Driver driver) {
		drivers.add(driver);
	}
	
	public String getDepotArea() {
		return depotArea;
	}
}
