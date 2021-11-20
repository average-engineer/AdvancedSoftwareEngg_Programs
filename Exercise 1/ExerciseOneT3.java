// Exercise 1 Task 3
public class ExerciseOneT3{
    
    public static void main(String[] args){

        int[] values = {13,9,22,49,5,-27,-8};
        double count = 0.0; // Summation variable
        for(int i = 0;i<values.length;i++){

            count = count + values[i];
            double avg = count/(i+1); // Computing the average

            // Printing the cumulative sum for each iteration
            System.out.println("The sum of array until number " + values[i] + " is "+count);
            // Printing the average for each iteration
            System.out.println("The average of array until number " + values[i] + " is "+avg);

        }

    }

}