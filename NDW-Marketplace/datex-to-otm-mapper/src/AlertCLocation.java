import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "alertCLocation", namespace = "http://datex2.eu/schema/2/2_0")
public class AlertCLocation {
    
    private AlertCLocationName alertCLocationName;
    private String specificLocation;

    @XmlElement(namespace = "http://datex2.eu/schema/2/2_0")
    public AlertCLocationName getAlertCLocationName() {
        return alertCLocationName;
    }

    public void setAlertCLocationName(AlertCLocationName alertCLocationName) {
        this.alertCLocationName = alertCLocationName;
    }

    @XmlElement(namespace = "http://datex2.eu/schema/2/2_0")
    public String getSpecificLocation() {
        return specificLocation;
    }

    public void setSpecificLocation(String specificLocation) {
        this.specificLocation = specificLocation;
    }
    
}
