// Code to test communication and relations between objects

public class ObjectCommunication{

    // Main Method
    public static void main(String[] args){
        // New Point 2D object
        Point2D p1 = new Point2D(10,10); // Point 2D object will have corrdinates (10,10)
        
        // Printing coordinates of p1 object
        System.out.println("The X coordinate of p1 is: "+ p1.getX());
        System.out.println("The Y coordinate of p1 is: "+ p1.getY());

        // Moving the Point coordinates by (1,1)
        p1.move(1,1);

        // Printing new coordinates of p1 object
        System.out.println("The X coordinate of p1 is: "+ p1.getX());
        System.out.println("The Y coordinate of p1 is: "+ p1.getY());

        // Defining two points
        Point2D firstPoint = new Point2D(5,10);
        Point2D secondPoint = new Point2D(12,15);

        // Defining a new Rect2D object using the above defined 2 points
        // Rect2D rect = new Rect2D(firstPoint, secondPoint);

        // Detetcing the illegal state exception in an illegallly defined rectangle object
        try{
            Rect2D rect1 = new Rect2D(secondPoint, firstPoint); // illegal state exception expected
            System.out.println("Area of the new rectangle is: " + rect1.calcRectArea());
        } catch(IllegalStateException e1){ // Detecting any invalid state types or values
            System.err.println("The new rectangle can not be initialized. Reason: " + e1.getMessage()); // Printing the exception error
        } catch(IllegalArgumentException e2){ // Detecting any undefined or invalid input arguments
            System.err.println("The new rectangle can not be initialized. Reason: " + e2.getMessage()); // Printing the exception error

        }

        // Computing the area of the rectangle
        // System.out.println("The area of the intitial rectangle is: "+ rect.calcRectArea());

        // Changing the 2 corner points of the rectangle
        // Shifting the lowerLeft point towards negative X
        // Shifting the upperRight point towards positive X
        // firstPoint.move(-3,0);
 
        // secondPoint.move(3,0);
        

        // rect.setlowerLeft(firstPoint); // The new shifted first point is the new lower left point
        // rect.setupperRight(secondPoint); // The new shifted second point is the new upper right point

        // Computing the area of the rectangle
        // System.out.println("The area of the new rectangle is: "+ rect.calcRectArea());


        // Defining a new Sq2D object and trying to catch any exception errors thrown by the program
        try{
            Sq2D sq = new Sq2D(firstPoint,secondPoint);
            System.out.println("The area of the sqaure is: " +sq.calcRectArea());

        } catch(IllegalStateException e3){// Detecting any invalid state types or values
            System.err.println("The new sqaure can not be initialised. Reason: " + e3.getMessage());
        } catch(IllegalArgumentException e4){ // Detecting any undefined or invalid input arguments
            System.err.println("The new square can not be initialized. Reason: " + e4.getMessage()); // Printing the exception error

        }

    }

}
