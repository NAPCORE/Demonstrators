import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "alertCLinear", namespace = "http://datex2.eu/schema/2/2_0")
public class AlertCLinear {
    
    private String alertCLocationCountryCode;
    private String alertCLocationTableNumber;
    private String alertCLocationTableVersion;
    private AlertCDirection alertCDirection;
    private AlertCMethod4PrimaryPointLocation alertCMethod4PrimaryPointLocation;
    private AlertCMethod4SecondaryPointLocation alertCMethod4SecondaryPointLocation;

    @XmlElement(name = "alertCLocationCountryCode", namespace = "http://datex2.eu/schema/2/2_0")
    public String getAlertCLocationCountryCode() {
        return alertCLocationCountryCode;
    }

    public void setAlertCLocationCountryCode(String alertCLocationCountryCode) {
        this.alertCLocationCountryCode = alertCLocationCountryCode;
    }

    @XmlElement(name = "alertCLocationTableNumber", namespace = "http://datex2.eu/schema/2/2_0")
    public String getAlertCLocationTableNumber() {
        return alertCLocationTableNumber;
    }

    public void setAlertCLocationTableNumber(String alertCLocationTableNumber) {
        this.alertCLocationTableNumber = alertCLocationTableNumber;
    }

    @XmlElement(name = "alertCLocationTableVersion", namespace = "http://datex2.eu/schema/2/2_0")
    public String getAlertCLocationTableVersion() {
        return alertCLocationTableVersion;
    }

    public void setAlertCLocationTableVersion(String alertCLocationTableVersion) {
        this.alertCLocationTableVersion = alertCLocationTableVersion;
    }

    @XmlElement(name = "alertCDirection", namespace = "http://datex2.eu/schema/2/2_0")
    public AlertCDirection getAlertCDirection() {
        return alertCDirection;
    }

    public void setAlertCDirection(AlertCDirection alertCDirection) {
        this.alertCDirection = alertCDirection;
    }


    @XmlElement(name = "alertCMethod4PrimaryPointLocation", namespace = "http://datex2.eu/schema/2/2_0")
    public AlertCMethod4PrimaryPointLocation getAlertCMethod4PrimaryPointLocation() {
        return alertCMethod4PrimaryPointLocation;
    }

    public void setAlertCMethod4PrimaryPointLocation(AlertCMethod4PrimaryPointLocation alertCMethod4PrimaryPointLocation) {
        this.alertCMethod4PrimaryPointLocation = alertCMethod4PrimaryPointLocation;
    }

    @XmlElement(name = "alertCMethod4SecondaryPointLocation", namespace = "http://datex2.eu/schema/2/2_0")
    public AlertCMethod4SecondaryPointLocation getAlertCMethod4SecondaryPointLocation() {
        return alertCMethod4SecondaryPointLocation;
    }

    public void setAlertCMethod4SecondaryPointLocation(AlertCMethod4SecondaryPointLocation alertCMethod4SecondaryPointLocation) {
        this.alertCMethod4SecondaryPointLocation = alertCMethod4SecondaryPointLocation;
    }
    

}
