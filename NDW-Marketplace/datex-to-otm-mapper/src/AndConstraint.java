import java.util.List;

public class AndConstraint {
    private List<Object> and;
    private String type;

    // Default constructor
    public AndConstraint() {}

    // Parameterized constructor
    public AndConstraint(List<Object> and, String type) {
        this.and = and;
        this.type = type;
    }

    // Getters and setters
    public List<Object> getAnd() {
        return and;
    }

    public void setAnd(List<Object> and) {
        this.and = and;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
