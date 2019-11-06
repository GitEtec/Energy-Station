package deb.px.com.example.energystation.model;

import com.google.firebase.database.DatabaseReference;

import java.io.Serializable;

import deb.px.com.example.energystation.config.ConfigFirebase;

public class EnergyStation implements Serializable {
    private String id;
    private String title;
    private int totalImages;
    private String address;
    private String phone;
    private MyLatLng myLatLng;
    private String schudele;
    private String convenience;
    private String parking;

    public EnergyStation() {
    }

    public EnergyStation(String id, String title, int totalImages, String address, String phone, MyLatLng myLatLng, String schudele, String convenience, String parking) {
        this.id = id;
        this.title = title;
        this.totalImages = totalImages;
        this.address = address;
        this.phone = phone;
        this.myLatLng = myLatLng;
        this.schudele = schudele;
        this.convenience = convenience;
        this.parking = parking;
    }

    public void salvar() {
        DatabaseReference energyStationsReference = ConfigFirebase.getDatabase()
                .child("stations")
                .child(id);

        energyStationsReference.setValue(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotalImages() {
        return totalImages;
    }

    public void setTotalImages(int totalImages) {
        this.totalImages = totalImages;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public MyLatLng getMyLatLng() {
        return myLatLng;
    }

    public void setMyLatLng(MyLatLng myLatLng) {
        this.myLatLng = myLatLng;
    }

    public String getSchudele() {
        return schudele;
    }

    public void setSchudele(String schudele) {
        this.schudele = schudele;
    }

    public String getConvenience() {
        return convenience;
    }

    public void setConvenience(String convenience) {
        this.convenience = convenience;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }
}
