import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "alertCMethod4SecondaryPointLocation", namespace = "http://datex2.eu/schema/2/2_0")
public class AlertCMethod4SecondaryPointLocation {
    
    private AlertCLocation alertCLocation;
    private OffsetDistance offsetDistance;

    @XmlElement(namespace = "http://datex2.eu/schema/2/2_0")
    public AlertCLocation getAlertCLocation() {
        return alertCLocation;
    }

    public void setAlertCLocation(AlertCLocation alertCLocation) {
        this.alertCLocation = alertCLocation;
    }

    @XmlElement(namespace = "http://datex2.eu/schema/2/2_0")
    public OffsetDistance getOffsetDistance() {
        return offsetDistance;
    }

    public void setOffsetDistance(OffsetDistance offsetDistance) {
        this.offsetDistance = offsetDistance;
    }
    
}
