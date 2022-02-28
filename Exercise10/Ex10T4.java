import org.junit.*;
import static org.junit.Assert.*;

import rwth_aachen.ima.ase.lecture10.task4.Line;

public class Ex10T4 {

    public static void main(String[] args) {
        LineTest slopeTest1 = new LineTest(1,1,2,1); // zero slope expected
        slopeTest1.zeroSlopeTest();

        LineTest slopeTest2 = new LineTest(0, 2, 1, 1); // Negative Slope Expected
        slopeTest2.negativeSlopeTest();

        LineTest slopeTest3 = new LineTest(0, 2, 1, 3); // Positive Slope Expected
        slopeTest3.positiveSlopeTest();

        LineTest slopeTest4 = new LineTest(0, 2, 1, 5); // Slope > 1 expected
        slopeTest4.largerThanOneSlopeTest();

        LineTest slopeTest5 = new LineTest(0, 2, 6, 3); // Slope < 1 expected
        slopeTest5.smallerThanOneSlopeTest();

        LineTest distTest1 = new LineTest(1,2,1,2); // Zero Distance Expected
        distTest1.zeroDistance();

        LineTest distTest2 = new LineTest(1,2,3,2); // Distance Expected = Difference in X coordinates
        distTest2.XCoordDistance();

        LineTest distTest3 = new LineTest(1,2,1,5); // Distance Expected = Difference in Y coordinates
        distTest3.YCoordDistance();

        LineTest distTest4 = new LineTest(1,2,1,5); // Distance Expected = Difference in Y coordinates and X Coordinates
        distTest4.XYCoordDistance();

        LineTest parallelTest1 = new LineTest(0,0,2,3);
        parallelTest1.equalLinesParallel();
        parallelTest1.yMovementLinesParallel();
        parallelTest1.xyMovementLinesParallel();
        parallelTest1.skewLines();

    }
    
}
