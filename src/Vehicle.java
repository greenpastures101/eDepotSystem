import java.io.Serializable;

public abstract class Vehicle implements Serializable {
	protected String make;
    protected String model;
    protected double weight;
    protected String regNo;
    protected boolean assigned;
    protected Depot depot;
    protected WorkSchedule workSchedule;
    protected Driver driver;
    
    // Making constructors------------------------------------------------------------------------------------
    public Vehicle(String make, String model, double weight, String regNo, Depot depot) {
        this.make = make;
        this.model = model;
        this.weight = weight;
        this.regNo = regNo;
        this.depot = depot;
        this.workSchedule = null;
        this.driver = null;
        
    }
    
    // Checks that the vehicle is available or not------------------------------------------------------------
    public boolean isVehicleAvailable() {
        return assigned;
    }
    
    // Allows us assign a vehicle to a depot------------------------------------------------------------------
    public void setDepot (Depot dep) {
    	this.depot = dep;
    }
    
    // Gets the reg no of the vehicle-------------------------------------------------------------------------
    public String getRegNo() {
    	return regNo;
    }
    
    // Gets the depot a vehicle is assigned to----------------------------------------------------------------
    public String getDepot() {
    	return depot.toString();
    }
    
    // Sets driver--------------------------------------------------------------------------------------------
    public void setDriver(Driver driver) {
    	this.driver = driver;
    }
    
    public void setWorkSchedule(WorkSchedule workSchedule) {
    	this.workSchedule = workSchedule;
    }
    
    // Gets driver--------------------------------------------------------------------------------------------
    public Driver getDriver() {
    	return driver;
    }
    
    public WorkSchedule getWorkSchedule() {
    	return workSchedule;
    }
    
    // Format-------------------------------------------------------------------------------------------------
    public String toString() {
    	return make + " " + model + " " + regNo + " " + weight + this.getClass().getSimpleName() + " " + driver + " " + workSchedule;
    }
}
