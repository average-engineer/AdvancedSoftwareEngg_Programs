// Exercise 2 Task 4

// Computing the sum of all integers up to a given value
// Recursive function call to be used
// Example -> f(10) = 1 + 2 + 3 + ...... + 10 = 55

public class Task4{
    // Recursive Method
    public static int getSum(int a){
        if(a > 1){
            return a + getSum(a-1);
        }
        else{
            return a; // f(1)
        }
    }

    // Main Method
    public static void main(String[] args){
        System.out.print(getSum(11));
    }
}