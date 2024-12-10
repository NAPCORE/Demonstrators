import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "alertCDirection", namespace = "http://datex2.eu/schema/2/2_0")
public class AlertCDirection {
    
    private String alertCDirectionCoded;

    @XmlElement(name = "alertCDirectionCoded", namespace = "http://datex2.eu/schema/2/2_0")
    public String getAlertCDirectionCoded() {
        return alertCDirectionCoded;
    }

    public void setAlertCDirectionCoded(String alertCDirectionCoded) {
        this.alertCDirectionCoded = alertCDirectionCoded;
    }
    
}
