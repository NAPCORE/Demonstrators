import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlAttribute;

@XmlRootElement(name = "SituationRecord")
public class SituationRecord {

    protected String id;
    protected String version;
    protected String situationRecordCreationTime;
    protected String situationRecordVersionTime;
    protected String probabilityOfOccurrence;
    protected Validity validity;
    protected Impact impact;
    protected GroupOfLocations groupOfLocations;
    protected String type;

    public SituationRecord() {
    }

    public SituationRecord(String id, String version, String situationRecordCreationTime, String situationRecordVersionTime, String probabilityOfOccurrence, Validity validity, Impact impact, GroupOfLocations groupOfLocations, String type) {
        this.id = id;
        this.version = version;
        this.situationRecordCreationTime = situationRecordCreationTime;
        this.situationRecordVersionTime = situationRecordVersionTime;
        this.probabilityOfOccurrence = probabilityOfOccurrence;
        this.validity = validity;
        this.impact = impact;
        this.groupOfLocations = groupOfLocations;
        this.type = type;
    }

    public SituationRecord getSituationRecord() {
        return this;
    }

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
    public String getSituationRecordCreationTime() {
        return situationRecordCreationTime;
    }

    public void setSituationRecordCreationTime(String situationRecordCreationTime) {
        this.situationRecordCreationTime = situationRecordCreationTime;
    }

    @XmlElement(namespace = "http://datex2.eu/schema/2/2_0")
    public String getSituationRecordVersionTime() {
        return situationRecordVersionTime;
    }

    public void setSituationRecordVersionTime(String situationRecordVersionTime) {
        this.situationRecordVersionTime = situationRecordVersionTime;
    }

    @XmlElement(namespace = "http://datex2.eu/schema/2/2_0")
    public String getProbabilityOfOccurrence() {
        return probabilityOfOccurrence;
    }

    public void setProbabilityOfOccurrence(String probabilityOfOccurrence) {
        this.probabilityOfOccurrence = probabilityOfOccurrence;
    }

    @XmlElement(namespace = "http://datex2.eu/schema/2/2_0")
    public Validity getValidity() {
        return validity;
    }

    public void setValidity(Validity validity) {
        this.validity = validity;
    }

    @XmlElement(namespace = "http://datex2.eu/schema/2/2_0")
    public Impact getImpact() {
        return impact;
    }

    public void setImpact(Impact impact) {
        this.impact = impact;
    }

    @XmlElement(name = "groupOfLocations", namespace = "http://datex2.eu/schema/2/2_0")
    public GroupOfLocations getGroupOfLocations() {
        return groupOfLocations;
    }

    public void setGroupOfLocations(GroupOfLocations groupOfLocations) {
        this.groupOfLocations = groupOfLocations;
    }

    @XmlAttribute(name="type", namespace = "http://www.w3.org/2001/XMLSchema-instance")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}