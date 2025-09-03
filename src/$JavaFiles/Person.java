package $JavaFiles;

public class Person {
  // Instance variables for person's attributes
  public int age;
  public int wisdom;
  public int fitness;

  // Constructor to create a new Person object
  public Person(int inputAge) {
    this.age = inputAge;
    this.wisdom = inputAge * 5; // Initializes wisdom based on age
    this.fitness = 100 - inputAge; // Initializes fitness based on age
  }

  // Setter method for age
  public void setAge(int newAge) {
    this.age = newAge;
  }

  // Setter method for wisdom
  public void setWisdom(int newWisdom) {
    this.wisdom = newWisdom;
  }

  // Setter method for fitness
  public void setFitness(int newFitness) {
    this.fitness = newFitness;
  }

  // Method to simulate a birthday
  public void hasBirthday() {
    this.setAge(this.age + 1); // Increments age
    this.setWisdom(this.wisdom + 5); // Increases wisdom
    this.setFitness(this.fitness - 3); // Decreases fitness
  }

  public static void main(String[] args) {
    // Creates a new Person object
    Person emily = new Person(20);
    // Calls the hasBirthday method
    emily.hasBirthday();
    // Prints the updated attributes
    System.out.println("New age is: " + emily.age);
    System.out.println("New wisdom is: " + emily.wisdom);
    System.out.println("New fitness is: " + emily.fitness);
  }
}
