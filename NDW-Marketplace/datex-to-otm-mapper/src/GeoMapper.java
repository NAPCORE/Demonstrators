import java.util.List;

public class GeoMapper {
    String type;
    String countryCode;
    String tableId;
    String tableVersionId;
    List<Points> points;

    public GeoMapper() {
    }

    public GeoMapper(String type, String countryCode, String tableId, String tableVersionId, List<Points> points) {
        this.type = type;
        this.countryCode = countryCode;
        this.tableId = tableId;
        this.tableVersionId = tableVersionId;
        this.points = points;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getTableVersionId() {
        return tableVersionId;
    }

    public void setTableVersionId(String tableVersionId) {
        this.tableVersionId = tableVersionId;
    }

    public List<Points> getPoints() {
        return points;
    }

    public void setPoints(List<Points> points) {
        this.points = points;
    }
}
