public class RouteConstraint {
    private AndConstraint value;

    // Default constructor
    public RouteConstraint() {}

    // Parameterized constructor
    public RouteConstraint(AndConstraint value) {
        this.value = value;
    }

    // Getters and setters
    public AndConstraint getValue() {
        return value;
    }

    public void setValue(AndConstraint value) {
        this.value = value;
    }
}
