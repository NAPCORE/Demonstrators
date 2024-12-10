import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ToPoint", namespace = "http://datex2.eu/schema/2/2_0")
public class ToPoint {
    private String distanceAlong;
    private FromReferent fromReferent;
    private TowardsReferent towardsReferent;

    @XmlElement(name = "distanceAlong", namespace = "http://datex2.eu/schema/2/2_0")
    public String getDistanceAlong() {
        return distanceAlong;
    }

    public void setDistanceAlong(String distanceAlong) {
        this.distanceAlong = distanceAlong;
    }

    @XmlElement(name = "fromReferent", namespace = "http://datex2.eu/schema/2/2_0")
    public FromReferent getFromReferent() {
        return fromReferent;
    }

    public void setFromReferent(FromReferent fromReferent) {
        this.fromReferent = fromReferent;
    }

    @XmlElement(name = "towardsReferent", namespace = "http://datex2.eu/schema/2/2_0")
    public TowardsReferent getTowardsReferent() {
        return towardsReferent;
    }

    public void setTowardsReferent(TowardsReferent towardsReferent) {
        this.towardsReferent = towardsReferent;
    }
    
}
