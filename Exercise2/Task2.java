// Exercise 2 Task 2

public class Task2{
    public static void main(String[] args){

        // Integer Array Size:
        int n = 10;
        // Integer Array
        int[] intArr = new int[n];
        // This array will contain the Fibbonaci Series
        for(int i = 0;i < n ;i++){// Remeber that the last element is the (n-1)st element
            if(i<2){
                intArr[i] = i;
                // System.out.print(intArr[i] + ", ");
                continue;
            }
            intArr[i] = intArr[i-1] + intArr[i-2];
            // System.out.print(intArr[i] + ", ");
        }

        // System.out.println(Arrays.toString(intArr));

        // We have to now print out the each element of the array as long as the sum of printed values is less than the product of first and last element of the array
        int count = 0; // Counter Variable
        // For this application, change the first element of the array to 1 since when it is zero, nothing will get printed
        intArr[0] = 1;
        int ref = intArr[n-1]*intArr[0]; // Reference Value -> Product of first and last element
        // Using for loop
        System.out.println("Using For Loop");
        for(int j = 0;j < n;j++){

            count = count + intArr[j];
            if(count < ref){

                System.out.println(intArr[j]); // Expected number till which array is output -> 8 (with 13, the sum becomes 34 which is not smaller but equal)

            }

        }

        // Using while loop
        System.out.println("Using While Loop");
        int cnt = 0;
        int k = 0;
        while(cnt < ref){
            cnt = cnt + intArr[k];
            if(cnt >= ref){
                continue; // Extra check to ensure that the element at which sum becomes equal (in my case) or becomes larger is not printed
            }
            System.out.println(intArr[k]);
            k++;
        }


        // Using do while loop
        System.out.println("Using do While loop");
        int counter = 0;
        int iter = 0;
        do{
            counter = counter + intArr[iter];
            if(counter >= ref){
                continue;
            }
            System.out.println(intArr[iter]);
            iter++;
        }
        while(counter < ref);

        // Using for each loop
        System.out.println("Using for each loop");
        count = 0;
        for(int value : intArr){ // The for each loop is equivalent to how Python for loop works -> for value in range(0,n) for example
            count = count + value;
            if(count < ref){

                System.out.println(value); // Expected number till which array is output -> 8 (with 13, the sum becomes 34 which is not smaller but equal)

            }
        }
    }
}