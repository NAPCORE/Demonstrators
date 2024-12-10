import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "groupOfLocations", namespace = "http://datex2.eu/schema/2/2_0")
public class GroupOfLocations {

    private LinearWithinLinearElement linearWithinLinearElement;
    private SupplementaryPositionalDescription supplementaryPositionalDescription;
    private AlertCLinear alertCLinear;
    //locationContainedInGroup

    @XmlElement(name = "linearWithinLinearElement", namespace = "http://datex2.eu/schema/2/2_0")
    public LinearWithinLinearElement getLinearWithinLinearElement() {
        return linearWithinLinearElement;
    }

    public void setLinearWithinLinearElement (LinearWithinLinearElement linearWithinLinearElement) {
        this.linearWithinLinearElement = linearWithinLinearElement;
    }

    @XmlElement(name = "supplementaryPositionalDescription", namespace = "http://datex2.eu/schema/2/2_0")
    public SupplementaryPositionalDescription getSupplementaryPositionalDescription() {
        return supplementaryPositionalDescription;
    }

    public void setSupplementaryPositionalDescription(SupplementaryPositionalDescription supplementaryPositionalDescription) {
        this.supplementaryPositionalDescription = supplementaryPositionalDescription;
    }

    @XmlElement(name = "alertCLinear", namespace = "http://datex2.eu/schema/2/2_0")
    public AlertCLinear getAlertCLinear() {
        return alertCLinear;
    }

    public void setAlertCLinear(AlertCLinear alertCLinear) {
        this.alertCLinear = alertCLinear;
    }
    
}