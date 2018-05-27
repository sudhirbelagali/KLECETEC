package ec.klecet.com.klecetbustrack;

/**
 * Created by sudhir on 24/3/18.
 */
public class Location {
    Double latitude;
    Double longitude;

    public void setLongitude(Double logitude) {
        this.longitude = logitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }


    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }


    public Location() {

    }

    public Location(Double latitude, Double logitude) {
        this.latitude = latitude;
        this.longitude = logitude;
    }

    @Override
    public String toString() {
        return this.latitude + ":" + this.longitude;
    }

}
