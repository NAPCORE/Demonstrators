import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "laneRestriction", namespace = "http://datex2.eu/schema/2/2_0")
public class LaneRestriction {

    private String lane;
    private String minLaneWidth;

    @XmlElement(name = "lane", namespace = "http://datex2.eu/schema/2/2_0")
    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }

    @XmlElement(name = "minLaneWidth", namespace = "http://datex2.eu/schema/2/2_0")
    public String getMinLaneWidth() {
        return minLaneWidth;
    }

    public void setMinLaneWidth(String minLaneWidth) {
        this.minLaneWidth = minLaneWidth;
    }
    
}