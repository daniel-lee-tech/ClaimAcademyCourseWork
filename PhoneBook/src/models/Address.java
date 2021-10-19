package models;

import java.util.UUID;

public class Address {
    private UUID id;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private int zipcode;

    public Address(String address1, String address2, String city, String state, int zipcode) {
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public String getFullAddress() {
        return address1 +" " + address2 + "\n" + city + ", " + state + ", " + zipcode;
    }

}
