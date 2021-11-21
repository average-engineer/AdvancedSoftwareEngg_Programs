// Exercise 2 Task 1

public class Task1{

    // Method for Part 3
    public static float Part3(float value){
        return value%(value*value);
        // if value = 6 -> 6%(36) -> expected amswer 6 (division remainder)
    }

    // Method for Part 5
    // Starmarked because I didn't get it at first
    public static float Part5(int first, int second){
        return first/second;
        // First -> 5, Second -> 2
        // Exact Value -> 2.5 (which is of float type)
        // Since we are dividing 2 integer variables, the division will round up to the nearest lower integer
        // Expected Output -> 2
    }

    public static void main(String[] args){
        // Part 1
        System.out.println("Part1:");
        if(false){ // The code will never enter this if condition due to false condition
            System.out.println("I am in IF");
        }
        else if(true){ // The code will always enter this if condition due to true condition
            System.out.println("I am in ELSE-IF");
        }
        else{ // The code will never enter this if condition due to false condition
            System.out.println("I am in ELSE");
        }
        // The output of the code will always be: I am in ELSE-IF

        // Part 2
        System.out.println("Part2:");
        // Creating an integer array of 3 rows and 4 columns
        int[][] array1 = new int[3][4];

        // VV IMPORTANT (you matlab freak :/): Indexing starts from 0

        array1[2][3] = 10; // Populating the element of the array corresponding to the 3rd row and 4th column
        // Accessing the 3rd row and 4th columnm element
        int hiThere = array1[2][3];
        System.out.println(hiThere);


        // Part 3
        System.out.println("Part3:");
        float val = 6;
        float part3ans = Part3(val);
        if(part3ans == val){
            System.out.println("BINGO, ES IST RICHTIG!");

        }

        else{
            System.out.println("NEIN, ES IST RICHTIG NICHT!");
        }   

        // Part 4
        System.out.println("Part4:");
        int i = 1;
        while(i > 0){
            i++; // Post Increment -> i is increased by one first thing in the loop
            System.out.println("This is iteration: " + i);
            System.out.println("Expected Output -> This is iteration: 2");
            break; // Terminates the while loop after the print
        }

        // Part 5
        System.out.println("Part5:");
        int a = 5;
        int b = 2;
        double ans = 2;
        float myAns = (float)ans;
        float p5ans = Part5(a,b);
        if(p5ans == myAns){
            System.out.println("BINGO, ES IST RICHTIG!");

        }

        else{
            System.out.println("NEIN, ES IST RICHTIG NICHT!");
        }

        // Part 6
        System.out.println("Part6:");
        //Example of explicit typecast
        double p6Var = 2.3; // A double variable
        // Since implicit typecasts is possible from integer variable to double variable nut not vice versa, if we want to typecast it into integer, we will havwe to explicitly do it
        int p6VarInt = (int)p6Var;
        System.out.println("The output will be 2 instead of 2.3. Check the line below to see if my guess is correct");
        System.out.println("The output is:" +p6VarInt);
        
    }


}