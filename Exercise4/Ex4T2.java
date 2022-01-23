// Class for program application for Exercise 4 Task 2

public class Ex4T2 {

    // Method to remove a character from a string from a desired index
    // Returns the string with the removed character
    public static String missingChar(String str, int n){ // Static method
        // Ensuring the index n is within the range of the input string
        if(n <= str.length() - 1 && n >= 0){
            // Splitting the string using the character at the specified index
            String subStr1 = str.substring(0, n); // substring ending just befoer the character at index n
            String subStr2 = str.substring(n+1, str.length()); // substring starting from just after index n and going till end

            // Concatinating the 2 substrings
            return subStr1.concat(subStr2);
        }

        else{
            return null;
        }
    }

    public static void main(String[] args) {
        
        String str = "kitten";
        // System.out.println(str.concat("My"));
        System.out.println(missingChar(str,1));
        System.out.println(missingChar(str,0));
        System.out.println(missingChar(str,4));
    }
    
}
