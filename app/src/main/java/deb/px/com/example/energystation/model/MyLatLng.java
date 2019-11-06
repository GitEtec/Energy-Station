package deb.px.com.example.energystation.model;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

public class MyLatLng implements Serializable {
    private double latitude;
    private double longitude;

    public MyLatLng() {
    }

    public MyLatLng(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public LatLng toLatLng() {
        return new LatLng(latitude, longitude);
    }
}
