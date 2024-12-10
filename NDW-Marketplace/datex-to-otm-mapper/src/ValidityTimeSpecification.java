
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "validityTimeSpecification", namespace = "http://datex2.eu/schema/2/2_0")
public class ValidityTimeSpecification {
    private String overallStartTime;
    private String overallEndTime;
    private List<ValidPeriod> validPeriods;

    @XmlElement(name="overallStartTime", namespace = "http://datex2.eu/schema/2/2_0")
    public String getOverallStartTime() {
        return overallStartTime;
    }

    public void setOverallStartTime(String overallStartTime) {
        this.overallStartTime = overallStartTime;
    }

    @XmlElement(name="overallEndTime", namespace = "http://datex2.eu/schema/2/2_0")
    public String getOverallEndTime() {
        return overallEndTime;
    }

    public void setOverallEndTime(String overallEndTime) {
        this.overallEndTime = overallEndTime;
    }
    
    @XmlElement(name="validPeriod", namespace = "http://datex2.eu/schema/2/2_0")
    public List<ValidPeriod> getValidPeriods() {
        return validPeriods;
    }

    public void setValidPeriods(List<ValidPeriod> validPeriods) {
        this.validPeriods = validPeriods;
    }
}
