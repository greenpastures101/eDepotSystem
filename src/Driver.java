import java.io.Serializable;

public class Driver implements Serializable {
	protected String userName;
	protected String passWord;
	private boolean assigned;
	private boolean isManager;
	private String area;
	public Depot depot;
	private WorkSchedule sched;
	
	// Making constructors------------------------------------------------------------------------------------
   // public Driver(String userName, String passWord, boolean assigned, boolean isManager) throws Exception {
    	//this.userName = userName.trim();
    	//this.passWord = passWord.trim();
    	//this.assigned = assigned;
    	//this.isManager = isManager;
    	//this.sched = null;
    	//this.depot = null;
   // }
    
    public Driver(String userName, String passWord, boolean assigned, boolean isManager, Depot area) {
    	this.userName = userName.trim();
    	this.passWord = passWord.trim();
    	this.assigned = assigned;
    	this.isManager = isManager;
    	this.sched = null;
    	this.depot = area;
    }
    
    public boolean isAvailable() {
    	return assigned;
    }
    
    public boolean getIsManager() {
    	return isManager;
    }
    
    public String getUserName() {
    	return userName;
    }
    
    public WorkSchedule getSchedule() {
    	return sched;
    }
    
    public void setSchedule(WorkSchedule workSchedule) {
    	this.sched = workSchedule;
    }
    
    public void setAssigned (boolean set) {
    	assigned = set;
    }
    public String toString() {
    	return String.format("%s", userName);
    }

}
