package RideSharingApp;

abstract public class Vehicle {
    String licensePlate;
    int capacity;
    public Vehicle(String licensePlate, int capacity) {
        this.licensePlate = licensePlate;
        this.capacity = capacity;
    }
    public String getLicensePlate() {
        return licensePlate;
    }
    public int getCapacity() {
        return capacity;
    }
    public abstract double getFarePerKm();
    @Override
    public String toString() {
        return "Vehicle{" +
                "licensePlate='" + licensePlate + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
