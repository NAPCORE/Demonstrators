import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "towardsReferent", namespace = "http://datex2.eu/schema/2/2_0")
public class TowardsReferent {
    private String referentIdentifier;
    private String referentType;

    @XmlElement(name = "referentIdentifier", namespace = "http://datex2.eu/schema/2/2_0")
    public String getReferentIdentifier() {
        return referentIdentifier;
    }

    public void setReferentIdentifier(String referentIdentifier) {
        this.referentIdentifier = referentIdentifier;
    }

    @XmlElement(name = "referentType", namespace = "http://datex2.eu/schema/2/2_0")
    public String getReferentType() {
        return referentType;
    }

    public void setReferentType(String referentType) {
        this.referentType = referentType;
    }

}
