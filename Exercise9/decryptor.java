import java.util.HashMap;
import java.util.Map;

public class decryptor {
    // Instance variables
    private int[] numberList;
    private String message;
    private HashMap<Integer,String> map = new HashMap<Integer,String>();
    private String[] correctMessage;

    // Class Constructor
    public decryptor(int[] numberList, String message){
        this.numberList = numberList;
        this.message = message;
    }

    // Method for decryption
    // Strategy:
    // The input message string is split to create a string array
    // Each corresponding string (letter) and the integer in the numberList array are fed into a HashMap as values and keys repectively.
    // The hashmap is looped through, then an empty string array of similar size is populated and then converted to a string
    public String decrypt(){
        // Splitting the message string to create a string array
        String[] letters = message.split("");
        if(letters.length != numberList.length){
            throw new IllegalArgumentException("Invalid Arguments");
        }

        // Storing the letters as values and the numbers as keys in the hashmap
        for(int ii = 0; ii < numberList.length; ii++){
            // Populating the hashmap
            map.put(numberList[ii], letters[ii]);
        }

        // Setting the length of the empty string array
        String[] emptyStrArr = new String[letters.length];
        correctMessage = emptyStrArr;
        // Looping through the map and populating the empty string array
        for(Map.Entry<Integer, String> entry: map.entrySet()){
            // The key of each entry will be the index number in the new string array and the string placed at that index will be the value of each entry
            correctMessage[entry.getKey()] = entry.getValue();
        }

        // Converting the String array to a string
        // String decrMessage = correctMessage.toString(); // Doesn't work, the reference location of the returned string in the memory is returned
        // String buffer used to return and print the actual string
        StringBuffer decrMessage = new StringBuffer();
        for(String letter: correctMessage){
            decrMessage.append(letter);
        }

        return decrMessage.toString();
        
    }
}
