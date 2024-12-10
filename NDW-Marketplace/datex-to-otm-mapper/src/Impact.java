import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "impact", namespace = "http://datex2.eu/schema/2/2_0")
public class Impact {

    private int numberOfLanesRestricted;
    private int originalNumberOfLanes;
    private int residualRoadWidth;
    private ImpactExtension impactExtension;
    private LaneRestriction laneRestriction;

    @XmlElement(namespace = "http://datex2.eu/schema/2/2_0")
    public int getNumberOfLanesRestricted() {
        return numberOfLanesRestricted;
    }

    public void setNumberOfLanesRestricted(int numberOfLanesRestricted) {
        this.numberOfLanesRestricted = numberOfLanesRestricted;
    }

    @XmlElement(namespace = "http://datex2.eu/schema/2/2_0")
    public int getOriginalNumberOfLanes() {
        return originalNumberOfLanes;
    }

    public void setOriginalNumberOfLanes(int originalNumberOfLanes) {
        this.originalNumberOfLanes = originalNumberOfLanes;
    }

    @XmlElement(namespace = "http://datex2.eu/schema/2/2_0")
    public int getResidualRoadWidth() {
        return residualRoadWidth;
    }

    public void setResidualRoadWidth(int residualRoadWidth) {
        this.residualRoadWidth = residualRoadWidth;
    }

    @XmlElement(namespace = "http://datex2.eu/schema/2/2_0")
    public ImpactExtension getImpactExtension() {
        return impactExtension;
    }

    public void setImpactExtension(ImpactExtension impactExtension) {
        this.impactExtension = impactExtension;
    }

    @XmlElement(namespace = "http://datex2.eu/schema/2/2_0")
    public LaneRestriction getLaneRestriction() {
        return laneRestriction;
    }

    public void setLaneRestriction(LaneRestriction laneRestriction) {
        this.laneRestriction = laneRestriction;
    }
    
}