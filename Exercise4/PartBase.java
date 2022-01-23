// Class to manage all parts in the system using their unique IDs
// Resembles a bill/list of materials/parts
// All parts which are there are listed against their unique IDs

// Importing Map and Hashmap datastructures
// Importing Collections object class
import java.util.Map;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class PartBase{

    // Variable which maps a particular ID to its corresponding part
    private Map<String, Part> idMap;

    // Class Constructor
    public PartBase(){
        idMap = new HashMap<>();
    }

    // Method for adding a new part to the ID -> Part Map
    public Part add(Part part){ // VV IMPORTANT: A Product object can also be added since Product is a subclass of Part and Polymorphism allows Part part = new Product(id,name)
        // Checking if the part is already inside out Map
        if(idMap.containsKey(part.getID())){
            return null; // Part is not added if it already is in the Map
        }
        // If the key is not contained in the map
        idMap.put(part.getID(),part);
        return part; // The part is returned if the part is added to the map successfully
    }

    // Method for finding a particular part using its unique ID
    public Part find(String id){
        return idMap.get(id); // Returns the Part object (Value) corresponding to the given ID (Key) in the Map.
        // We don't need to put the additional check of checking if the ID is existing in the Map or not
        // since the .get() method of the HashMap returns null anyways if the input id is not present in
        // the map
    }

    // Method for adding multiple parts to the Map
    public void addAll(Part... parts){ // (Part... parts) ensures that we can input a comma seperated list containing as many Part objects as possible
                                       // For eg.: addAll(Part part1,part2,part3,part4): All 4 Part Objects (part1 to part4) are recognised as methid inputs
        for(Part part: parts){ // part is a Part object which loops through the comma seperated part list parts (very much like in Python -> for file in files:)
            add(part);
        }

    }

    // Method to collect all parts in the map
    public Collection<Part> getAll(){ // A Collection object (Externally imported object class) is returned

        return Collections.unmodifiableCollection(idMap.values()); // .unmodifiableCollection() method makes the map values (Parts) being returned Immutable

    }


    // Overriding toString Method (Controlling what is printed when the PartBase object is printed)
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Product Base contains ").append(idMap.size()).append(" parts or products\n");
        return builder.toString();
    }
}
