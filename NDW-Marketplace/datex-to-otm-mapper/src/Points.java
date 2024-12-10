public class Points {
    String locationCode;
    String direction;

    public Points() {
    }

    public Points(String locationCode, String direction) {
        this.locationCode = locationCode;
        this.direction = direction;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
