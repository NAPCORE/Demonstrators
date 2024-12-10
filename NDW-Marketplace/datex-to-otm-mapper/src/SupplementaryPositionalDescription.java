import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "supplementaryPositionalDescription", namespace = "http://datex2.eu/schema/2/2_0")
public class SupplementaryPositionalDescription {
    
    private AffectedCarriagewayAndLanes affectedCarriagewayAndLanes;

    @XmlElement(name = "affectedCarriagewayAndLanes", namespace = "http://datex2.eu/schema/2/2_0")
    public AffectedCarriagewayAndLanes getAffectedCarriagewayAndLanes() {
        return affectedCarriagewayAndLanes;
    }

    public void setAffectedCarriagewayAndLanes(AffectedCarriagewayAndLanes affectedCarriagewayAndLanes) {
        this.affectedCarriagewayAndLanes = affectedCarriagewayAndLanes;
    }
    
}
