package $JavaFiles;

public class Dog {

    // 1. Instance Field
    String name;

    // 2. Constructor
    public Dog(String dogName) {
        this.name = dogName; 
        System.out.println(this.name + " the dog has been created!");
    }

    public void bark(String sound) {
        System.out.println(this.name + " barks: " + sound);
    }

    public static void main(String[] args) {

        Dog myDog = new Dog("Buddy");
        myDog.bark("Woof!");

        // Create another Dog object
        Dog neighborDog = new Dog("Lucy");
        neighborDog.bark("Yap yap!");

        System.out.println("\n--- Handling command line arguments (args) ---");

        if (args.length > 0) {
            System.out.println("You passed " + args.length + " command line argument(s):");
            for (int i = 0; i < args.length; i++) {
                System.out.println("Argument " + (i + 1) + ": " + args[i]);
            }
            
            Dog commandLineDog = new Dog(args[0]);
            commandLineDog.bark("Arf!");

        } else {
            System.out.println("No command line arguments were provided.");
            System.out.println("Try running: java Dog MyNewDogName AnotherArg");
        }
    }
}