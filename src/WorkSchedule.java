import java.time.LocalDate;
import java.io.Serializable;

public class WorkSchedule implements Comparable<WorkSchedule>, Serializable{
	protected String client;
	private LocalDate startDate;
	private LocalDate endDate;
	private Driver driverAssigned;
	private String vehicleAssigned;
	
	// Making Constructors------------------------------------------------------------------------------------
	public WorkSchedule(String client, LocalDate startdate, LocalDate endDate) throws Exception {
		this.client = client;
		setStartDate(startDate);
		setEndDate(endDate);
		this.driverAssigned = null;
		this.vehicleAssigned = null;
	}
	
	public WorkSchedule(String client) throws Exception {
		this.client = client;
		this.startDate = null;
		this.endDate = null;
	}
	
	// Allows us to set the start date and checks it is not being set in the past-----------------------------
	public void setStartDate(LocalDate startDate) throws Exception {
		if (startDate.isAfter(LocalDate.now())) {
			this.startDate = startDate;
		} 
		else {
			throw new Exception("Start date is in the past, please try again");
		}
	}
	
	public void setStartDate(String startDate) throws Exception {
		setStartDate(LocalDate.parse(startDate));
	}
	
	// Get start date----------------------------------------------------------------------------------------
	public LocalDate getStartDate() {
		return startDate;
	}
	
	// Allows us to set the end date and checks it does not exceed being 72 hours from the start date---------
	public void setEndDate(LocalDate endDate) throws Exception {
		if (endDate.isAfter(LocalDate.now().plusDays(1)) && endDate.isBefore(startDate.plusDays(4))) {
			this.endDate = endDate;
		}
		else {
			throw new Exception("End date exceeds 72 hours, please try again");
		}
			
	}
	
	public void setEndDate(String endDate) throws Exception {
		setEndDate(LocalDate.parse(endDate));
	}
	
	// Get end date------------------------------------------------------------------------------------------
	public LocalDate getEndDate() {
		return endDate;
	}
	
	public Object getStartDate(WorkSchedule sched) {
		return sched.startDate;
	}
	
	// Sets driver assigned to schedule----------------------------------------------------------------------
	public void setDriverAssigned(Driver driver) {
		this.driverAssigned = driver;
	}
	
	// Gets driver assigned to schedule----------------------------------------------------------------------
	public Driver getDriverAssigned() {
		return driverAssigned;
	}
	
	// Gets client for work schedule-------------------------------------------------------------------------
	public String getClient() {
		return client;
	}
	
	// Gets vehicle assigned to schedule---------------------------------------------------------------------
	public String getVehicleAssigned() {
		return vehicleAssigned;
	}
	
	// Sets vehicle assigned to schedule---------------------------------------------------------------------
	public void setVehicleAssigned(Vehicle vehicleAssigned) {
		this.vehicleAssigned = vehicleAssigned.regNo;
	}
	
	// Format------------------------------------------------------------------------------------------------
	public String toString() {
		return String.format("%-10s %-10s %12s %8s %16s", client, startDate, endDate, driverAssigned, vehicleAssigned);
	}
	
	public int compareTo(WorkSchedule o) {
		return 0;
	}
	
	
}
