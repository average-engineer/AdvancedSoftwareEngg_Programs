// Class for program application for Exercise 4 Task 1d


import java.io.File;
//import java.util.Map;

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
        String prodID = "75086-1";

        Product product = (Product) base.find(prodID); // Returns the Part/Product corresponding to the id 30496-1
        // find() method returns a Part object
        // Product product = base.find(String id) => Product product = Part part -> Not allowed due to Polymorphism (since Part is superclass to Product)
        // We can solve this using explicit typecasting
        // Product product = (Product) base.find("30496-1")

        


        // Poupulating a warehouse object from the warehouse_stock.csv file
        // Creating a new warehouse object
        Warehouse wH = new Warehouse();

        // Directory of the folder where the csv file is contained
        // The warehouse stock is poupulated here
        String dir = "./warehouse_files";

        // Invoking the Warehouse csv file reader object
        new WarehouseCsvReader().addFolderToWH(wH,new File(dir));

        //**************************************************************************************************************** */
        // DEBUGGING CODE -> Start

        // if(wH.isAvailable("4212008") == null){
        //     System.out.println("This part is not present");
        // }

        // int count1 = 0;
        // String var1 = null;

        // for(Map.Entry<Part, PartQuantity> entry : wH.getStock().entrySet()){
        //     System.out.print(entry.getKey().getID());
        //     if(wH.isAvailable(entry.getKey().getID()) != null){
        //         System.out.println("\t This part is available");
        //     }
        //     count1 = count1 + 1;
        //     if(count1 == 2 ){
        //         var1 = entry.getKey().getID();
        //     }
        // }
        // System.out.println(var1);
        // if(var1.equals("4645730")){
        //     System.out.println("yes");
        // }
        // else{
        //     System.out.println("no");
        // }

        // int count2 = 0;
        // for(Map.Entry<Part, PartQuantity> entries : product.getRequirements().getPartList().entrySet()){
        //     // System.out.print(entries.getKey().getID());
        //     // if(wH.isAvailable(entries.getKey().getID()) == null){
        //     //     System.out.println("\t This part is not available");
        //     // }
        //     count2 = count2 + 1;
        //     if(entries.getKey().getID().equals("4528323")){
        //         String var2 = entries.getKey().getID();
        //         System.out.println(var2);
        //     }

        // }

        // DEBUGGING CODE -> End
        //***************************************************************************************************************** */

        



        // STRATEGY:
        // Run a loop while any one of the parts in the part requirement list of the product are available (in sufficient amount) in the stock of the warehouse
        // The loop should stop as soon as the available quantity is less than the required quantity for the part in the product part list
        // Input the part requirement list of the product into the isAvailable(partList) method of the Warehouse object
        // Inside the loop, keep stocking out the required parts from the stock using the stockOut(partList) where the input
        // is the partList of the product

        // Variable for counting the number of products which can be made
        int productNum = 0;

        while(wH.isAvailable(product.getRequirements().getPartList())){// While all the required parts for the product are available in the stock
            // Stocking out all the required parts (and the required quantities) from the warehouse stock
            // For each iteration of the while loop (and for one whole for loop in each while loop iteration)
            // One single product will be made by stocking out therequired parts from the warehouse stock
            wH.stockOut(product.getRequirements().getPartList());
            System.out.println("Stocking out the parts and creating 1 " + product.getName());
            productNum = productNum + 1;
        }

        System.out.println("The number of " + product.getName() + " which can be produced with the given warehouse stock are: " + productNum);
        System.out.println("*********************************************************");
        // System.out.println("The modified warehouse stock is given by:");
        // System.out.println(wH);

    }
}
