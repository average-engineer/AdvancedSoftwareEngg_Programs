// Class for application

public class application {

    public static void main(String[] args){
        System.out.println(new instanceCounter());
        System.out.println(new instanceCounter());
        System.out.println(instanceCounter.count); // The count variable of the instanceCounter class accessed without creating a new object from the instanceCounter class
        // if counter was not a static variable, then we would have to do :
        // instanceCounter inst = new instanceCounter()
        // System.out.println(inst.count);
    }
    
}
