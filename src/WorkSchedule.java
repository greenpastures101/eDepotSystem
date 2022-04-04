import java.time.LocalDate;
import java.io.Serializable;

/**
 * @author Katlynn Chrans 904788
 * @author Adam Al-Najjar 678948
 * Class defines a schedule
 */
public class WorkSchedule implements Comparable<WorkSchedule>, Serializable {

	protected String client;
	private LocalDate startDate;
	private LocalDate endDate;
	private Driver driverAssigned;
	private String vehicleAssigned;
	
	/**
	 * Constructors
	 * @param client client of schedule
	 * @param startDate start date of schedule
	 * @param endDate end date of schedule
	 * @throws Exception
	 */
	public WorkSchedule(String client, LocalDate startDate, LocalDate endDate) throws Exception {
		this.client = client;
		setStartDate(startDate);
		setEndDate(endDate);
		this.driverAssigned = null;
		this.vehicleAssigned = null;
	}
	
	/**
	 * Constructors
	 * @param client client of schedule
	 * @throws Exception
	 */
	public WorkSchedule(String client) throws Exception {
		this.client = client;
		this.startDate = null;
		this.endDate = null;
	}
	
	/**
	 * Formats the schedule info
	 */
	public String toString() {
		return String.format("%-10s %-10s %12s %8s %16s", client, startDate, endDate, driverAssigned, vehicleAssigned);
	}
	
	// GETTERS AND SETTERS //
	/**
	 * Method gets the start date of schedule
	 * @return returns the date schedule starts
	 */
	public LocalDate getStartDate() {
		return startDate;
	}
	
	/**
	 * Method gets the start date of specific schedule
	 * @param sched the schedule
	 * @return returns the start date
	 */
	public Object getStartDate(WorkSchedule sched) {
		return sched.startDate;
	}
	
	/**
	 * Method gets the end date of schedule
	 * @return returns the date schedule ends
	 */
	public LocalDate getEndDate() {
		return endDate;
	}
	
	/**
	 * Method gets the driver assigned to schedule
	 * @return returns the driver
	 */
	public Driver getDriverAssigned() {
		return driverAssigned;
	}
	
	/**
	 * Method gets the client of schedule
	 * @return returns the client
	 */
	public String getClient() {
		return client;
	}
	
	/**
	 * Method gets vehicle assigned to schedule
	 * @return returns the vehicle
	 */
	public String getVehicleAssigned() {
		return vehicleAssigned;
	}
	
	 /**
	  * Method sets start date and ensures it is not being set in the past
	  * @param startDate start date set
	  * @throws Exception
	  */
	public void setStartDate(LocalDate startDate) throws Exception {
		if (startDate.isAfter(LocalDate.now())) {
			this.startDate = startDate;
		} 
		else {
			throw new Exception("Start date is in the past, please try again");
		}
	}
	
	/**
	 * Method parses the start date to string
	 * @param startDate start date of schedule
	 * @throws Exception
	 */
	public void setStartDate(String startDate) throws Exception {
		setStartDate(LocalDate.parse(startDate));
	}
	
	/**
	 * Method sets the end date and ensures it does not exceed 72 hours from start date set
	 * @param endDate end date set
	 */
	public void setEndDate(LocalDate endDate) throws Exception {
		if (endDate.isAfter(LocalDate.now().plusDays(1)) && endDate.isBefore(startDate.plusDays(4))) {
			this.endDate = endDate;
		}
		else {
			throw new Exception("End date exceeds 72 hours, please try again");
		}
			
	}
	
	/**
	 * Method parses the end date to string
	 * @param endDate end date of schedule
	 * @throws Exception
	 */
	public void setEndDate(String endDate) throws Exception {
		setEndDate(LocalDate.parse(endDate));
	}
	
	/**
	 * Method sets driver assigned to the schedule
	 * @param driver driver name
	 */
	public void setDriverAssigned(Driver driver) {
		this.driverAssigned = driver;
	}
	
	
	/**
	 * Method sets vehicle assigned to the schedule
	 * @param vehicleAssigned vehicle registration number
	 */
	public void setVehicleAssigned(Vehicle vehicleAssigned) {
		this.vehicleAssigned = vehicleAssigned.regNo;
	}
	
	/**
	 * Method compares schedules
	 */
	public int compareTo(WorkSchedule o) {
		return 0;
	}
	
	
}
