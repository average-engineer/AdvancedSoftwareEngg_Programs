// Exercise 1, Task 1
public class ExerciseOneT1 {
	
	public static void main(String[] args) { // Main Method
		
		double xx = -2.6;
		double yy = 9.4;
		float x = (float) xx; // Explicit Typecast (Double -> Float)
		float y = (float) yy; // Explicit Typecast (Double -> Float)
		float z;
		z = y - x;
		
		// Printing out the result
		System.out.println("The value of the z variable is:"+z);
		System.out.println("The result of substracting x from y is:" + (y - x)); // Printing the same result without using the variable z
	}

}
