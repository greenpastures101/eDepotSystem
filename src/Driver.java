import java.io.Serializable;

/**
 * @author Katlynn Chrans 904788
 * @author Adam Al-Najjar 678948
 * Class to create drivers and methods for driver specifics
 */

public class Driver implements Serializable {
	protected String userName;
	protected String passWord;
	private boolean assigned;
	private boolean isManager;
	private String area;
	public Depot depot;
	private WorkSchedule sched;
	
	/**
	 * Constructors
	 * @param userName username of driver
	 * @param passWord password of driver
	 * @param assigned boolean for if driver is assigned to schedule
	 * @param isManager boolean for if driver is a manager
	 * @param area area driver is assigned to
	 */
    public Driver(String userName, String passWord, boolean assigned, boolean isManager, Depot area) {
    	this.userName = userName.trim();
    	this.passWord = passWord.trim();
    	this.assigned = assigned;
    	this.isManager = isManager;
    	this.sched = null;
    	this.depot = area;
    }
    
    /**
     * Formats the driver info
     */
    public String toString() {
    	return String.format("%s", userName);
    }
    
    // GETTERS AND SETTERS //
    /**
     * Method gets boolean value for if a driver is a manager
     * @return returns true if manager, false if not
     */
    public boolean getIsManager() {
    	return isManager;
    }
    
    /**
     * Method gets username of driver
     * @return returns username
     */
    public String getUserName() {
    	return userName;
    }
    
    /**
     * Method gets a specific drivers schedule
     * @return returns the schedule if exists
     */
    public WorkSchedule getSchedule() {
    	return sched;
    }
    
    /**
     * Method sets a schedule to specific driver
     * @param workSchedule schedule to set
     */
    public void setSchedule(WorkSchedule workSchedule) {
    	this.sched = workSchedule;
    }
    
    /**
     * Method sets the true or false value
     * @param set value to set
     */
    public void setAssigned (boolean set) {
    	assigned = set;
    }
    
    /**
     * Method checks if specific driver is available (set to a schedule)
     * @return returns true if driver is avilable, false if not
     */
    public boolean isAvailable() {
    	return assigned;
    }

}
