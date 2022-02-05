// Exercise 5 Task 5

public class Ex5T5 {

    // Main Method
    public static void main(String[] args){

        System.out.println(makeBricks(3,1,8));
        System.out.println(makeBricks(3,1,9));
        System.out.println(makeBricks(3,2,10));

    }


    public static boolean makeBricks(int small, int big, int goal){

        // Small Bricks -> 1 inch each
        // Big Bricks -> 5 inch each
        // Desired length of brick row -> goal inches
        if(small + 5*big == goal || small == goal || 5*big == goal){
            return true;
        }

        return false;
      
    }
    
}
