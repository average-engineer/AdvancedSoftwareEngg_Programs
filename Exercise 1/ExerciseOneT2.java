// Exercise 1 Task 2
public class ExerciseOneT2{
    
    public static void main(String[] args){

        for(int i = 1;i<101;i++){

            if(i%5 == 0 && i%10 != 0){ // Numbers which are just multiples of 5 (but not of 10) i.e. numbers which give zero remainder when divided by 5
                continue; // Goes to the next iteration of for loop/skips the current iteration
            }

            else if(i%10 == 0){ // Numbers which are multiples of 10

                System.out.println(""); // Only a new line is printed

            }

            else{
                System.out.print(+i+"  "); 
            }

        }

    }

}