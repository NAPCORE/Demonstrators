
import java.util.List;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "situation", namespace = "http://datex2.eu/schema/2/2_0")
public class Situation {

    private String id;
    private String version;
    private List<SituationRecord> situationRecords;
    private String situationVersionTime;

    @XmlAttribute(name="id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlAttribute(name="version")
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }


    @XmlElement(namespace = "http://datex2.eu/schema/2/2_0")
    public String getSituationVersionTime() {
        return situationVersionTime;
    }

    public void setSituationVersionTime(String situationVersionTime) {
        this.situationVersionTime = situationVersionTime;
    }

    @XmlElement(name = "situationRecord", namespace = "http://datex2.eu/schema/2/2_0")
    public List<SituationRecord> getSituationRecords() {
        return situationRecords;
    }

    public void setSituationRecords(List<SituationRecord> situationRecords) {
        this.situationRecords = situationRecords;
    }
}