// Class for the Warehouse Object
// Stores everything and keeps a stock of everything

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class Warehouse{
    
    // Stocks of all parts is stores in a Hash Map, Keys: Parts, Values: Part Quantities
    private Map<Part, PartQuantity> stock;

    public Warehouse(){
        stock = new HashMap<>(); // stock is a Hash Map object
    }

    // Method to know if a certain part is available in a certain part quatity
    public boolean isAvailable(Part part, PartQuantity quantity){
        PartQuantity availableQuantity = stock.get(part); // Checking how much quantity is available for the given input part // returns the value (part quantity) corresponding to the Key (Part Object)
        if(availableQuantity == null){ // If availableQuantity is null, then this means the part input in the method is not defined i.e. it is simply not available
            return false;
        }
        else{ // if the part is available (i.e. defined previously), then we need to check if the unit descriptors are compatible
            checkCompatibleUnitDescriptors(availableQuantity, quantity); // Private method for checking compatibility of unit descriptors of part quantities
            return availableQuantity.getQuantity() >= quantity.getQuantity();
            // Tells us if the available quantity is more than the required quantity or not
        }

    }

    // Private method for checking compatibility of unit descriptors of part quantities
    private boolean checkCompatibleUnitDescriptors(PartQuantity quantity1, PartQuantity quantity2){
        boolean result = (quantity1.getUnitDescriptor() == null && quantity2.getUnitDescriptor() == null) || quantity1.getUnitDescriptor() == quantity2.getUnitDescriptor();
        // if both the unit descriptors are not defined or both are equal then both unit descriptors are compatible
        // Otherwise, we need to throw an unsupported operation exception
        if(result == false){
            throw new UnsupportedOperationException("Quantity Descriptors are uncompatible [" + quantity1.getUnitDescriptor() + " | " + quantity2.getUnitDescriptor()+" ]");
        }

        return result;
    }
}