package RideSharingApp;

abstract public class User {
    String name;
    String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    abstract void notify(String message);
}
