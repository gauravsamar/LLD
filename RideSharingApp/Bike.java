package RideSharingApp;

public class Bike extends Vehicle {
    public Bike(String licensePlate) {
        super(licensePlate, 1); // Bikes typically have a capacity of 1
    }
    
    @Override
    public double getFarePerKm() {
        return 10; // Example fare per km for a bike
    }
}
