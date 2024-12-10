import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "affectedCarriagewayAndLanes", namespace = "http://datex2.eu/schema/2/2_0")
public class AffectedCarriagewayAndLanes {
    
    private String carriageway;
    private int lengthAffected;

    @XmlElement(name = "carriageway", namespace = "http://datex2.eu/schema/2/2_0")
    public String getCarriageway() {
        return carriageway;
    }

    public void setCarriageway(String carriageway) {
        this.carriageway = carriageway;
    }

    @XmlElement(name = "lengthAffected", namespace = "http://datex2.eu/schema/2/2_0")
    public int getLengthAffected() {
        return lengthAffected;
    }

    public void setLengthAffected(int lengthAffected) {
        this.lengthAffected = lengthAffected;
    }

}
