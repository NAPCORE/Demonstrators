import java.util.List;

public class OrConstraint {
    private List<TimeWindowConstraint> or;
    private String type;

    // Default constructor
    public OrConstraint() {}

    // Parameterized constructor
    public OrConstraint(List<TimeWindowConstraint> or, String type) {
        this.or = or;
        this.type = type;
    }

    // Getters and setters
    public List<TimeWindowConstraint> getOr() {
        return or;
    }

    public void setOr(List<TimeWindowConstraint> or) {
        this.or = or;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
