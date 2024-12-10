public class ValueBoundConstraint {
    private String description;
    private String valueType;
    private MaximumConstraint maximum;
    private String type;

    // Default constructor
    public ValueBoundConstraint() {
    }

    // Parameterized constructor
    public ValueBoundConstraint(String description, String valueType, MaximumConstraint maximum, String type) {
        this.description = description;
        this.valueType = valueType;
        this.maximum = maximum;
        this.type = type;
    }

    // Getters and setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public MaximumConstraint getMaximum() {
        return maximum;
    }

    public void setMaximum(MaximumConstraint maximum) {
        this.maximum = maximum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ValueBoundConstraint{" +
                "valueType='" + valueType + '\'' +
                ", maximum=" + maximum +
                ", type='" + type + '\'' +
                '}';
    }
}
