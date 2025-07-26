package RideSharingApp;

public interface FareStrategy {
    double calculateFare(Vehicle vehicle, RideType rideType, double distance);
}
