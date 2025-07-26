package RideSharingApp;

public class StandardRide implements FareStrategy {
    @Override
    public double calculateFare(Vehicle vehicle, RideType rideType, double distance)
    {
        double farePerKm = vehicle.getFarePerKm();
        double baseFare = 50; // Base fare for standard rides
        double totalFare = baseFare + (farePerKm * distance);
        return totalFare*rideType.getMultiplier();
    }
}
