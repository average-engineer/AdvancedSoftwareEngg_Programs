// Class for program application for Exercise 4 Task 4

public class Ex4T4 {

    public static boolean arraywave(int[] nums){ // Static method
        // Variable for counting how many times the property of a waveform is satisfied
        int hits = 0;
        
        for(int ii = 0; ii < nums.length ; ii++){
            
            // Not considering the first and last elements
            if(ii != 0 && ii != nums.length - 1){
                if((nums[ii] < nums[ii + 1] && nums[ii] < nums[ii-1]) || (nums[ii] > nums[ii + 1] && nums[ii] > nums[ii-1])){
                    hits = hits + 1;
                }
            }

        }

        if(hits == nums.length - 2){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,3,2,5,1};
        int[] arr2 = {1,7,2,4,5};
        int[] arr3 = {1,4,2,1,9,8};
        //int[] arr3 = {1,2,3,4};
        System.out.println(arraywave(arr1));
        System.out.println(arraywave(arr2));
        System.out.println(arraywave(arr3));
        
    }
    
}