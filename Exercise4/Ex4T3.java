// Class for program application for Exercise 4 Task 3

public class Ex4T3 {

    public static boolean array123(int[] nums){ // Static method
        for(int ii = 0; ii < nums.length ; ii++){
            // 123 can happen in a sequence only if 1 appears at atmost the index nums.length - 3 (2 indices before the last element
            if(ii < nums.length - 2 && nums[ii] == 1 && nums[ii + 1] == 2 && nums[ii + 2] == 3){

                return true;

            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,1,2,3,1};
        int[] arr2 = {1,1,2,4,1,3};
        int[] arr3 = {1,1,2,1,2,3};
        System.out.println(array123(arr1));
        System.out.println(array123(arr2));
        System.out.println(array123(arr3));
        
    }
    
}