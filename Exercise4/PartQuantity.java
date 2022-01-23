// Class for the object describing the Part Quantity

public class PartQuantity{

    // Quantity Value
    private double quantity;
    // Unit of Quantity (kgs, litres, # sets, pairs etc.)
    private String unitDescriptor;

    // Class Constructor
    public PartQuantity(double quantity,String unitDescriptor){

        setQuantity(quantity);
        setunitDescriptor(unitDescriptor);

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
    // System.out.println(new PartQuantity(100,'g')) will give us the reference ID of the location of the PartQuantity object in the memory
    // We want the output to be printed in human readable format (i.e. the part quantity in numbers and its unit) so we overwrite the toString() method
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
