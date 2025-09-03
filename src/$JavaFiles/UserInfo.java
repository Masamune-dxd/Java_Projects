package $JavaFiles;
import java.util.*;

public class UserInfo {
    public static void main(String[] args) {
        // Declare and initialize variables
        String name = "Alice Wonderland";
        int age = 30;
        double height = 1.65; // in meters
        boolean isStudent = false;

        // Display the information
        System.out.println("User Name: " + name);
        System.out.println("User Age: " + age + " years old");
        System.out.println("User Height: " + height + " meters");
        System.out.println("Is Student: " + isStudent);
    }
}

class CircleArea {
    public static void main(String[] args) {
        // Using float for radius and area
        float radiusFloat = 5.0f;
        float areaFloat = (float) (Math.PI * radiusFloat * radiusFloat);
        System.out.println("Area (float): " + areaFloat);

        // Using double for radius and area (more precision)
        double radiusDouble = 5.0;
        double areaDouble = Math.PI * radiusDouble * radiusDouble;
        System.out.println("Area (double): " + areaDouble);

        // Character example
        char initial = 'J';
        System.out.println("Initial: " + initial);

        // Boolean example
        boolean isValid = true;
        System.out.println("Is Valid: " + isValid);
    }
}

class LoopExamples {
    public static void main(String[] args) {
        // For loop: Calculate sum of numbers from 1 to 5
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            sum += i;
            System.out.println(i);
        }

        System.out.println("Sum using for loop: " + sum); // Output: 15

        // While loop: Countdown from 5 to 1
        int count = 5;
        while (count > 0) {
            System.out.println("Countdown: " + count);
            count--;
        }

        // Do-while loop: Prompt for input until a valid number is entered
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int inputNumber;
        do {
            System.out.print("Enter a number greater than 10: ");
            inputNumber = scanner.nextInt();
        } while (inputNumber <= 10);
        System.out.println("You entered: " + inputNumber);

        // Enhanced for loop (for-each): Iterate over an array
        String[] fruits = {"Apple", "Banana", "Cherry"};
        System.out.println("Fruits:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        scanner.close();
    }
}

class ConditionalExamples {
    public static void main(String[] args) {
        // If-else if-else: Grade Calculator
        int score = 85;
        if (score >= 90) {
            System.out.println("Grade: A");
        } else if (score >= 80) {
            System.out.println("Grade: B");
        } else if (score >= 70) {
            System.out.println("Grade: C");
        } else {
            System.out.println("Grade: F");
        }

        // Switch: Day of the Week
        int day = 3; // 1 for Monday, 7 for Sunday
        String dayName;
        switch (day) {
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            case 4:
                dayName = "Thursday";
                break;
            case 5:
                dayName = "Friday";
                break;
            case 6:
                dayName = "Saturday";
                break;
            case 7:
                dayName = "Sunday";
                break;
            default:
                dayName = "Invalid day";
                break;
        }
        System.out.println("Today is: " + dayName);
    }
}

class Calculator {

    // Method to add two numbers
    public int add(int a, int b) {
        return a + b;
    }

    // Method to subtract two numbers
    public int subtract(int a, int b) {
        return a - b;
    }

    // Method to display a greeting (void return type)
    public void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public static void main(String[] args) {
        Calculator myCalc = new Calculator(); // Create an object of Calculator

        int sum = myCalc.add(10, 5);
        System.out.println("Sum: " + sum); // Output: 15

        int difference = myCalc.subtract(20, 8);
        System.out.println("Difference: " + difference); // Output: 12

        myCalc.greet("Java Programmer"); // Output: Hello, Java Programmer!
    }
}

// Encapsulation: Attributes are private, accessed via public methods
class Car {
    private String make;
    private String model;
    private int year;

    // Constructor
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Getter methods
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    // Behavior
    public void start() {
        System.out.println(make + " " + model + " is starting...");
    }

    public void stop() {
        System.out.println(make + " " + model + " is stopping.");
    }

    // Polymorphism example (can be overridden by subclasses)
    public void accelerate() {
        System.out.println(make + " " + model + " is accelerating.");
    }
}

// ElectricCar.java (Must be defined for the Dealership class to use it)
// Inheritance: ElectricCar inherits from Car
class ElectricCar extends Car {
    private int batteryCapacityKWh;

