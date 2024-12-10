import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "payloadPublication", namespace = "http://datex2.eu/schema/2/2_0")
@XmlType(propOrder = { "publicationTime", "publicationCreator", "situations" })
public class PayloadPublication {

    private String publicationTime;
    private String publicationCreator;
    private List<Situation> situations;

    @XmlElement(namespace = "http://datex2.eu/schema/2/2_0")
    public String getPublicationTime() {
        return publicationTime;
    }

    public void setPublicationTime(String publicationTime) {
        this.publicationTime = publicationTime;
    }

    @XmlElement(namespace = "http://datex2.eu/schema/2/2_0")
    public String getPublicationCreator() {
        return publicationCreator;
    }

    public void setPublicationCreator(String publicationCreator) {
        this.publicationCreator = publicationCreator;
    }

    @XmlElement(name = "situation", namespace = "http://datex2.eu/schema/2/2_0")
    public List<Situation> getSituations() {
        return situations;
    }

    public void setSituations(List<Situation> situations) {
        this.situations = situations;
    }
}