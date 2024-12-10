import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "linearWithinLinearElement", namespace = "http://datex2.eu/schema/2/2_0")
public class LinearWithinLinearElement {

    private LinearElement linearElement;
    private FromPoint fromPoint;
    private ToPoint toPoint;

    @XmlElement(namespace = "http://datex2.eu/schema/2/2_0")
    public LinearElement getLinearElement() {
        return linearElement;
    }

    public void setLinearElement(LinearElement linearElement) {
        this.linearElement = linearElement;
    }

    @XmlElement(namespace = "http://datex2.eu/schema/2/2_0")
    public FromPoint getFromPoint() {
        return fromPoint;
    }

    public void setFromPoint(FromPoint fromPoint) {
        this.fromPoint = fromPoint;
    }

    @XmlElement(namespace = "http://datex2.eu/schema/2/2_0")
    public ToPoint getToPoint() {
        return toPoint;
    }

    public void setToPoint(ToPoint toPoint) {
        this.toPoint = toPoint;
    }
}