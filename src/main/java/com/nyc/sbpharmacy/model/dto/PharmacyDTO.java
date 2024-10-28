package com.nyc.sbpharmacy.model.dto;

public class PharmacyDTO {

    private String pharmacyName;
    private String pharmacyAddress;
    private String pharmacyCity;
    private float lat;
    private float lng;

    public PharmacyDTO(String pharmacyName, String pharmacyAddress, String pharmacyCity) {
        this.pharmacyName = pharmacyName;
        this.pharmacyAddress = pharmacyAddress;
        this.pharmacyCity = pharmacyCity;
    }

    public PharmacyDTO() {
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public String getPharmacyAddress() {
        return pharmacyAddress;
    }

    public void setPharmacyAddress(String pharmacyAddress) {
        this.pharmacyAddress = pharmacyAddress;
    }

    public String getPharmacyCity() {
        return pharmacyCity;
    }

    public void setPharmacyCity(String pharmacyCity) {
        this.pharmacyCity = pharmacyCity;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {

        this.lng = lng;
    }

    @Override
    public String toString() {
        return "PharmacyDTO{" +
                "pharmacyName='" + pharmacyName + '\'' +
                ", pharmacyAddress='" + pharmacyAddress + '\'' +
                ", pharmacyCity='" + pharmacyCity + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
