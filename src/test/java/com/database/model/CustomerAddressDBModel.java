package com.database.model;

public class CustomerAddressDBModel {

    private int id;
    private String flatNumber;
    private String apartmentNumber;
    private String streetNumber;
    private String landmark;
    private String area;
    private String pincode;
    private String country;
    private String state;
    private int tr_customer_address_id;

    // Default Constructor
    public CustomerAddressDBModel() {
    }

    // Parameterized Constructor
    public CustomerAddressDBModel(int id,
                                  String flatNumber,
                                  String apartmentNumber,
                                  String streetNumber,
                                  String landmark,
                                  String area,
                                  String pincode,
                                  String country,
                                  String state) {

        this.id = id;
        this.flatNumber = flatNumber;
        this.apartmentNumber = apartmentNumber;
        this.streetNumber = streetNumber;
        this.landmark = landmark;
        this.area = area;
        this.pincode = pincode;
        this.country = country;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "CustomerAddressDBModel [id=" + id
                + ", flatNumber=" + flatNumber
                + ", apartmentNumber=" + apartmentNumber
                + ", streetNumber=" + streetNumber
                + ", landmark=" + landmark
                + ", area=" + area
                + ", pincode=" + pincode
                + ", country=" + country
                + ", state=" + state + "]";
    }
}