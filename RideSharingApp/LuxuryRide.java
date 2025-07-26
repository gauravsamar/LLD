package RideSharingApp;

public class LuxuryRide implements FareStrategy {
    @Override
    public double calculateFare(Vehicle vehicle, RideType rideType, double distance) {
        return 1.0;
    }
}
