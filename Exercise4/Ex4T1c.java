// Class for program application for Exercise 4 Task 1c

import java.io.File;
import java.util.Map;

public class Ex4T1c {
    
    // Main Method
    public static void main(String[] args) {
        // Creating a new warehouse object
        Warehouse wH = new Warehouse();

        // Directory of the folder where the csv file is contained
        String dir = "./warehouse_files";

        // Invoking the Warehouse csv file reader object
        new WarehouseCsvReader().addFolderToWH(wH,new File(dir));

        // Printing only those parts which have a stock less than 20 pieces
        System.out.println("The parts having quantities less than 20 are: ");

        for(Map.Entry<Part,PartQuantity> entry : wH.getStock().entrySet()){
            if(entry.getValue().getQuantity() < 20){
                System.out.println("\t" + entry.getValue().toString() +" " + entry.getKey().toString()); // toString() of PartQuantity + toString() of Part object printed
            }
        }
    }
    
    
}
