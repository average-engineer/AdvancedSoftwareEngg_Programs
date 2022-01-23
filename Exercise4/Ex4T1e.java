// Class for program application for Exercise 4 Task 1e


import java.io.File;

public class Ex4T1e {
    
    // Main Method
    public static void main(String[] args) {
        // Populating the partbase with the part lists of the given Lego Product
        // Creating a new part base
        PartBase base = new PartBase();

        // A BricksetCsvReader() object does everything from reading the lego csv files to adding all parts and products to the part base
        new BricksetCsvReader().addFolderToBase(base, new File("./lego_files")); // lego_files is the folder where all the .csv files are contained -> File(Folder Directory) => represents a folder

        // We want to find a product in our entire part base with a particular ID

        // Product ID for product 1
        String prodID1 = "75060-1";
        // Required number of product 1
        int reqProd1 = 1; 

        Product product1 = (Product) base.find(prodID1); // Returns the Part/Product corresponding to the id 30496-1
        // find() method returns a Part object
        // Product product = base.find(String id) => Product product = Part part -> Not allowed due to Polymorphism (since Part is superclass to Product)
        // We can solve this using explicit typecasting
        // Product product = (Product) base.find("30496-1")

        // Product ID for product 2
        String prodID2 = "75096-1";

        Product product2 = (Product) base.find(prodID2); // Returns the Part/Product corresponding to the id 30496-1
        // find() method returns a Part object
        // Product product = base.find(String id) => Product product = Part part -> Not allowed due to Polymorphism (since Part is superclass to Product)
        // We can solve this using explicit typecasting
        // Product product = (Product) base.find("30496-1")

        


        // Populating a warehouse object from the warehouse_stock.csv file
        // Creating a new warehouse object
        Warehouse wH = new Warehouse();

        // Directory of the folder where the csv file is contained
        // The warehouse stock is poupulated here
        String dir = "./warehouse_files";

        // Invoking the Warehouse csv file reader object
        new WarehouseCsvReader().addFolderToWH(wH,new File(dir));

        // Creating the Product 1 the required number of times
        // The warehouse stock will get stocked out the equal number times
        // The loop runs till the required number of times Product1 has been made
        // The second condition to kill the loop is incase the stock of the required parts become insufficient
        
        int p1count = 0; // Variable for keeping a count of how many times Product1 has been made
        while(p1count < reqProd1 && wH.isAvailable(product1.getRequirements().getPartList())){
            wH.stockOut(product1.getRequirements().getPartList());
            p1count = p1count + 1;
        }
        System.out.println("Number of "+product1.getName()+" produced: "+p1count);
        

        // STRATEGY:
        // We now need to stock out the warehouse for creating Product 2
        // The while loop now needs to be killed only when the part stock required for part2 runs out

        // Variable for counting the number of products which can be made
        int product2Num = 0;

        while(wH.isAvailable(product2.getRequirements().getPartList())){// While all the required parts for the product are available in the stock
            // Stocking out all the required parts (and the required quantities) from the warehouse stock
            // For each iteration of the while loop (and for one whole for loop in each while loop iteration)
            // One single product will be made by stocking out therequired parts from the warehouse stock
            wH.stockOut(product2.getRequirements().getPartList());
            System.out.println("Stocking out the parts and creating 1 " + product2.getName());
            product2Num = product2Num + 1;
        }

        System.out.println("The number of " + product2.getName() + " which can be produced after " + reqProd1 + " " +product1.getName()+ " have been produceed are: " + product2Num);
        System.out.println("*********************************************************");
        // System.out.println("The modified warehouse stock is given by:");
        // System.out.println(wH);

    }
}

