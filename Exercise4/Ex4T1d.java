// Class for program application for Exercise 4 Task 1d


import java.io.File;
import java.util.Map;

public class Ex4T1d {
    
    // Main Method
    public static void main(String[] args) {
        // Populating the partbase with the part lists of the given Lego Product
        // Creating a new part base
        PartBase base = new PartBase();

        // A BricksetCsvReader() object does everything from reading the lego csv files to adding all parts and products to the part base
        new BricksetCsvReader().addFolderToBase(base, new File("./lego_files")); // lego_files is the folder where all the .csv files are contained -> File(Folder Directory) => represents a folder

        // We want to find a product in our entire part base with a particular ID

        // Product ID
        String prodID = "75095-1";

        Product product = (Product) base.find(prodID); // Returns the Part/Product corresponding to the id 30496-1
        // find() method returns a Part object
        // Product product = base.find(String id) => Product product = Part part -> Not allowed due to Polymorphism (since Part is superclass to Product)
        // We can solve this using explicit typecasting
        // Product product = (Product) base.find("30496-1")

        System.out.println(product.getRequirements());


        // Poupulating a warehouse object from the warehouse_stock.csv file
        // Creating a new warehouse object
        Warehouse wH = new Warehouse();

        // Directory of the folder where the csv file is contained
        String dir = "./warehouse_files";

        // Invoking the Warehouse csv file reader object
        new WarehouseCsvReader().addFolderToWH(wH,new File(dir));


        // STRATEGY:
        // Loop through all the Part->PartQuantity maps in the part requirement list of the product
        // For each iteration, get the PartID of the part and the corresponding required quantity
        // Check if the part corresponding to the extracted ID is existing in the Warehouse stock using isAvailable(partID) method
        // If it is available, stock out the part in the required quantity from the warehouse stock -> if it is not available, then the entire loop breaks since 
        // now the product can't be made anymore

        int productNum = 0;

        for(Map.Entry<Part,PartQuantity> entry : product.getRequirements().getPartList().entrySet()){

            // Variable for counting the number of products which can be made
            
            // for each part in the part requirement list, checing if the part is available in the warehouse stock
            if(wH.isAvailable(entry.getKey().getID()) == null){
                break; // The for loop is broken since the product can't be made anymore
            }

            else{
                // Stocking out the part with the required quantity
                wH.stockOut(wH.isAvailable(entry.getKey().getID()), entry.getValue());

                System.out.println("Stocking Out");
                productNum = productNum + 1;
            }
        }
        System.out.println("The number of " + product.getName() + " which can be produced with the given warehouse stock are: " + productNum);


    }
}
