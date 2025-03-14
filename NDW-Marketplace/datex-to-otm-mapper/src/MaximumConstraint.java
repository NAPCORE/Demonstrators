public class MaximumConstraint {
    private int value;
    private String unit;

    // Default constructor
    public MaximumConstraint() {
    }

    // Parameterized constructor
    public MaximumConstraint(int value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    // Getters and setters
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }    
}
