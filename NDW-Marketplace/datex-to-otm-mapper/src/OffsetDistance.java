import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "offsetDistance", namespace = "http://datex2.eu/schema/2/2_0")
public class OffsetDistance {
    
    private int offsetDistance;

    @XmlElement(name = "offsetDistance", namespace = "http://datex2.eu/schema/2/2_0")
    public int getOffsetDistance() {
        return offsetDistance;
    }

    public void setOffsetDistance(int offsetDistance) {
        this.offsetDistance = offsetDistance;
    }
    
}
