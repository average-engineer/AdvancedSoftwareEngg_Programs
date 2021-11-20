public class PointApp {
    public static void main(String[] args){
        Point p1 = new Point(); // p1 is a Point Object 
        Point p2 = new Point();// p2 is a Point Object

        // Point Object Information -> X and Y coordinates
        // What each Point Object can do -> Translate the coordinates in 2D space

        // Setting the initial coordinates of the 2 points
        p1.x = 20;
        p1.y = -40;
        p2.x = 10;
        p2.y = 20;

        // Translating the points in 2D space
        p1.move2D(10,-10); // Moving the p1 point
        p2.move2D(0,50); // Moving the p2 point

        // Now the state/instance variables (x and y coordinates) of the point objects have updated

        System.out.println("The new X coordinate of Point 1 is: " + p1.x);
        System.out.print("The new Y coordinate of Point 2 is: " + p2.y);
    }
}
