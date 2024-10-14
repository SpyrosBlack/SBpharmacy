package com.nyc.sbpharmacy.model;

public class PharmacyDTO {

    private String pharmacyName;
    private String pharmacyAddress;
    private String pharmacyCity;
    private Float lat;
    private Float lng;

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

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLng() {
        return lng;
    }

    public void setLng(Float lng) {
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
