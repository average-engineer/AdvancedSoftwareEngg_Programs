// Product Object is a specialized Part Object
// Product Class is the subclass of a Part Object

public class Product extends Part{

    private PartRequirementList requirements; // Stores the part requirements for the Product Object

    // Class Constructor
    public Product(String id, String name){
        super(id,name); // Manually invoking the Superclass Constructor definition (Part Object)

        this.requirements = new PartRequirementList(this); // "this" is used to refer to the Product Object itself since PartRequirementList Object takes the Product object as an input 
    }

    // Getter Function for the Part Requirement List of the Product
    public PartRequirementList getRequirement(){
        return requirements;
    }

    // Adding a Part Requirement List to our Product
    public boolean addRequirement(Part part, PartQuantity quantity){

        return requirements.addPartasRequirement(part,quantity);

    }

    // Getter method for extracting the requirement list corresponding to the Product Object
    public PartRequirementList getRequirements(){
        return requirements;
    }

}