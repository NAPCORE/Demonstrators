import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "alertCLocation", namespace = "http://datex2.eu/schema/2/2_0")
public class AlertCLocationName {
    
    private List<String> values;

    @XmlElement(namespace = "http://datex2.eu/schema/2/2_0")
    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
    
}
