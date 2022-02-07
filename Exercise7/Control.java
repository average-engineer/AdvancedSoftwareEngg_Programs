// Class for Control Object

public class Control {

    // Input component -> Instance of ComponentMachine Object
    // private ComponentMachine component;

    // Setting the component of the class
    /*public void setComponent(ComponentMachine component){
        this.component = component;
    }*/

    // Main Method
    // The main method is coded according to the given activity diagram

    public static void main(String[] args){

        // Input component -> Instance of ComponentMachine Object
        ComponentMachine component = new ComponentMachine();

        // Input Component
        component.input();

        // Measuring component
        // measure() method of component returns a boolean value
        // The do while loop ensures the loop is run atleast once (since the condition is checked after the do loop has run)
        // It may be possible a component doesn't need to be edited at all

        /*// Measuring the component the first time
        if(!component.measure()){ // if the component is not ok
            
            // Now the loop needs to be run
            do{
                component.edit(); // editing the component
                // component.measure(); // measuring the component again
            }
            while(!component.measure());

        }*/

        // A much better and shorter alternative;
        while(!component.measure()){
            component.edit();
        } // this loop is not run in the first place if the component doesn#t need any modifications


        // Otherwise if the component is ok (or becomes ok)
        // The component needs to be rotated atleast once
        // Now the do while loop can be used directly
        do{
            component.rotate();
        }
        while(component.getRotationAngle() < 180); // Rotation is continued as long as the rotation angle < 180
        // The loop ends when component.getRotationAngle() >= 180

        // Classifying the component for the first time
        while(component.classifySurface() != 1){

            // If surface classified as Class 2
            if(component.classifySurface() == 2){
                component.sand();
            }

            // If surface classified as Class 3
            else if(component.classifySurface() == 3){
                component.polish();
            }
        }

        // The loop ends only when component.classifySurface() == 1
        // Ejecting the component
        component.eject();


    }
    
}
