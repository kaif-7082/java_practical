
public class carrental {
    public static void main(String[] args) {
        Car c1 = new Car("Tesla", "Model 3", 2023);
        Car c2 = new Car("Toyota", "Innova");

        c1.displayDetails();
        c2.displayDetails();

        Rental r1 = new Rental(c1, 5);
        Rental r2 = new Rental(c2, 2);

        r1.displayBill();
        r2.displayBill();

        
        System.out.println("Total Rentals Made: " + Rental.totalRentals);
    }
}


class Vehicle {
    String type;

    Vehicle() {
        type = "Four Wheeler";
    }

    void showType() {
        System.out.println("Vehicle Type: " + type);
    }
}


class Car extends Vehicle {
    final String brand;   
    String model;
    int year;

    Car() {
        super(); 
        this.brand = "Unknown";
        this.model = "Unknown";
        this.year = 0;
    }

    
    Car(String brand, String model, int year) {
        super();  
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Overloaded constructor using this()
    Car(String brand, String model) {
        this(brand, model, 2020);
    }

    void displayDetails() {
        super.showType();  // calling parent class method using super
        System.out.println("Car: " + brand + " " + model + " (" + year + ")");
        System.out.println("------------------------");
    }
}


class Rental {
    final double PRICE_PER_DAY = 1000.0; 
    static int totalRentals = 0;        
    Car car;
    int days;

    
    Rental(Car car, int days) {
        this.car = car;
        this.days = days;
        totalRentals++; 
    }

    void displayBill() {
        double total = days * PRICE_PER_DAY;

       
        if (days > 3) {
            System.out.println("You got a discount for renting more than 3 days!");
            total = total * 0.9;
        } else {
            System.out.println("No discount applied.");
        }

        System.out.println("Rented " + car.model + " for " + days + " days. Total = ₹" + total);
        System.out.println("------------------------");
    }
}

