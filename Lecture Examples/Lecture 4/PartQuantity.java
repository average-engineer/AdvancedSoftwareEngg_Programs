// Class for the object describing the Part Quantity

public class PartQuantity{

    // Quantity Value
    private double quantity;
    // Unit of Quantity (kgs, litres, # sets, pairs etc.)
    private String unitDescriptor;

    // Class Constructor
    public PartQuantity(double quantity,String unitDescriptor){

        setQuantity(quantity);
        setUnitDescriptor(unitDescriptor);

    }

    // Getter and Setter Functions for the Quantity values and units
    public double getQuantity(){
        return quantity;
    }

    public String getUnitDescriptor(){
        return unitDescriptor;
    }

    // The required quantity and its units should be muttable globally from outside this class
    public void setQuantity(double quantity){

        this.quantity = quantity;

    }

    public void setunitDescriptor(String unitDescriptor){
        this.unitDescriptor = unitDescriptor;
    }

    // Overwriting the toString() method for the PartQuantity object 
    public String toString(){
        return getQuantity() + (getUnitDescriptor() != null ? getUnitDescriptor() : " "); // Short Form for if else condition

        // if(getUnitDescriptor != null){
            // getUnitDescriptor();
            //}
        // else{
            // return " ";
            //}
    }
}   
