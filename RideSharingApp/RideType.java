package RideSharingApp;

public enum RideType {
    STANDARD(1.0),
    PREMIUM(1.5),
    POOL(0.8),;

    private final double multiplier;
    
    RideType(double multiplier) {
        this.multiplier = multiplier;
    }
    double getMultiplier() {
        return this.multiplier;
    }
} 