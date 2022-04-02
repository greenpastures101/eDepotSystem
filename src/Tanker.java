
public class Tanker extends Vehicle {
    private double liquidCapacity;
    private String liquidType;
    private String type;
    
    // Making Constructors------------------------------------------------------------------------------------
    public Tanker(String make, String model, Double weight, String regNo, Depot depot, Double liquidCapacity, String liquidType) throws Exception {
    	super(make, model, weight, regNo, depot);
    	this.liquidCapacity = liquidCapacity;
    	this.liquidType = liquidType;
    	this.type = "Tanker";
    }
    
    // Format-------------------------------------------------------------------------------------------------
    public String toString() {
    	return this.getClass().getSimpleName() + " " + type;
    }
    

}
