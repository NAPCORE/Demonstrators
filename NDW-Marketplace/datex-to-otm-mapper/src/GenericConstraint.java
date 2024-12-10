public class GenericConstraint {
    private String description;
    private String type;

    // Default constructor
    public GenericConstraint() {}

    // Parameterized constructor
    public GenericConstraint(String description, String type) {
        this.description = description;
        this.type = type;
    }

    // Getters and setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
