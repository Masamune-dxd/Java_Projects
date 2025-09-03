package GCashApp;

class User {
    int id;
    String name;
    String email;
    String number;
    String pin;

    User(int id, String name, String email, String number, String pin) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.number = number;
        this.pin = pin;
    }

    int getId() {return id;}
    String getName() {return name;}
    String getEmail() {return email;}
    String getNumber() {return number;}
    String getPin() {return pin;}

    void setPin(String pin) {
        this.pin = pin;
    }
}