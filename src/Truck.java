
public class Truck extends Vehicle {
    private double cargoCapacity;
    private String type;
    
    // Making Constructors------------------------------------------------------------------------------------
    public Truck(String make, String model, Double weight, String regNo, Depot depot, Double cargoCapacity) throws Exception {
    	super(make, model, weight, regNo, depot);
    	this.cargoCapacity = cargoCapacity;
    	this.type = "Truck";
    }
    
    // Format-------------------------------------------------------------------------------------------------
    public String toString() {
    	return this.getClass().getSimpleName() + " " + type;
    }
}
