// Class for program application for Exercise 3 Task 1a

public class Ex4T1a {
    
    // Main Method
    public static void main(String[] args){

        // New Parts
        Part p1 = new Part("101","Part1");
        Part p2 = new Part("121","Part2");
        Part p3 = new Part("231","Part3");
        Part p4 = new Part("501","Part4");
        Part p5 = new Part("801","Part5");

        // Stocking in all the above parts in a warehouse
        Warehouse wH = new Warehouse();
        wH.stockIn(p1, new PartQuantity(10, "Grams"));
        wH.stockIn(p2, new PartQuantity(4, "Litres"));
        wH.stockIn(p3, new PartQuantity(7, "Units"));
        wH.stockIn(p4, new PartQuantity(3, "Pcs"));
        wH.stockIn(p5, new PartQuantity(102, "Batches"));

        // Part ID to be checked
        String checkID = "801";

        // Checking the warehouse stock to check if the part with the checkID is present or not

        // ITERATION 1:
        // isAvilable(id) method of Warehouse object returns true if the ID matches
        // if(wH.isAvailable(checkID)){
        //     System.out.println("The part with the ID "+checkID+" is present in the stock currently.");
        // } 
        // else{
        //     System.out.println("The part with the ID "+checkID+" is not present in the stock currently.");
        // }

        // ITERATION 2:
        // isAvilable(id) method of Warehouse object returns the part quantity of the matching part if the ID matches or null if there is no ID match
        if(wH.isAvailable(checkID) != null){
            System.out.println("The part with the ID "+checkID+" is present in the stock currently.");
            System.out.println("The quantity of the part in the current stock is: "+wH.isAvailable(checkID).getQuantity() + " "+wH.isAvailable(checkID).getUnitDescriptor());
        }

        // Stocking out a part with a required part quantity
        Part part = new Part("101","Part1");
        System.out.println("The quantity of part 1 in the stock before stocking out is: " + wH.isAvailable("101"));
        wH.stockOut(part, new PartQuantity(4, "Grams"));
        System.out.println("The quantity of part 1 in the stock before stocking out is: " + wH.isAvailable("101"));

        // else{
        //     System.out.println("The part with the ID "+checkID+" is not present in the stock currently.");
        // }

        // ITERATION 3:
        // isAvailable(id) method of Warehouse object returns the Part Object of the matching part if the ID matches or null if there is no ID match
        // if(wH.isAvailable(checkID) != null){
        //         System.out.println("The part (" + wH.isAvailable(checkID).getName() + ") with the ID "+checkID+" is present in the stock currently.");
        //     }


        
    }
}
