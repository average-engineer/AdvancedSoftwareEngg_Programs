// Class for rading and parsing the csv files related to warehouse stock
// Subclass of the abstract class AbstractCsvReader

import java.io.File;
import java.util.List;

public class WarehouseCsvReader extends AbstractCsvReader {

    // Class Constructor not defined so by default we call this class by WarehouseCsvReader()

    // Content Format in each csv File
    // 	PartID	Quantity	
    //  ....       ....     
    //  ....       ....     
    //  ....       ....    

    // How the content is stored -> List of String Arrays
    // Number of elements in the list (Number of String Arrays) -> Number of Rows in the csv file
    // Number of elements in each string array -> Number of columns in the csv file
    // Each element of the string array will be the field which is seperated from other fields by comma in the csv file

    // The length of the List of string array returned from the readCsvDataFromFile() method is 2 (2 columns)
    // The size of the List of string array returned from the readCsvDataFromFile() method is #rowsx2 

    // Defining a static and final (with fixed value and can be initialised only once) integer variable for the number of columns in the csv file
    private static final int EXPECTED_LENGTH = 2;

    // Defining a static and final (with fixed value and can be initialised only once) integer variable for column number where the part ID is stored
    private static final int IDX_PARTID = 0;

    // Defining a static and final (with fixed value and can be initialised only once) integer variable for column number where the part quantity is stored
    private static final int IDX_QUANTITY = 1;


    // Method to add a complete folder to the part base
    public void addFolderToWH(Warehouse wH, File csvFolder){
        File[] csvFiles = findCSVFilesInFolder(csvFolder); // Method for finding csv file in a particular folder (method belong to abstract class AbstractLegoCsvReader)
        // csvFiles is an array of File objects

        for(File csvFile : csvFiles){ // Looping through all the csv files in the file array
            addFileToWH(wH, csvFile); // Adding each csvfile in the folder to the part base and parsing all its contents and extracting product and part info it
        }
    }
    
    // Method to adding file to the warehouse stock (Part -> Part Quantity Map)
    public void addFileToWH(Warehouse wH, File csvFile){
        // First we need to read our csv file (File contents returned as List of string arrays)
        List<String[]> entries = readCsvDataFromFile(csvFile);
        // Checking if the entries are null (i.e. we couldn't read anything)
        // REMINDER: readCsvDataFromFile() method returns null and throws an IO error exception if we aren't able to read the csv file for whatever reason
        // We also check for the situation we were able to detect the csv file (i.e. the file exists and is not corrupted) but the file was simply empty and had no data
        // We check the above situation by inspecting the size of the list of string 'entries'. If the size is zero, we know that the csv file is empty
        
        if(entries == null || entries.size() == 0){
            return; // Just return nothing since this is a void returning method
        }

        // Variable for storing the iteration count of the loop (for the part name)
        int count = 0;
        // Creating new parts from each entries (csv file content) and adding them to the Product (as parts requirement list)
        for(String[] entry: entries){ // entry is a String array which loops through all the string array elements of the List object entries (csv file content)
            if(entry.length < EXPECTED_LENGTH){
                continue; // Continue to the next iteration of the for loop (the current line is skipped)
            }

            // Extracting part information from the string array
            String id = entry[IDX_PARTID];

            // Extracting the quantity information of the part
            int quantity = Integer.parseInt(entry[IDX_QUANTITY]); // parseInt() method of the Integer class converts strings (or any other datatype) to integers
            // quantity is an integer now which needs to be converted to a PartQuantity object

            
            // ITERATION 2: Corresponding to ITERATION 2 of the isAvailable(id) method of Warehouse
            // Finding the part cooresponding to the extracted id in our existing stock of the warehouse
            // the isAvailable(partID) method of the Warehouse object is used
            // If the part corresponding to the part ID is not present then null is returned
            // Part Quantity object is returned by the isAvailable(partID) method
            PartQuantity availableQuantity = wH.isAvailable(id);

            if(availableQuantity == null){ // ie the part is not yet in the warehouse stock
                Part part = new Part(id,"PART " + count); // The part name is artificially created
                // Add the new part to the existing warehouse stock
                wH.stockIn(part, new PartQuantity(quantity,"pieces"));
            }

            // ITERATION 3: Corresponding to ITERATION 2 of the isAvailable(id) method of Warehouse
            // Finding the part corresponding to the extracted id in our existing stock of the warehouse
            // the isAvailable(partID) method of the Warehouse object is used
            // If the part corresponding to the part ID is not present then null is returned
            // Part object is returned by the isAvailable(partID) method
            // Part placeHolderPart = wH.isAvailable(id);

            // if(placeHolderPart == null){ // ie the part is not yet in the warehouse stock
            //     Part part = new Part(id,"PART " + count); // The part name is artificially created
            //     // Add the new part to the existing warehouse stock
            //     wH.stockIn(part, new PartQuantity(quantity,"pieces"));
            // }


            count = count + 1;


        }

    }
    
}
