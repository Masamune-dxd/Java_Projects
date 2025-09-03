package $JavaFiles;

class Cupcake {
  String flavor;
  boolean sprinkles;
  
  public Cupcake(String type, boolean hasSprinkles) {
    flavor = type;
    sprinkles = hasSprinkles;
  }
}

class Bakery {
  Cupcake bakeryCupcake;
  double price;
  String giveTotal;

  public Bakery(Cupcake cupcakeType, double priceOf) {
    bakeryCupcake = cupcakeType;
    price = priceOf;

    // Uncomment line below
    // bakeryCupcake.flavor = "vanilla";
    giveTotal = "The " + bakeryCupcake.flavor + " cupcake is €" + price;
    
  }
  
  public static void main(String[] args) {
    Cupcake chocolateSprinkle = new Cupcake("chocolate", true);

    // Create an object that takes in an object as a parameter
    Bakery myBakery = new Bakery(chocolateSprinkle, 3.25);
    
    // Output a value of parameter object
    System.out.println("Our object sent as a parameter has a flavor value of "  + myBakery.bakeryCupcake.flavor);

    // Output a value of original object
    System.out.println("Our original object has a flavor value of " + chocolateSprinkle.flavor);
  }
}