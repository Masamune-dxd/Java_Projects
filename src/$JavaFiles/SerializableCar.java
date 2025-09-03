package $JavaFiles;

import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

class Engine implements Serializable {
    private double liters;
    private int cylinders;

    public Engine(double liters, int cylinders) {
        this.liters = liters;
        this.cylinders = cylinders;
    }

    public double getLiters() {
        return liters;
    }

    public int getCylinders() {
        return cylinders;
    }

    @Override
    public String toString() {
        return String.format("Engine: %.1fL, %d cylinders", liters, cylinders);
    }
}

public class SerializableCar implements Serializable {
    private String make;
    private int year;
    private static final long serialVersionUID = 1L;
    private transient Engine engine;

    public SerializableCar(String make, int year) {
        this.make = make;
        this.year = year;
        this.engine = new Engine(2.4, 6);
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeDouble(this.engine.getLiters());
        stream.writeInt(this.engine.getCylinders());
    }
    
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        double liters = stream.readDouble();
        int cylinders = stream.readInt();
        this.engine = new Engine(liters, cylinders);
    }   

    @Override
    public String toString(){
        return String.format("Car make is: %s, Car year is: %d, %s", this.make, this.year, this.engine);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializableCar toyota = new SerializableCar("Toyota", 2021);
        SerializableCar honda = new SerializableCar("Honda", 2020);
        
        try (FileOutputStream fileOutputStream = new FileOutputStream("cars.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(toyota);
            objectOutputStream.writeObject(honda);
        }

        try (FileInputStream fileInputStream = new FileInputStream("cars.txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            SerializableCar toyotaCopy = (SerializableCar) objectInputStream.readObject();
            SerializableCar hondaCopy = (SerializableCar) objectInputStream.readObject();

            boolean isSameObjectToyota = toyotaCopy == toyota;
            System.out.println("Toyota (Original) - " + toyota);
            System.out.println("Toyota (Copy) - " + toyotaCopy);
            System.out.println("Is Toyota copy same object as original? " + isSameObjectToyota);

            System.out.println("\nHonda (Original) - " + honda);
            System.out.println("Honda (Copy) - " + hondaCopy);
        }
    }
}