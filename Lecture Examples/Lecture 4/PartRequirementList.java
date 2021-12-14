// Class for the object describing the Parts required to assemble a Product

import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

public class PartRequirement{

    // Creating a private class variable which represents the map object of Part and its corresponding Part Quantity
    private Map<Part, PartQuantity> partList;

    // Private class variable representing the Product object for which the part requirement list is being created
    private Product product;

    // Class Constructor
    public PartRequirementList(Product product){
        this.product = product;
        partList = new HashMap<>(); // The partList is basically a Hash Map object
    }

    // Part Requirement information sotring technique:
    // A map :
    //       -> Keys describing the required parts
    //       -> Values describing the quantity of the corresponding required parts
    // Map Keys will contain Part Objects
    // Map Values will contain PartQuantity Objects

    // Method to add a certain Part and its quantity to the requirement list

    // Getter Method for the Part List (Map/Hash Map Object)
    public Map<Part, PartQuantity> getPartList(){
        return Collections.unmodifiableMap(partList); // The method unmodifiableMap() from the class Collections (Externally imported into the class) makes the map being returned immutable
    }

    public boolean addPartasRequirement(Part part, PartQuantity quantity){

        // HashMap<Part, PartQuantity> partList = new HashMap<Part, PartQuantity>();
        return partList.put(part, quantity) != null; // If partList.put() is not equal to null, then true is returned and for vice versa, false is returned
        
        // Important: if an existing Key is passed through put, then the put() method returns the value corresponding to the existing key
        // If an entirely new key is passed through put, the the put() method returns null (which is the noral operation) and the corresponding hashmap gets modified with the new Key Value Pair

    }

    // Overwriting toString() method:
    public String toString(){
        StringBuffer buffer = new StringBuffer(); // Speacial Data Structure for handling strings
        buffer.append("Requirements of ").append(product.getName()).append(":\n");

        for(Map.Entry<Part, PartQuantity> entry : partList.entrySet()){
            buffer.append("\t").append(entry.getValue()).append(" ").append(entry.getKey().getName()).append("\n");
        }

        return buffer.toString(); // Converting the buffer to string
    }
}