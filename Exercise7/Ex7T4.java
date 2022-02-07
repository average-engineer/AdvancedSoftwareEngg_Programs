// Exercise 7 Task 4

import java.util.Arrays;

public class Ex7T4 {
    
    // Series Array Method
    public static int[] seriesArray(int n){

        // Length of the array to be returned will be the sum of the first n natural numbers
        // Array to be returned
        int[] arr1 = new int[((n*(n+1))/2)];

        // Reference Array: containing the first n natural numbers
        int[] arr2 = new int[n];

        // Populating arr2
        for(int i = 0; i < arr2.length; i++){
            arr2[i] = i + 1;
        }

        // Variable for keeping record of the dynamic starting point in arr1
        int count = 0;

        // Populating arr1
        // The elements of arr1 can be broken down in sets:
        // {1,1,2,1,2,3,1,2,3,4,......,1,2,3,4,.....n}
        // {(1),(1,2),(1,2,3),(1,2,3,4),......,(1,2,3,4,.....n)}
        //{set1,set2,set3,......setn} -> n sets

        // The sets can be iterated over using arr2
        for(int ii = 0; ii < arr2.length; ii++){
            // Iterating over elements of arr1 -> from 0 to i
            for(int j = 0; j <= ii; j++){
                arr1[count + j] = arr2[j];
            }

            // Updating count Logic:
            // ii = 0 -> arr1[0] gets populated -> j = 0 -> count = 0
            // ii = 1 -> arr1[1:2] gets populated -> j = 0,1 -> count = 1
            // ii = 2 -> arr1[3:5] gets populated -> j = 0,1,2 -> count = 3
            // ii = 3 -> arr1[6:9] gets populated -> j = 0,1,2,3 -> count = 6

            // count: 0,1,3,6,10,14 and so on
            // the difference between each count update is equal to the corresponding element in arr2 for that particular iteration

            count = count + arr2[ii];
        }

        return arr1;

    }

    // Main Method
    public static void main(String[] args) {

        /*for(int i = 0; i < 5; i++){
            // int[] testArr = seriesArray(i);
            int [] testArr = {1,2,3};
            System.out.println(String.valueOf(testArr));
        } */

        System.out.println(Arrays.toString(seriesArray(3)));
        System.out.println(Arrays.toString(seriesArray(4)));
        System.out.println(Arrays.toString(seriesArray(2)));
        
    }
}
