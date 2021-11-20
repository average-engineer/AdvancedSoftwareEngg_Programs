public class ShapeApp {
    public static void main(String[] args){
        // A rectangle
        Rectangle rect = new Rectangle();
        // A triangle
        Triangle tria = new Triangle();
            
        // The triangle is blue in color and not filled
        tria.filled = false;
        tria.color = "blue";

        // The Rectangle is red in color and filled
        rect.filled = true;
        rect.color = "red";

        // Area of the rectangle
        rect.l1 = 20;
        rect.l2 = 2;
        double rectArea = rect.AreaRec();

        // Area of the triangle
        tria.x1 = 0;
        tria.y1 = 0;
        tria.x2 = 10;
        tria.y2 = 0;
        tria.x3 = 5;
        tria.y3 = 5;
        double triaArea = tria.TriangleArea();

        System.out.println(tria.x1 + tria.x2 + tria.x3);
        System.out.println(tria.y1 + tria.y2 + tria.y3);
        System.out.print("The area of the rectangle is " +rectArea  + " and the area of the triangle is " +triaArea);
    }
}
