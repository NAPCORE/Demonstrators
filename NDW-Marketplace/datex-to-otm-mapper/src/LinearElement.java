import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "linearElement", namespace = "http://datex2.eu/schema/2/2_0")
public class LinearElement {
    private String roadNumber;
    private String linearElementReferenceModel;

    @XmlElement(name = "roadNumber", namespace = "http://datex2.eu/schema/2/2_0")
    public String getRoadNumber() {
        return roadNumber;
    }

    public void setRoadNumber(String roadNumber) {
        this.roadNumber = roadNumber;
    }

    @XmlElement(name = "linearElementReferenceModel", namespace = "http://datex2.eu/schema/2/2_0")
    public String getLinearElementReferenceModel() {
        return linearElementReferenceModel;
    }

    public void setLinearElementReferenceModel(String linearElementReferenceModel) {
        this.linearElementReferenceModel = linearElementReferenceModel;
    }

}
