// Exercise 6 Task 5

public class Ex6T5 {
    
    public static void main(String[] args) {

        String strangerName = "Hfjxfw";
        System.out.println("The name of the stranger was " + caeserDecryptor(strangerName.toLowerCase(),5));
        System.out.println("Yesterday he woke me up from my sleep just to spout the following shit:");
        // Input String (what the stranger said)
        String inputStr = "Mjqqt, N 1nxm 3tz f 1tsijwkzq j0jsnsl. N 1fx 1fnynsl tzyxnij 3tzw mtzxj gjhfzxj ymj ittw 1fxs'y qthpji. N hfs fxxzwj 3tz ymfy st gzwlqfwx tw ymnj0jx mf0j jsyjwji. N 1nxm 3tz f Rjww3 Hmwnxyrfx fsi f Mfuu3 Sj1 3jfw.";

        // Converting the string to a string array, delimiter -> single width space
        String[] inputStrArr = inputStr.split(" ");

        // Iterating over the input string array
        for(String ipStr : inputStrArr){
            System.out.print(caeserDecryptor(ipStr.toLowerCase(),5) + " "); // ensuring all letters in the input strings are lower case
        }

        // Reencrypting back everything
        System.out.println("The name of the stranger was " + caeserEncryptor(caeserDecryptor(strangerName.toLowerCase(),5),5));

        // Iterating over the input string array
        for(String ipStr : inputStrArr){
            System.out.print(caeserEncryptor(caeserDecryptor(ipStr.toLowerCase(),5),5) + " "); // ensuring all letters in the input strings are lower case
        }

    }

    // Decrypter Algorithm -> Caeser's Cipher
    // Alphabets in the encrypted text are replaced by alphabets placed some fixed (n) places to the left or the right of the encrypted alphabet
    // For the given problem: Left Shift of 4

    public static String caeserDecryptor(String str, int shift){

        // Initialising the string which will be returned
        String decrptStr = "";

        // Alphabets String
        String alphabets = "abcdefghijklmnopqrstuvwxyz01234";

        // Splitting the input string to make a string array containing all the characters of the string as individual strings
        String[] spltstr = str.split("");

        // variable to keep count of the iterations through the string array
        int count = 0; 

        // Looping though all the strings in the string array and checking if it exists in the Alphabets string
        for(String ch : spltstr){

            // Updating iteration counter
            count = count + 1;

            if(alphabets.contains(ch)){ // Checking if the string is a part of the alphabets string
                int indx = alphabets.indexOf(ch); // Obtaining index of the letter

                // IMPORTANT: We need to implement wrapping around
                // for a left shift of 4 (example), D should decrypt to Y, B should decrypt to W, so on and so forth

                if(indx >= shift){
                    // No wrapping around needed
                    indx = indx - shift; // Modifying the index based on the required shift
                }

                else if(indx < shift){
                    // Wrapping around needs to be implemented
                    indx = (alphabets.length()) - 1 - (shift - indx); // (alphabets.length()) - 1 refers to the index of "4"
                }

                
                char chmod = alphabets.charAt(indx); // Letter at the modified index (Datatpe of the letter -> Char)
                
                /* Longer Method of converting character to string
                // Converting to a character array
                char[] chmodArr = {chmod};
                String chMod = new String(chmodArr); // Converting the character array to a string */

                String chMod = String.valueOf(chmod);

                // Concatinating the decrypted letter to the string to be returned
                decrptStr = decrptStr.concat(chMod);
            }

            else{ // if the letter (string) is not present in the alphabet string
                decrptStr = decrptStr.concat(ch); // The string is unmodified
            }
        }

        return decrptStr;

    }

    // Method to encrypt text
    public static String caeserEncryptor(String str, int shift){

        // Initialising the string which will be returned
        String encrptStr = "";

        // Alphabets String
        String alphabets = "abcdefghijklmnopqrstuvwxyz01234";

        // Splitting the input string to make a string array containing all the characters of the string as individual strings
        String[] spltstr = str.split("");

        // variable to keep count of the iterations through the string array
        int count = 0; 

        // Looping though all the strings in the string array and checking if it exists in the Alphabets string
        for(String ch : spltstr){

            // Updating iteration counter
            count = count + 1;

            if(alphabets.contains(ch)){ // Checking if the string is a part of the alphabets string
                int indx = alphabets.indexOf(ch); // Obtaining index of the letter

                // IMPORTANT: We need to implement wrapping around
                // for a left shift of 4 (example), D should decrypt to Y, B should decrypt to W, so on and so forth

                if(indx < (alphabets.length() - shift)){
                    // No wrapping around needed
                    indx = indx + shift; // Modifying the index based on the required shift
                }

                else if(indx >= (alphabets.length() - shift)){
                    // Wrapping around needs to be implemented
                    indx = (shift + indx) - alphabets.length(); // (alphabets.length()) -> 31
                }

                
                char chmod = alphabets.charAt(indx); // Letter at the modified index (Datatpe of the letter -> Char)
                
                /* Longer Method of converting character to string
                // Converting to a character array
                char[] chmodArr = {chmod};
                String chMod = new String(chmodArr); // Converting the character array to a string */

                String chMod = String.valueOf(chmod);

                // Concatinating the decrypted letter to the string to be returned
                encrptStr = encrptStr.concat(chMod);
            }

            else{ // if the letter (string) is not present in the alphabet string
                encrptStr = encrptStr.concat(ch); // The string is unmodified
            }
        }

        return encrptStr;

    }



    
    
    
}
