import org.junit.*;
import static org.junit.Assert.*;

import rwth_aachen.ima.ase.lecture10.task4.Line;

public class LineTest {

    private Line line;

    // Test Class Constructor
    public LineTest(double x0,double y0,double x1,double y1){
        line = new Line(x0,y0,x1,y1);
    }

    // Test Methods for getSlope()
    @Test
    public void zeroSlopeTest(){
        assertEquals("Test Failed",0,line.getSlope(),0.0001); // 0.0001 added since we are comparing double datatypes 
    }

    @Test
    public void negativeSlopeTest(){
        boolean test1 = line.getSlope() < 0; // test is True if slope of line is negative
        assertTrue("Test Failed",test1); // Fails is test is False, i.e. slope of line is positive
    }

    @Test
    public void positiveSlopeTest(){
        boolean test2 = line.getSlope() > 0; // test is True if slope of line is positive
        assertTrue("Test Failed",test2); // Fails is test is False, i.e. slope of line is negative
    }

    @Test
    public void largerThanOneSlopeTest(){
        boolean test3 = line.getSlope() > 1; // test is True if slope of line is larger than 1
        assertTrue("Test Failed",test3); // Fails is test is False, i.e. slope of line is smaller than 1
    }

    @Test
    public void smallerThanOneSlopeTest(){
        boolean test4 = line.getSlope() < 1; // test is True if slope of line is smaller than 1
        assertTrue("Test Failed",test4); // Fails is test is False, i.e. slope of line is larger than 1
    }

    // Test Methods for getDistance()
    @Test
    public void zeroDistance(){
        assertEquals("Test Failed", 0, line.getDistance(),0.0001);
    }

    @Test
    public void XCoordDistance(){
        assertEquals("Test Failed", line.getx1() - line.getx0(), line.getDistance(),0.0001); // Distance = Difference in X coordinates
    }

    @Test
    public void YCoordDistance(){
        assertEquals("Test Failed", line.gety1() - line.gety0(), line.getDistance(),0.0001); // Distance = Difference in Y coordinates
    }

    @Test
    public void XYCoordDistance(){
        assertEquals("Test Failed", Math.sqrt(Math.pow(line.getx1() - line.getx0(),2) + Math.pow(line.gety1() - line.gety0(),2)), line.getDistance(),0.0001); // Distance = Difference in X and Y coordinates
    }

    // Test Methods for parallelTo()
    @Test
    public void equalLinesParallel(){
        boolean test5 = line.parallelTo(new Line(line.getx0(),line.gety0(),line.getx1(),line.gety1())); // Equal Lines, should be parallel
        assertTrue("Test Failed",test5);
    }

    @Test
    public void yMovementLinesParallel(){
        boolean test6 = line.parallelTo(new Line(line.getx0(),line.gety0() + 5,line.getx1(),line.gety1() + 5)); // Parrallel Lines
        assertTrue("Test Failed",test6);
    }

    @Test
    public void xyMovementLinesParallel(){
        boolean test7 = line.parallelTo(new Line(line.getx0() + 2,line.gety0() + 5,line.getx1() + 2,line.gety1() + 5)); // Parrallel Lines
        assertTrue("Test Failed",test7);
    }

    @Test
    public void skewLines(){
        boolean test8 = line.parallelTo(new Line(4,4,5,2)); // Non Parrallel Lines
        assertFalse("Test Failed",test8); // Fails if test8 is True. i.e. lines are parallel
    }

}
