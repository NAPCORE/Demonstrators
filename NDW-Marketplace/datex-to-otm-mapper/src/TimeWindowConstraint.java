public class TimeWindowConstraint {
    private String startTime;
    private String endTime; 
    private String description;
    private String type;

    // Default constructor
    public TimeWindowConstraint() {}

    // Parameterized constructor
    public TimeWindowConstraint(String startTime, String endTime, String description, String type) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.type = type;
    }

    // Getters and setters
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

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
