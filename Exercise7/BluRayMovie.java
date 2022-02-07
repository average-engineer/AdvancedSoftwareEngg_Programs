// Class for BlurayMovie Object

public class BluRayMovie extends VideoStoreItem{

    // Instance Variables
    private boolean readable;
    private int regionCode;

    // Methods
    public boolean isReadable(){
        return readable;
    }

    public void setReadable(boolean readable){
        this.readable = readable;
    }

    public int getRegionCode(){
        return regionCode;
    }

    public void setRegionCode(int regionCode){
        this.regionCode = regionCode;
    }
    
}
