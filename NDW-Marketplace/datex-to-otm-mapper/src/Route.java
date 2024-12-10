import java.util.Map;
import java.util.Optional;

public class Route {
    private String id;
    private String creationDate;
    private String lastModified;
    private Map<String, Object> externalAttributes;
    private Optional<GeoMapper> geoReferences;
    private RouteConstraint constraint;

    // Default constructor
    public Route() {}

    // Parameterized constructor
    public Route(String id, String creationDate, String lastModified, Map<String, Object> externalAttributes, Optional<GeoMapper> geoReferences, RouteConstraint constraint) {
        this.id = id;
        this.creationDate = creationDate;
        this.lastModified = lastModified;
        this.externalAttributes = externalAttributes;
        this.geoReferences = geoReferences;
        this.constraint = constraint;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public Map<String, Object> getExternalAttributes() {
        return externalAttributes;
    }

    public void setExternalAttributes(Map<String, Object> externalAttributes) {
        this.externalAttributes = externalAttributes;
    }

    public Optional<GeoMapper> getGeoReferences() {
        return geoReferences;
    }

    public void setGeoReferences(Optional<GeoMapper> geoReferences) {
        this.geoReferences = geoReferences;
    }

    public RouteConstraint getConstraint() {
        return constraint;
    }

    public void setConstraint(RouteConstraint constraint) {
        this.constraint = constraint;
    }

    // toString method for better readability
    @Override
    public String toString() {
        return "Route{" +
                "id='" + id + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", lastModified='" + lastModified + '\'' +
                ", externalAttributes='" + externalAttributes + '\'' +
                ", georeferences=" + geoReferences + '\'' +
                ", constraint=" + constraint +
                '}';
    }
}