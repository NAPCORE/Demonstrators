import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "recurringDayWeekMonthPeriod", namespace = "http://datex2.eu/schema/2/2_0")
public class RecurringDayWeekMonthPeriod {
    private List<String> applicableDay;

    @XmlElement(namespace = "http://datex2.eu/schema/2/2_0")
    public List<String> getApplicableDay() {
        return applicableDay;
    }

    public void setApplicableDay(List<String> applicableDay) {
        this.applicableDay = applicableDay;
    }
}
