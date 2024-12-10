import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "impactExtended", namespace = "http://datex2.eu/schema/2/2_0")
public class ImpactExtended {

    private String hardShoulderStatus;
    private String laneStatusCoded;
    private List<LaneRestriction> laneRestrictions;

    @XmlElement(namespace = "http://datex2.eu/schema/2/2_0")
    public String getHardShoulderStatus() {
        return hardShoulderStatus;
    }

    public void setHardShoulderStatus(String hardShoulderStatus) {
        this.hardShoulderStatus = hardShoulderStatus;
    }

    @XmlElement(namespace = "http://datex2.eu/schema/2/2_0")
    public String getLaneStatusCoded() {
        return laneStatusCoded;
    }

    public void setLaneStatusCoded(String laneStatusCoded) {
        this.laneStatusCoded = laneStatusCoded;
    }

    @XmlElement(namespace = "http://datex2.eu/schema/2/2_0")
    public List<LaneRestriction> getLaneRestrictions() {
        return laneRestrictions;
    }

    public void setLaneRestrictions(List<LaneRestriction> laneRestrictions) {
        this.laneRestrictions = laneRestrictions;
    }
}