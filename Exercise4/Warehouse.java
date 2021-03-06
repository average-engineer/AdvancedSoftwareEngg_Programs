// Class for the Warehouse Object
// Stores everything and keeps a stock of everything

import java.util.Map;
import java.util.HashMap;
//import java.util.Collections;

public class Warehouse{
    
    // Stocks of all parts is stores in a Hash Map, Keys: Parts, Values: Part Quantities
    private Map<Part, PartQuantity> stock;

    // Class Constructor
    public Warehouse(){
        stock = new HashMap<>(); // stock is a Hash Map object
    }

    // Method to know if a certain part is available in a certain part quatity
    // Availability is defined by 2 metrics:
    // -> If the part is existing in the stock
    // -> If the part quantity is more than the required quantity to be stocked out
    public boolean isAvailable(Part part, PartQuantity quantity){
        PartQuantity availableQuantity = stock.get(part); // Checking how much quantity is available for the given input part // returns the value (part quantity) corresponding to the Key (Part Object)
        if(availableQuantity == null){ // If availableQuantity is null, then this means the part input in the method is not defined i.e. it is simply not available in the stock map
            return false;
        }
        else{ // if the part is available (i.e. defined previously), then we need to check if the unit descriptors are compatible
            checkCompatibleUnitDescriptors(availableQuantity, quantity); // Private method for checking compatibility of unit descriptors of part quantities
            return availableQuantity.getQuantity() >= quantity.getQuantity();
            // Tells us if the available quantity is more than the required quantity or not (True/False)
            // If false is returned, then this means that the amount present in the warehouse stock is less than the required amount
            // Consequently, if false is returned, the stockOut(Part,PartQuantity) method will throw an UnsupportedOperationException 
        }

    }

    // isAvailable method which takes a Part ID as input and checks if the part corresponding to that Part ID is available in the stock (Part->Part Quantity Map)
    // Strategy:
    // Function Input -> Part ID
    // Use a entry set element to loop through all the Key Value pairs in the given Stock (Part->Part Quantity Map) of the warehouse
    // For every entry, extract the part (value) and then extract the ID of the part (getID() method)
    // Compare the extracted ID with the input ID, if they match, return true, otherwise return false

    // ITERATION 1:
    // Returning only boolean values to check if the part is present or not
    // public boolean isAvailable(String id){

    //     // Looping through all the KeyValue pairs in the stock of the warehouse
    //     for(Map.Entry<Part,PartQuantity>entry : stock.entrySet()){
    //         // Checking if the ID of each part from the stock matches with the input ID
    //         if(entry.getKey().getID().equals(id)){
    //             return true;
    //         }
    //     }

    //     return false;

    // }

    // ITERATION 2:
    // // Returning the part quantity as well if the part is present in the stock -> will help us in adding the functionality of knowing how much of the part is left if its present 
    public PartQuantity isAvailable(String id){

        for(Map.Entry<Part,PartQuantity>entry : stock.entrySet()){
            // Checking if the ID of each part from the stock matches with the input ID
            if(entry.getKey().getID().equals(id)){
                return entry.getValue(); // The value i.e. the part quantity is returned
            }
        }

        return null; // null is returned if the part id doesnt match

    }

    
    // ITERATION 3:
    // Returns the Part object if the part corresponding to the ID is present 
    // public Part isAvailable(String id){

    //     for(Map.Entry<Part,PartQuantity>entry : stock.entrySet()){
    //         // Checking if the ID of each part from the stock matches with the input ID
    //         if(entry.getKey().getID().equals(id)){
    //             return entry.getKey(); // The value i.e. the part quantity is returned
    //         }
    //     }

    //     return null; // null is returned if the part id doesnt match

    // }


    // isAvailable method which takes a hash map (Part:PartQuantity) as input
    public boolean isAvailable(Map<Part,PartQuantity> partList){

        for(Map.Entry<Part,PartQuantity> entry: partList.entrySet()){

            // Looping through each part in the part list

            // Using isAvailable(Part,Quantity)
            // if(!isAvailable(entry.getKey(), entry.getValue())){ // if the part is not available (it is less than the required quantity) (i.e. isAvailablw returns false)
            //     return false; // If anyone of the parts in the part list becomes unavailabe, the function returns false
            //                   // Basically even if one of the parts are missing/finished, the function returns false instead of true
            // }

            // Using isAvailable(partID)
            // We need to compare the required part quantity and part quantity in the stock
            // isAvailable(partID) will return the available part quantity in the warehouse stock
            // entry.getValue() will return the required part quantity according to the product partlist
            if(isAvailable(entry.getKey().getID()) == null || entry.getValue().getQuantity() > isAvailable(entry.getKey().getID()).getQuantity()){ 
                // If the part is not available in the stock or is available but present in less quantity than the required quantity
                return false; // If anyone of the parts in the part list becomes unavailabe, the function returns false
                              // Basically even if one of the parts are missing/insufficient, the function returns false instead of true
            }
        }

        // If everything (all parts in the part list) is avaialble/sufficient
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

        // Using isAvailable(part,quantity)
        // If the part is not available, isAvailable throws a false value -> !isAvailable(part, quantity) will give a True value if the part is not available
        // if(!isAvailable(part,quantity)){
        //     throw new UnsupportedOperationException("Can not stock out "+ part.getName() + " due to insufficient quantity");
        // }

        // Using isAvailable(partID)
        if(isAvailable(part.getID()).getQuantity() < quantity.getQuantity()){
            throw new UnsupportedOperationException("Can not stock out "+ part.getName() + " due to insufficient quantity");
        }

        else{// if the part is available
            //PartQuantity availableQuantity = stock.get(part);
            PartQuantity availableQuantity = isAvailable(part.getID()); // Initial available quantity before stocking out
            double newQuantity = availableQuantity.getQuantity() - quantity.getQuantity(); // Available quantity in the stock after stocking out
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

    // Method to extract/get the stock of the warehouse
    public Map<Part,PartQuantity> getStock(){
        return stock;
    }

    // Overwriting the toString method (to control what is printed to the screem when the Warehouse object is printed)
    // Default -> It will print the reference ID of the warehouse object location in the memory
    public String toString(){
        StringBuffer buffer = new StringBuffer(); // new StringBuffer object
        buffer.append("The warehouse contains: \n");
        for(Map.Entry<Part,PartQuantity> entries: stock.entrySet()){

            // Printed output -> toString() of PartQuanitity <space> toString() of Part
            buffer.append("\t").append(entries.getValue()).append(" ").append(entries.getKey()).append("\n");
        }

        return buffer.toString();
    }
}