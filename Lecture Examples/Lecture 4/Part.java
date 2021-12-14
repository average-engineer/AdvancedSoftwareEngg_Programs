// Class for an object defining a generic Part 

public class Part{

    // Characteristics of a Part -> Unique Part ID => String private to Part Object
    //                           -> Unique Part Name => String private to Part Object

    private String id;
    private String name;

    // Class Constructor
    // We want to reference each part by its Name and ID only
    public Part(String id, String Name){
        // Setting the Part names and IDs
        setName(name);
        setID(id);

        // Alternative Code:
        // this.id = id;
        // this.name = name;
    }

    // Getter and Setter functions to extract and set the Part Name and ID

    // VV IMPORTANT: Once the part has been produced, its Name and ID should be immutable.
    // Thus, the setter methods for both name and ID should be private
    // No one can access the setting methods globally from outside the Part class
    // setName and setID can only be used inside the Part class

    // Extracting name
    public String getName(){
        return name; // name here refers to the private class variable
    }

    // Setting name
    private void setName(String name){
        this.name = name; // name here refers to the local variable name defined by the setName methd
    }

    // Extracting ID
    public String getID(){
        return id; // id here refers to the private class variable
    }

    // Setting ID
    private void setID(String id){
        this.id = id; // id here refers to the local variable name defined by the setID methd
    }



}