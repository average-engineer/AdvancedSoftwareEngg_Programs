// Class for reading any .csv file in a particular folder

// Importing File object
import java.io.File;
// Importing FilenameFilter object
import java.io.FilenameFilter;
// Importing List Objects
import java.util.List;
// Importing FileInputStream object
import java.io.FileInputStream;
// Importing IOException object
import java.io.IOException;
// Importing InputStreamReader Object
import java.io.InputStreamReader;
// Importing Standard Charsets class
import java.nio.charset.StandardCharsets;

// Importing opencsv module and its methods
import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderBuilder;
// import CSVParser;
// import CSVReader;
// import CSVParserBuilder;
// import CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

public abstract class AbstractLegoCsvReader { // AbstractLegoCsvReader is an abstract class
    
    // Method which returns multiple csv files in a particular folder as a file array
    public File[] findCSVFilesInFolder(File folder){ // Returns an array of File Objects
        return folder.listFiles(new FilenameFilter() { // FilenameFiler() method just filters the files of a given type (.csv in our case) in the folder based on their name
            @Override
            // Advanced Implementation (No need to go too deep into it)
            public boolean accept(File dir, String name){ // accept(directory, name of the file in the directory)
                return name.endsWith(".csv"); // True is returned only for file names ending with ".csv"
            }
        });
    }

    // Method to read the CSV data from the file
    public List<String[]> readCsvDataFromFile(File file){ // A list object is returned whose elements are String arrays
        // This is how the readCsvDataFromFile() method reads the csv file and returns the content -> as a list of string arrays
        try{
            CSVParser parser = new CSVParserBuilder().withSeparator(',').build(); // File is seperated by commas
            CSVReader reader = new CSVReaderBuilder(
                // Advanced Stuff, no need to go in too deep
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)).withCSVParser(parser).withSkipLines(1).build();
            
            return reader.readAll();
        } catch(IOException | CsvException e){ // The program is not able to read the file (the file is corrupted, the file doesn't exist etc.) -> IO Exception error is returned
            System.err.println("File: " + file + "not found or not accessible {" + e.getMessage() + "}");
            return null; // Null returned since we didn't create any list of strings extracted from the csv file
        }
    }


}
