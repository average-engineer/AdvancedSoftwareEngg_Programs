import shapes.Point;
import org.junit.*;
import static org.junit.Assert.*;

public class Ex10T1 {

    public static void main(String[] args) {
        Point p1 = new Point(3,4);
        System.out.println(p1); 

        TestPoint testcase = new TestPoint(1,2); 
        testcase.testDistance(); // Test for distance method of Point
        testcase.testToString(); // Test for toString method of Point
    }
    
}