    public ElectricCar(String make, String model, int year, int batteryCapacityKWh) {
        super(make, model, year); // Call parent class constructor
        this.batteryCapacityKWh = batteryCapacityKWh;
    }

    public int getBatteryCapacityKWh() {
        return batteryCapacityKWh;
    }

    // Polymorphism: Overriding the accelerate method
    @Override // Good practice to use @Override annotation
    public void accelerate() {
        System.out.println(getMake() + " " + getModel() + " is silently accelerating with electric power!");
    }

    public void charge() {
        System.out.println(getMake() + " " + getModel() + " is charging.");
    }
}

// Dealership.java (This will be the main entry point for the application)
class Dealership { 
    public static void main(String[] args) {
        // --- Calculator Class Usage ---
        System.out.println("--- Calculator Operations ---");
        Calculator myCalc = new Calculator(); // Create an object of Calculator

        int sum = myCalc.add(10, 5);
        System.out.println("Sum: " + sum); // Output: 15

        int difference = myCalc.subtract(20, 8);
        System.out.println("Difference: " + difference); // Output: 12

        myCalc.greet("Java Programmer"); // Output: Hello, Java Programmer!

        System.out.println("\n----------------------------------------");


        // --- Car & ElectricCar Class Usage (OOP Examples) ---
        // Creating Car objects (Encapsulation)
        Car sedan = new Car("Honda", "Civic", 2023);
        Car suv = new Car("Toyota", "RAV4", 2024);

        System.out.println("\n--- Traditional Cars ---");
        System.out.println("Sedan: " + sedan.getMake() + " " + sedan.getModel() + " (" + sedan.getYear() + ")");
        sedan.start();
        sedan.accelerate();
        sedan.stop();

        System.out.println("\n--- Electric Cars ---");
        // Creating ElectricCar object (Inheritance)
        ElectricCar tesla = new ElectricCar("Tesla", "Model 3", 2025, 75);
        System.out.println("Electric Car: " + tesla.getMake() + " " + tesla.getModel() + " (" + tesla.getYear() + ")");
        System.out.println("Battery Capacity: " + tesla.getBatteryCapacityKWh() + " kWh");
        tesla.start();
        tesla.accelerate(); // Polymorphism: Calls the overridden accelerate method
        tesla.charge();
        tesla.stop();

        System.out.println("\n--- Polymorphism in Action ---");
        // An array of Car objects, but can hold ElectricCar objects due to inheritance
        Car[] cars = new Car[2];
        cars[0] = sedan;
        cars[1] = tesla; // ElectricCar is a type of Car

        for (Car car : cars) {
            car.accelerate(); // Calls the appropriate accelerate method based on actual object type
        }
    }
}

class ArrayListExample {
    public static void main(String[] args) {
        // Create an ArrayList to store user names
        List<String> userNames = new ArrayList<>();

        // Add some names to the list
        userNames.add("Alice");
        userNames.add("Bob");
        userNames.add("Charlie");

        // Display the names
        System.out.println("User Names:");
        for (String name : userNames) {
            System.out.println(name);
        }

        // Remove a name
        userNames.remove("Bob");
        System.out.println("\nAfter removing Bob:");
        for (String name : userNames) {
            System.out.println(name);
        }
    }
}

class quickMaths {
    public int addition(int a, int b) {
        return a + b;
    }
    public int minus(int a, int b) {
        return a - b;
    }
    public int times(int a, int b) {
        return a * b;
    }
    public int divide(int a, int b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        return a / b;
    }
    public void results() {
        System.out.println("Results are calculated.");
    }

    public static void main(String[] args) {
        quickMaths math = new quickMaths();
        int sum = math.addition(5, 10);
        int diff = math.minus(20, 8);
        int product = math.times(4, 6);
        int quotient = math.divide(100, 4);
        System.out.println("Addition Result: " + sum);
        System.out.println("Difference Result: " + diff);
        System.out.println("Product Result: " + product);
        System.out.println("Quotient Result: " + quotient);

        math.results(); 
    }
}

class Rectangle {
    public double length;
    public double width;
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    public double area() {
        return length * width;
    }
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(5.0, 3.0);
        System.out.println("Area of Rectangle: " + rect.area());
    }
}