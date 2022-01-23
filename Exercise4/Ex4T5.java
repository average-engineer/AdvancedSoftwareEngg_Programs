// Class for program application for Exercise 4 Task 5

public class Ex4T5 {

    public static boolean noDuplicates(int[] nums){ // Static method
        // Variable for counting how many times the unequality condition is satisfied
        int hits = 0;
        
        for(int ii = 0; ii < nums.length ; ii++){
            
            // Comparing with numbers after the number at the index
            // Ensuring the last element is not considered
            if(ii != nums.length - 1){
                for(int jj = ii + 1; jj < nums.length; jj++){
                    if(nums[jj] != nums[ii]){
                        hits = hits + 1;
                    }
                }
            }

            // Comparing with numbers before the number at the index
            // Ensuring the first element is not considered
            if(ii != 0){
                for(int kk = ii; kk >= 0; kk--){
                    if(nums[kk] != nums[ii]){
                        hits = hits + 1;
                    }
                }
            }
        }

        if(hits == nums.length*(nums.length - 1)){ // The inequality condition should be satisfied n*(n-1) times, where n -> Array Length
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,9,2,3,8};
        int[] arr2 = {1,1,2,2,2,1};
        int[] arr3 = {1,8,6,1,3};
        //int[] arr3 = {1,2,3,4};
        System.out.println(noDuplicates(arr1));
        System.out.println(noDuplicates(arr2));
        System.out.println(noDuplicates(arr3));
        
    }
    
}