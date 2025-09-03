package $JavaFiles;

public class CulinaryExploration { 
    public static void main(String[] args) {
        // Creates a new Ramen object
        RamenDish veggieRamen = new RamenDish(); 
        System.out.println(veggieRamen.isPalatable()); 
    }
}

class RamenDish extends NoodleBase {
    RamenDish() {
        super(30.0, 0.3, "flat", "wheat flour"); 
    }
}

class NoodleBase { 
    private double lengthInCentimeters; 
    private double widthInCentimeters; 
    private String shape; 
    protected String ingredients; 
    protected String texture = "brittle"; 

    NoodleBase(double lenInCent, double wthInCent, String shp, String ingr) {
        this.lengthInCentimeters = lenInCent; 
        this.widthInCentimeters = wthInCent;
        this.shape = shp; 
        this.ingredients = ingr; 
    }

    // if palatable
    public final boolean isPalatable() { 
        return true; 
    }
    
    public double getLengthInCentimeters() {
        return lengthInCentimeters;
    }

    public double getWidthInCentimeters() {
        return widthInCentimeters;
    }

    public String getShape() {
        return shape;
    }

    public void setTexture(String newTexture) {
        this.texture = newTexture;
    }
}