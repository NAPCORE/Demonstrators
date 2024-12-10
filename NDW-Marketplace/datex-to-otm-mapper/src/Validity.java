
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "validity", namespace = "http://datex2.eu/schema/2/2_0")
public class Validity {
    private String validityStatus;
    private ValidityTimeSpecification validityTimeSpecification;
    

    @XmlElement(namespace = "http://datex2.eu/schema/2/2_0")
    public String getValidityStatus() {
        return validityStatus;
    }

    public void setValidityStatus(String validityStatus) {
        this.validityStatus = validityStatus;
    }

    @XmlElement(namespace = "http://datex2.eu/schema/2/2_0")
    public ValidityTimeSpecification getValidityTimeSpecification() {
        return validityTimeSpecification;
    }

    public void setValidityTimeSpecification(ValidityTimeSpecification validityTimeSpecification) {
        this.validityTimeSpecification = validityTimeSpecification;
    }
}
