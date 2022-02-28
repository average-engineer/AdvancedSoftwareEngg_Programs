public class Ex9T3 {
    public static void main(String[] args) {

        // Message to be decrypted
        String message = "onoirsaoehfwedgeyuespydreiatfoodcruegvmsr";
        // Corresponding number list
        int[] list = {14,28,25,32,3,33,38,11,40,31,15,0,1,13,29,4,8,18,6,37,9,16,26,21,35,27,2,30,19,20,17,22,24,10,12,23,39,5,34,36,7};
            
        // Creating a new decryption object
        decryptor decoder = new decryptor(list,message);

        // Printing the decoded message
        System.out.println("THE DECODED MESSAGE IS:");
        System.out.println(decoder.decrypt()); 

        /*String[] messageArr = message.split("");
        System.out.println(messageArr[1]);*/
    }
}