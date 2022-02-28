import org.junit.*;
import static org.junit.Assert.*;

import shapes.Point; // Importing the Point object

public class TestPoint {
    // Test class to test the methods of Point object/class

    private Point point;
    public TestPoint(int x, int y){
        this.point = new Point(x,y);
    }

    // Test Methods for distance method
    @Test // Checking the distance between points on the same coordinate
    public void testDistance(){
        assertEquals("Test Failed: Same coordinates don't have zero distance",0.0,point.distance(new Point(1,2)),0.0001);
        assertEquals("Test Failed: Same X coordinates distance isn't equal to difference in Y coordinates",point.getY(),point.distance(new Point(1,0)),0.0001);
        assertEquals("Test Failed: Same Y coordinates distance isn't equal to difference in X coordinates",point.getX(),point.distance(new Point(0,2)),0.0001);
        assertEquals("Test Failed: Expected Distance not obtained",Math.sqrt(5),point.distance(new Point(0,0)),0.0001);
    }

    @Test
    public void testToString(){
        assertEquals("Test Failed: Expected String not obtained","The coordinates of the Point are:(1, 2)",point.toString());
    }



}
