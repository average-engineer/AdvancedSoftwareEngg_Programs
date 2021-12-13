// Class for a 2D rectangle object

public class Rect2D{

    // The 2D rectangle is defined by 2 points: Upper Right Point and Lower Left Point
    private Point2D lowerLeft; // Private variable lowerLeft == null at this point
    private Point2D upperRight; // Private variable upperRight == null at this point

    // Constructor of class
    // Calling a new Rect2D object -> Rect2D(Lower Left Point, Upper Right Point)
    public Rect2D(Point2D lowerLeft, Point2D upperRight){ // lowerLeft and upperRight here are local instances of the class

        this.lowerLeft = lowerLeft;
        this.upperRight = upperRight;

        // Throwing an exception error if the lower left and upper right points are positioned illegally (for eg, the lower left point is actually to the right side of the upper right point)
        if(this.lowerLeft.getX() > this.upperRight.getX() && this.lowerLeft.getY() > this.upperRight.getY()){

            throw new IllegalStateException("Upper Right and Lower left points are defined illegally"); // Illegal state exception thrown

        }

        // Introducing an Illegal Argument exception
        if(lowerLeft == null || upperRight == null || lowerLeft.getX() < 0 || lowerLeft.getY() < 0|| upperRight.getX() < 0 || upperRight.getY() < 0){ // If any of the two input arguments are not defined/initialised properly
            throw new IllegalArgumentException("Invalid Input Arguments");

        }
    }

    public void setlowerLeft(Point2D lowerLeft){

        // Ensuring Correctness -> the new lower left point X < the upper right point X
                            //  -> the new lower left point Y < the upper right point Y
        // Ensuring upperRight Point2D object is defined and is not null
        if(upperRight != null && lowerLeft.getX() < upperRight.getX() && lowerLeft.getY() < upperRight.getY()){ // for this method, upperRight is the private class field, lowerLeft is the local variable and 
                                                                                                                // this.lowerLeft is the private class field
            this.lowerLeft = lowerLeft; // value of the private class field is changed
        }
    }

    public void setupperRight(Point2D upperRight){

        // Ensuring Correctness -> the new lower left point X < the upper right point X
                            //  -> the new lower left point Y < the upper right point Y
        // Ensuring lowerLeft Point2D object is defined and is not null
        if(lowerLeft != null && lowerLeft.getX() < upperRight.getX() && lowerLeft.getY() < upperRight.getY()){ // for this method, lowerLeft is the private class field, upperRight is the local variable and 
                                                                                                                // this.upperRight is the private class field
            this.upperRight = upperRight; // value of the private class field is changed
        }

    }

    // Method for computing area of the rectangle
    public double calcRectArea(){

        return (upperRight.getX() - lowerLeft.getX())*(upperRight.getY() - lowerLeft.getY());
    }


}



