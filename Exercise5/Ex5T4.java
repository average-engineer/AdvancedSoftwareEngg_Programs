// Exercise 5 Task 4

public class Ex5T4 {

    // Main Method
    public static void main(String[] args){

        // Test Arrays
        int[] test1 = {1,1,2,2,1};
        int[] test2 = {1,1,2,2,2,1};
        int[] test3 = {1,1,1,2,2,2,1};
        System.out.println(noTriples(test1));
        System.out.println(noTriples(test2));
        System.out.println(noTriples(test3));

    }

    // Tripple Finding Method
    // If an integer array doesn't contain a triple, then true is printed, otherwise false
    public static boolean noTriples(int[] nums){
        // Looping through all the elements of the array
        for(int i = 0; i < nums.length; i++){
            // First Element
            if(i == 0){
                if(nums[i] == nums[i+1] && nums[i] == nums[i+2]){
                    return false;
                }
            }

            // Last Element
            else if(i == nums.length - 1){
                if(nums[i] == nums[i-1] && nums[i] == nums[i-2]){
                    return false;
                }
            }

            // Middle Element
            else{
                if(nums[i] == nums[i-1] && nums[i] == nums[i+1]){
                    return false;
                }
            }
        }

        return true;
    }
    
}
