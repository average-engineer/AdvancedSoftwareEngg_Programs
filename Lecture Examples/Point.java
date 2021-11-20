// Class for a Point Object
public class Point{
    public int x; // X coordinate as an instance variable
    public int y; // Y coordinate as an instance variable

    // Method of the Point Object: Translating the Point in 2D space
    public void move2D(int delX, int delY){
        x = x + delX; // X coordinate translated by delX
        y = y + delY; // Y coordinate translated by delY
    }
}