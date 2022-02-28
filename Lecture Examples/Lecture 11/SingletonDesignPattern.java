public class SingletonDesignPattern {
    public static void main(String[] args){
        // Creating a new ball of green color
        Ball ball1 = Ball.getInstance("Green");
        // Creating a new ball of blue color
        Ball ball2 = Ball.getInstance("Blue");
        // Creating a second ball of green color
        Ball ball3 = Ball.getInstance("Green");
        // Creating a third ball of green color
        Ball ball4 = Ball.getInstance("Green");

        // Comparing the created ball objects
        if(ball1 == ball2){ // They will not be the same objects
            System.out.println("Ball 1 and Ball 2 are the same objects");
        }

        else{
            System.out.println("Ball 1 and Ball 2 are not the same objects");
        }

        if(ball1 == ball3){ // They will be the same objects
            System.out.println("Ball 1 and Ball 3 are the same objects");
        }

        else{
            System.out.println("Ball 1 and Ball 3 are not the same objects");
        }

        if(ball3 == ball4){ // They will be the same objects
            System.out.println("Ball 3 and Ball 4 are the same objects");
        }

        else{
            System.out.println("Ball 3 and Ball 4 are not the same objects");
        }


    }
}
