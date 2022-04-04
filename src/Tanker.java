
/**
 * @author Katlynn Chrans 904788
 * @author Adam Al-Najjar 678948
 * Class inherits attributes and methods from class Vehicle, defines tanker objects
 */

public class Tanker extends Vehicle {
    private double liquidCapacity;
    private String liquidType;
    private String type;
    
    /**
     * Constructors
     * @param make make of tanker
     * @param model model of tanker
     * @param weight weight of tanker
     * @param regNo registration number of tanker
     * @param depot depot tanker is assigned to
     * @param liquidCapacity capacity of tanker
     * @param liquidType liquid type of tanker
     * @throws Exception
     */
    public Tanker(String make, String model, Double weight, String regNo, Depot depot, Double liquidCapacity, String liquidType) throws Exception {
    	super(make, model, weight, regNo, depot);
    	this.liquidCapacity = liquidCapacity;
    	this.liquidType = liquidType;
    	this.type = "Tanker";
    }
    
    /**
     * Formats the tanker info
     */
    public String toString() {
    	return this.getClass().getSimpleName() + " " + type;
    }
    

}
