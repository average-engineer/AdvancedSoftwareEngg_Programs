public class Duck{

    // Instance Variables
    protected QuackBehaviour quackBehaviour; // quackBehaviour will be anyone of the classes which implement the interface QuackBehaviour

    // Methods
    public void swim(){
        System.out.println("Splish Splash");
    }

    public void display(){
        System.out.println("Display");
    }

    public void setQuackBehaviour(QuackBehaviour quackBehaviour){
        this.quackBehaviour = quackBehaviour; // Method to set a particular class (using QuackBheaviour Implementation) as the quack behaviour
    }

    public void performQuack(){
        quackBehaviour.quack();
    }

}