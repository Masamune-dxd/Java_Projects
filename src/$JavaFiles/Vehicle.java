package $JavaFiles;

import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Vehicle implements Serializable {
  private String make;
  private int year;
  private static final long serialVersionUID = 1L;

  public Vehicle(String make, int year) {
    this.make = make;
    this.year = year;
  }

  public String toString(){
    return String.format("Vehicle make is: %s, Vehicle year is: %d", this.make, this.year);
  }

  public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
    Vehicle toyota = new Vehicle("Toyota", 2021);
    Vehicle honda = new Vehicle("Honda", 2020);
    FileOutputStream fileOutputStream = new FileOutputStream("cars.txt");
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
    objectOutputStream.writeObject(toyota);
    objectOutputStream.writeObject(honda);

    FileInputStream fileInputStream = new FileInputStream("cars.txt");
    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

    Vehicle toyotaCopy = (Vehicle) objectInputStream.readObject();
    Vehicle hondaCopy = (Vehicle) objectInputStream.readObject();

    boolean isSameObject = toyotaCopy == toyota;
    System.out.println("Toyota (Copy) - "+toyotaCopy);
    System.out.println("Toyota (Original) - "+toyota);
    System.out.println("Is same object: "+ isSameObject);
  }
}