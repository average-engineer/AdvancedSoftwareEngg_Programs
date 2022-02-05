// Exercise 5 Task 6

// Problem with this code-> It is limited when it comes to choosing array elements to be part of the group
// For example, right now we can only choose alternate elements only to be part of the group and not elements which are 2 elements apart

public class Ex5T6 {

    // Instance Variable
    public static int count = 0;

    // Main Method
    public static void main(String[] args){
        int[] testArr = {2,5,10,4};
        int[] testArr1 = {1,3,5,7,8,1};
        System.out.println(groupNoAdj(0,testArr,12));
        System.out.println(groupNoAdj(0,testArr,14));
        System.out.println(groupNoAdj(0,testArr,7));
        System.out.println(groupNoAdj(1,testArr,9));
        System.out.println(groupNoAdj(0,testArr1,14));
        System.out.println(groupNoAdj(1,testArr1,14));

    }


    public static boolean groupNoAdj(int Start, int[] num, int target){

        if((num[Start] + count) != target){
            count = count + num[Start];
            Start = Start + 2; // Choosing every alternate element starting from the index Start to be the part of the group
            if(Start < num.length){
                return groupNoAdj(Start,num,target); // Recursive call
            }

            count = 0; // Resetting the value of count for the next method call with different input paramater list
            return false;

        }

        else if((num[Start] + count) == target){

            count = 0; // Resetting the value of count for the next method call with different input paramater list
            return true;

        }

        return false;
    } 

}
