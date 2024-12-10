import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "recurringTimePeriodOfDay", namespace = "http://datex2.eu/schema/2/2_0")
public class RecurringTimePeriodOfDay {
    private String startTimeOfPeriod;
    private String endTimeOfPeriod;

    @XmlElement(namespace = "http://datex2.eu/schema/2/2_0")
    public String getStartTimeOfPeriod() {
        return startTimeOfPeriod;
    }

    public void setStartTimeOfPeriod(String startTimeOfPeriod) {
        this.startTimeOfPeriod = startTimeOfPeriod;
    }

    @XmlElement(namespace = "http://datex2.eu/schema/2/2_0")
    public String getEndTimeOfPeriod() {
        return endTimeOfPeriod;
    }

    public void setEndTimeOfPeriod(String endTimeOfPeriod) {
        this.endTimeOfPeriod = endTimeOfPeriod;
    }
}
