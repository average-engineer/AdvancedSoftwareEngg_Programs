// Using the developed ERP to develop an Apple Pie
public class testApplication{

    // Main Method
    public static void main(String[] args){
        // System.out.println(new PartQuantity(100,"g")); // Creating a new part quantity of 100g and printing it
        // PartQuantity quantity = new PartQuantity(100,"g");
        // System.out.println(quantity);   
        // System.out.println(new Part("2","testpart"));

        // Product -> Apple Pie
        Product applePie = new Product("p1","Apple Pie");
        System.out.println(applePie);

        // Part 1: Egg
        Part egg = new Part("1","Egg");
        // Eggs Quantity
        PartQuantity eggQuantity = new PartQuantity(4,null);
        // Part 2: Sugar
        Part sugar = new Part("1","Sugar");
        // Sugar Quantity
        PartQuantity sugarQuantity = new PartQuantity(250,"g");
        // Part 3: Butter
        Part butter = new Part("1","Butter");
        // Butter Quantity
        PartQuantity butterQuantity = new PartQuantity(125,"g");
        // Part 4: Milk
        Part milk = new Part("1","Milk");
        // Eggs Quantity
        PartQuantity milkQuantity = new PartQuantity(100,"ml");
        // Part 5: Flour
        Part flour = new Part("1","Flour");
        // Eggs Quantity
        PartQuantity flourQuantity = new PartQuantity(300,"g");
        // Part 6: Baking Powder
        Part bakingPowder = new Part("1","Baking Powder");
        // Baking Powder Quantity
        PartQuantity bpQuantity = new PartQuantity(3,"tsp");
        // Part 7: Apple
        Part apple = new Part("1","Apple");
        // Apples Quantity
        PartQuantity appleQuantity = new PartQuantity(5,"m-size"); // Medium Sized

        // Since Apple Pie is a Product Object, it already has a privately defined PartRequirementList Object and we don't need to define one seperately
        // We add all the ingredients and their respective quantities to the part requirement list of the Apple Pie Product Object
        applePie.addRequirement(egg, eggQuantity);
        applePie.addRequirement(sugar, sugarQuantity);
        applePie.addRequirement(butter, butterQuantity);
        applePie.addRequirement(milk, milkQuantity);
        applePie.addRequirement(flour, flourQuantity);
        applePie.addRequirement(bakingPowder, bpQuantity);
        applePie.addRequirement(apple, appleQuantity);

        // Extracting the requirement list (ingredient list) for the Appple Pie Product Object
        // System.out.println("The ingredient list is: \n");
        System.out.println(applePie.getRequirement()); // getRequirement returns a PartRequirementList Object and thus the system will print out according 
                                                       // to what has been defined in the toString() method of the PartRequirementList Object

        // Defining the stock of ingredients we have (Warehouse)
        Warehouse warehouse = new Warehouse();
        // Stocking In Ingredients
        warehouse.stockIn(egg, new PartQuantity(10, null));
        warehouse.stockIn(sugar, new PartQuantity(1000, "g"));
        warehouse.stockIn(butter, new PartQuantity(500, "g"));
        warehouse.stockIn(milk, new PartQuantity(1000, "ml"));
        warehouse.stockIn(flour, new PartQuantity(1000, "g"));
        warehouse.stockIn(bakingPowder, new PartQuantity(200, "tsp"));
        warehouse.stockIn(apple, new PartQuantity(20, "m-size"));
        // Printing out the warehouse 
        System.out.println(warehouse);

        // We will produce apple pies as long as the required parts are available
        int count = 0; // Variable for keeping count of apple pies
        while(warehouse.isAvailable(applePie.getRequirement().getPartList())){ // While loop runs as long as the isAvailablwe method returns true (i.e. the ingredients are available)
            System.out.println("Stocking out Apple Pie");
            // As the apple pies are made, the parts keep getting stocked out
            warehouse.stockOut(applePie.getRequirement().getPartList());
            count = count + 1;
        }

        System.out.println("We can bake " + count + " apple pies." );
        System.out.println(warehouse); // Seeing what is left in out warehouse

    }
}
  