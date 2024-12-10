import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "impactExtension", namespace = "http://datex2.eu/schema/2/2_0")
public class ImpactExtension {

    private ImpactExtended impactExtended;

    @XmlElement(namespace = "http://datex2.eu/schema/2/2_0")
    public ImpactExtended getImpactExtended() {
        return impactExtended;
    }

    public void setImpactExtended(ImpactExtended impactExtended) {
        this.impactExtended = impactExtended;
    }
}