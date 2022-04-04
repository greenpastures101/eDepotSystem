
/**
 * @author Katlynn Chrans 904788
 * @author Adam Al-Najjar 678948
 * Class inherits attributes and methods from class Vehicle, defines truck objects
 */

public class Truck extends Vehicle {
    private double cargoCapacity;
    private String type;
    
    /**
     * Constructors
     * @param make make of truck
     * @param model model of truck
     * @param weight weight of truck
     * @param regNo registration number of truck
     * @param depot depot truck is assigned to
     * @param cargoCapacity capacity of truck
     * @throws Exception
     */
    public Truck(String make, String model, Double weight, String regNo, Depot depot, Double cargoCapacity) throws Exception {
    	super(make, model, weight, regNo, depot);
    	this.cargoCapacity = cargoCapacity;
    	this.type = "Truck";
    }
    
    /**
     * Formats the truck info
     */
    public String toString() {
    	return this.getClass().getSimpleName() + " " + type;
    }
}
