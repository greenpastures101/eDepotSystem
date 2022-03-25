
public class Driver {
	protected String userName;
	protected String passWord;
	private boolean assigned;
	private boolean isManager;
	private String area;
	private Depot depot;
	private WorkSchedule sched;
	
	// Making constructors------------------------------------------------------------------------------------
    public Driver(String userName, String passWord, boolean assigned, boolean isManager) throws Exception {
    	this.userName = userName.trim();
    	this.passWord = passWord.trim();
    	this.assigned = assigned;
    	this.isManager = isManager;
    	this.sched = null;
    	this.depot = area;
    }

}
