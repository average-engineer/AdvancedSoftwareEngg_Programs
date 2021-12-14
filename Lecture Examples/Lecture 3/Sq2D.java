// Class for a Square 2D object
// The sqaure object is a sublclass of the rectangle object

public class Sq2D extends Rect2D{

    // Since the corner points in the Rectangle object were defined as private, they are not inherited by the Square object
    private Point2D lowerLeft;
    private Point2D upperRight;

    // Since superclass constructors are not inherited by the subclasses, we need to manually invoke the superclass constructors
    public Sq2D(Point2D lowerLeft, Point2D upperRight){

        super(lowerLeft, upperRight); // If this is not done, the program shows an error telling that manual invoking of Rect2D class constructors is necessary

        this.lowerLeft = lowerLeft;
        this.upperRight = upperRight;

        // Since the constructor of the superclass is manually invoked into the subclass, all illegal exception handlers defined for the superclass constructor are also defined for the subclass.

        // Additional illegal state -> If the sides of the sqaure are not equal
        if((this.upperRight.getX() - this.lowerLeft.getX()) != (this.upperRight.getY() - this.lowerLeft.getY())){
            throw new IllegalStateException("Sqaure Sides are not equal"); // Illegal state exception thrown
        }

    }

}
