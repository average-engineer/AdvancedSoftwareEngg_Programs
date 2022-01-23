// Class for parsing the lego brickset part list
// Uses the abstract class AbstractLegoCsvReader (for parsing and reading general Lego part list .csv files) 

import java.io.File;
import java.util.List;

public class BricksetCsvReader extends AbstractLegoCsvReader {

    // Class Constructor not defined so by default we call this class by BricksetCsvReader()

    // Content Format in each csv File
    // SetNumber	PartID	Quantity	Colour	Category	DesignID	PartName	ImageURL	SetCount
    //  ....         ....     ....        ....    ....        ....       ....         ....        ....
    //  ....         ....     ....        ....    ....        ....       ....         ....        ....
    //  ....         ....     ....        ....    ....        ....       ....         ....        ....

    // How the content is stored -> List of String Arrays
    // Number of elements in the list (Number of String Arrays) -> Number of Rows in the csv file
    // Number of elements in each string array -> Number of columns in the csv file
    // Each element of the string array will be the field which is seperated from other fields by comma in the csv file

    // The length of the List of string array returned from the readCsvDataFromFile() method is 9 (9 columns)
    // The size of the List of string array returned from the readCsvDataFromFile() method is #rowsx9 

    // Defining a static and final (with fixed value and can be initialised only once) integer variable for the number of columns in the csv file
    private static final int EXPECTED_LENGTH = 9;

    // Defining a static and final (with fixed value and can be initialised only once) integer variable for column number where the part ID is stored
    private static final int IDX_PARTID = 1;

    // Defining a static and final (with fixed value and can be initialised only once) integer variable for column number where the part quantity is stored
    private static final int IDX_QUANTITY = 2;

    // Defining a static and final (with fixed value and can be initialised only once) integer variable for column number where the part color is stored
    private static final int IDX_COLOR = 3;

    // Defining a static and final (with fixed value and can be initialised only once) integer variable for column number where the part name is stored
    private static final int IDX_PARTNAME = 6;

    // Defining a static and final (with fixed value and can be initialised only once) integer variable for column number where the part image URL is stored
    private static final int IDX_IMAGE_URL = 7;

    // Method to add a complete folder to the part base
    public void addFolderToBase(PartBase base, File csvFolder){
        File[] csvFiles = findCSVFilesInFolder(csvFolder); // Method for finding csv file in a particular folder (method belong to abstract class AbstractLegoCsvReader)
        // csvFiles is an array of File objects

        for(File csvFile : csvFiles){ // Looping through all the csv files in the file array
            addFileToBase(base, csvFile); // Adding each csvfile in the folder to the part base and parsing all its contents and extracting product and part info it
        }
    }
    
    // Method to adding file to the the part base (ID->Part Map)
    public void addFileToBase(PartBase base, File csvFile){
        // First we need to read our csv file (File contents returned as List of string arrays)
        List<String[]> entries = readCsvDataFromFile(csvFile);
        // Checking if the entries are null (i.e. we couldn't read anything)
        // REMINDER: readCsvDataFromFile() method returns null and throws an IO error exception if we aren't able to read the csv file for whatever reason
        // We also check for the situation we were able to detect the csv file (i.e. the file exists and is not corrupted) but the file was simply empty and had no data
        // We check the above situation by inspecting the size of the list of string 'entries'. If the size is zero, we know that the csv file is empty
        
        if(entries == null || entries.size() == 0){
            return; // Just return nothing since this is a void returning method
        }

        // Name of the csv file
        String fileName = csvFile.getName(); // getName() is a method of the class File whoch fetches the name of the file
        // Product ID (contained in the csv file name -> Brickset-inventory-30496-1.csv)
        String productID = fileName.substring(0,fileName.indexOf('(') - 1); // File name used in the lectures are different
        // substring() method of the String class basically returns a sliced version of the string in the index range metnioned
        // We slice the name from the first index (0) to just before the '.' in the file name. This sliced string will be our product ID
        String productName = fileName.substring(fileName.indexOf('(') + 1, fileName.indexOf(')')); // The files which the lecture uses is '75060-1 (Slave I).csv'

        // Creating a new product from the extracted csv file
        Product product = new Product(productID, productName);

        // Creating new parts from each entries (csv file content) and adding them to the Product (as parts requirement list)
        for(String[] entry: entries){ // entry is a String array which loops through all the string array elements of the List object entries (csv file content)
            if(entry.length < EXPECTED_LENGTH){
                continue; // Continue to the next iteration of the for loop (the current line is skipped)
            }

            // Extracting part information from the string array
            String id = entry[IDX_PARTID];
            // String name = entry[IDX_PARTNAME];
            // String quantity = entry[IDX_QUANTITY];

            // Finding the part cooresponding to the extracted id in our existing part base
            // If that particular part and its id is not present, then null is returned, otherwise the part corresponding to the input id is returned (how the find() method of the PartBase object has been made)
            Part part = base.find(id);

            if(part == null){ // ie the part is not yet in the part base
                // Create a new part of the object type LegoPart
                part = new LegoPart(id,entry[IDX_PARTNAME],entry[IDX_COLOR],entry[IDX_IMAGE_URL]); // LegoPart is a seperate object class for the parts of a lefo set
                // Add the new part to the existing part base
                base.add(part);

            }

            // Extracting the quantity information of the part
            int quantity = Integer.parseInt(entry[IDX_QUANTITY]); // parseInt() method of the Integer class converts strings (or any other datatype) to integers
            // quantity is an integer now which needs to be converted to a PartQuantity object

            // Adding the new part and its corresponding quantity to the requirement list of the product 
            product.addRequirement(part, new PartQuantity(quantity, "pieces")); // quantity should be a double data type but implicit typecasting from integer to double is allowed


        }

        // Adding the product to the part base (since product is a special form of a part)
        base.add(product);

    }

}
