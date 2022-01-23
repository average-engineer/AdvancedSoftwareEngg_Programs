// Application for testing the ERP for Lego Parts and Products

import java.io.File;

public class LegoApplication {
    
    // Main Method
    public static void main(String[] args){
        // Creating a new part base
        PartBase base = new PartBase();

        // A BricksetCsvReader() object does everything from reading the lego csv files to adding all parts and products to the part base
        new BricksetCsvReader().addFolderToBase(base, new File("./lego_files")); // lego_files is the folder where all the .csv files are contained -> File(Folder Directory) => represents a folder

        // We want to find a product in our entire part base with a particular ID
        Product product = (Product) base.find("75080-1"); // Returns the Part/Product corresponding to the id 30496-1
        // find() method returns a Part object
        // Product product = base.find(String id) => Product product = Part part -> Not allowed due to Polymorphism (since Part is superclass to Product)
        // We can solve this using explicit typecasting
        // Product product = (Product) base.find("30496-1")

        System.out.println(product.getRequirements()); // product.getRequirements() returns the part requirement list of product which is then printed
    }

}
