import java.io.Serializable;

/**
 * @author Katlynn Chrans 904788
 * @author Adam Al-Najjar 678948
 * Class defines a vehicle, super class of truck and tanker
 */

public abstract class Vehicle implements Serializable {
	protected String make;
    protected String model;
    protected double weight;
    protected String regNo;
    protected boolean assigned;
    protected Depot depot;
    protected WorkSchedule workSchedule;
    protected Driver driver;
    
    /**
     * Constructors
     * @param make make of vehicle
     * @param model model of vehicle
     * @param weight weight of vehicle
     * @param regNo registration number of vehicle
     * @param depot depot vehicle is assigned to
     */
    public Vehicle(String make, String model, double weight, String regNo, Depot depot) {
        this.make = make;
        this.model = model;
        this.weight = weight;
        this.regNo = regNo;
        this.depot = depot;
        this.workSchedule = null;
        this.driver = null;
        
    }
    
    /**
     * Formats the vehicle info
     */
    public String toString() {
    	return make + " " + model + " " + regNo + " " + weight + this.getClass().getSimpleName() + " " + driver + " " + workSchedule;
    }
    
    /**
     * Method check if vehicle is available to be assigned to a set schedule
     * @return returns false if assigned, true if not
     */
    public boolean isVehicleAvailable() {
        return assigned;
    }
    
    // GETTERS AND SETTERS //
    /**
     * Method sets specific depot vehicle is asssigned to
     * @param dep name of depot
     */
    public void setDepot (Depot dep) {
    	this.depot = dep;
    }
    
    /**
     * Method gets registration number of vehicle
     * @return returns the registration number
     */
    public String getRegNo() {
    	return regNo;
    }
    
    /**
     * Method gets the depot vehicle is assigned to
     * @return returns the depot
     */
    public String getDepot() {
    	return depot.toString();
    }
    
    /**
     * Method sets a driver to a vehicle when assigned to a schedule
     * @param driver driver assigned
     */
    public void setDriver(Driver driver) {
    	this.driver = driver;
    }
    
    /**
     * Method gets driver assigned to a vehicle
     * @return returns the driver
     */
    public Driver getDriver() {
    	return driver;
    }
    
    /**
     * Method gets schedule vehicle is assigned to
     * @return returns the schedule
     */
    public WorkSchedule getWorkSchedule() {
    	return workSchedule;
    }
    
    /**
     * Method sets a vehicle to a schedule
     * @param workSchedule sets the schedule to vehicle
     */
    public void setWorkSchedule(WorkSchedule workSchedule) {
    	this.workSchedule = workSchedule;
    }
    
}
