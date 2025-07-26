package RideSharingApp;

public class Passenger extends User
{
    Location location;

    public Passenger(String name, String email, Location location) {
        super(name, email);
        this.location = location;
    }

    public Location getLocation() {
        return this.location;
    }

    @Override
    void notify(String message) {
        System.out.println("Passenger " + super.getName() + " received notification: " + message);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", location=" + location +
                '}';
    }
}
