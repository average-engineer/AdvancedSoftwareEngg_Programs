// Class to define a Lego part 
// Subclass of the Part Object class
// Required since a Lego Part has more metadata apart from name and id (color, Image URL)

public class LegoPart extends Part{
    
    private String color;
    private String imageURL;

    // Constructor
    public LegoPart(String id, String name, String color, String imageURL){

        super(id, name); // Manually invoking the class constructor of the super class (Part)

        setColor(color);
        setImageURL(imageURL);

        // ALTERNATIVE
        // this.color = color;
        // this.imageURL = imageURL;

    }

    // Method to set the color of the lego object
    public void setColor(String color){
        this.color = color;
    }

    // Method to set the image URL of the lego object
    public void setImageURL(String imageURL){
        this.imageURL = imageURL;
    }

    // Getter Methods
    public String getColor(){
        return color;
    }

    public String getimageURL(){
        return imageURL;
    }

    // Overriding toString Method
    public String toString(){
        return super.toString() + ", Color: " + getColor(); // super.toString() prints whatever the the toString method of the super class (Part) is printing
    }


}
