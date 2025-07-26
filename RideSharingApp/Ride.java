package RideSharingApp;

public class Ride {
    RideType rideType;
    double distance; // in kilometers
    FareStrategy fareStrategy;
    Passenger passenger;
    Driver driver;
    RideStatus rideStatus;

    public Ride(RideType rideType, double distance, Passenger passenger, Driver driver, FareStrategy fareStrategy, RideStatus rideStatus) {
        this.rideType = rideType;
        this.distance = distance;
        this.fareStrategy = fareStrategy;
        this.passenger = passenger;
        this.driver = driver;
        this.rideStatus = rideStatus;
    }

    public RideType getRideType() {
        return rideType;
    }

    public double getDistance() {
        return distance;
    }

    public FareStrategy getFareStrategy() {
        return fareStrategy;
    }
    public Passenger getPassenger() {
        return passenger;
    }

    public Driver getDriver() {
        return driver;
    }  

    public void setRideType(RideType rideType){
        this.rideType = rideType;
    }

    public double calculateFare() {
        return fareStrategy.calculateFare(driver.getVehicle(), rideType, distance);
    }
    public void updateRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
        passenger.notify("Passenger : this ride has been updated to " + rideStatus);
        driver.notify("Driver : this ride has been updated to " + rideStatus);
    }
}
