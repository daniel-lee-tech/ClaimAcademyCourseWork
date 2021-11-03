package com.claim.entity;

public class Address {

    private String street;
    private String city;
    private String state;
    private int zip;

    public Address() {

    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String address) {
        this.street = address;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }
}
