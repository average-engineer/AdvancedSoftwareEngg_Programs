import java.util.HashMap;
import java.util.Map;

public class Ball {
    // Static variable to keep track of if the Ball object has been created once
    private static Map<String, Ball> ballMap = new HashMap<String, Ball>();
    private String color;

    // Class Constructor
    private Ball(String color){
        this.color = color;
    }

    // Static Method to instanciate the Ball Object of a particular color
    // Static method since the class can#t be called from outside since the constructor is private
    public static Ball getInstance(String color){
        if(!ballMap.containsKey(color)){ // If the Ball corresponding to the particular color is not contained
            ballMap.put(color,new Ball(color));
        }

        return ballMap.get(color); // Get the Ball Object corresponding to the particular input color
    }
}