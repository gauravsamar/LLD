package RideSharingApp;

public class Driver extends User {

    Vehicle vehicle;
    Location location;

    public Location getLocation() {
        return this.location;
    }
    public Vehicle getVehicle() {
        return this.vehicle;
    }
    @Override
    void notify(String message) {
        System.out.println("Driver " + getName() + " received notification: " + message);
    }

    public Driver(String name, String email, Location location,Vehicle vehicle) {
        super(name, email);
        this.vehicle = vehicle;
        this.location = location;
    }
}