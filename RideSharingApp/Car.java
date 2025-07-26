package RideSharingApp;

public class Car extends Vehicle {
    public Car(String licensePlate) {
        super(licensePlate, 4);
    }
    @Override
    public double getFarePerKm() {
        return 20;
    }
}
