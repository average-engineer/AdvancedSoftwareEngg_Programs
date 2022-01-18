// Class for the Warehouse Object
// Stores everything and keeps a stock of everything

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class Warehouse{
    
    // Stocks of all parts is stores in a Hash Map, Keys: Parts, Values: Part Quantities
    private Map<Part, PartQuantity> stock;

    // Class Constructor
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
            // Tells us if the available quantity is more than the required quantity or not (True/False)
        }

    }

    // isAvailable method which takes a hash map (Part:PartQuantity) as input
    public boolean isAvailable(Map<Part,PartQuantity> partList){

        for(Map.Entry<Part,PartQuantity> entry: partList.entrySet()){
            if(!isAvailable(entry.getKey(), entry.getValue())){ // if the part is not available (i.e. isAvailablw returns false)
                return false; // If anyone of the parts in the part list becomes unavailabe, the function returns false
            }
        }

        // If everything (all parts in the part list) is avaialble
        return true;

    }


    // Private method for checking compatibility of unit descriptors of part quantities
    private boolean checkCompatibleUnitDescriptors(PartQuantity quantity1, PartQuantity quantity2){
        boolean result = (quantity1.getUnitDescriptor() == null && quantity2.getUnitDescriptor() == null) || quantity1.getUnitDescriptor() == quantity2.getUnitDescriptor();
        // if both the unit descriptors are not defined or both are equal then both unit descriptors are compatible
        // Otherwise, we need to throw an unsupported operation exception
        if(result == false){
            throw new UnsupportedOperationException("Quantity Descriptors are uncompatible [" + quantity1.getUnitDescriptor() + " | " + quantity2.getUnitDescriptor()+" ]");
        }

        return result; // True or False
    }

    // Method for stocking in a given amount of an individual part
    // Public Method since anyone from the outside should be able to stock in stuff
    public void stockIn(Part part, PartQuantity quantity){

        // First we check if the particular part is already in stock (privately defined hashmap in warehouse class)
        // If the part is not available (i.e. if the part quantity = null), then we add the part and the given quantity to the stock hashmap
        // If the part is already available, we need to check if the unit descriptors are compatible
        // Extracting the quantity of the specified part in the warehouse stock
        PartQuantity availableQuantity = stock.get(part); // Value corresponding to the Key part in the stock, if there exists no part Key in the stock hashmap, then null is returned
        if(availableQuantity == null){ // If the part is not available
            stock.put(part,quantity); // Adding the specific part and the stipulated quantity to the stock hashmap of the warehouse
        }

        else if(checkCompatibleUnitDescriptors(availableQuantity, quantity)){ // Else if condition runs only if compatibility method returns true, i.e. if the units are compatible
            double newQuantity = availableQuantity.getQuantity() + quantity.getQuantity();
            availableQuantity.setQuantity(newQuantity); // The quantity corresponding to the specific part in the stock hashmap is now modified
        }

    }

    // Method for stcoking out a certain part with a certain part quantity
    // Public Method since anyone from the outside should be able to stock out stuf
    public void stockOut(Part part, PartQuantity quantity){
        // Checking if the specified part is available in the stock or not
        // If the part is not available, there is no reason to stock out
        // Using the isAvailable method to check if the part is available
        // If the part is not available, isAvailable throws a false value -> !isAvailable(part, quantity) will give a True value if the part is not available
        if(!isAvailable(part,quantity)){
            throw new UnsupportedOperationException("Can not stock out "+ part.getName() + " due to insufficient quantity");
        }

        else{// if the part is available
            PartQuantity availableQuantity = stock.get(part);
            double newQuantity = availableQuantity.getQuantity() - quantity.getQuantity(); // Stocking out the given quantity
            availableQuantity.setQuantity(newQuantity); // Setting the reduced quantity as the new quantity value corresponding to the part key in the stock hashmap
        }

    }

    // Method to stock out a whole list of parts
    public void stockOut(Map<Part,PartQuantity> partList){
        // Looping through each key value pair in the partList hmap
        for(Map.Entry<Part,PartQuantity> entries: partList.entrySet()){
            // Irerating through each Value Key pair (Part and PartQuatity) and stocking them out
            stockOut(entries.getKey(),entries.getValue());
        }
    }

    // Overwriting the toString method (to control what is printed to the screem when the Warehouse object is printed)
    // Default -> It will print the reference ID of the warehouse object location in the memory
    public String toString(){
        StringBuffer buffer = new StringBuffer(); // new StringBuffer object
        buffer.append("The warehouse contains: \n");
        for(Map.Entry<Part,PartQuantity> entries: stock.entrySet()){
            buffer.append("\t").append(entries.getValue()).append(" ").append(entries.getKey()).append("\n");
        }

        return buffer.toString();
    }
}