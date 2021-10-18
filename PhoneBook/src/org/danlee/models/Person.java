package org.danlee.models;


import java.util.UUID;

public class Person{
    private UUID id;
    private String firstName;
    private String lastName;
    private PhoneNumber[] phoneNumbers = {};
    private Address address;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = UUID.randomUUID();
    }

    public UUID getId() { return id; }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public PhoneNumber[] getPhoneNumbers() {
        return phoneNumbers;
    }

    public void outputInfo() {
        System.out.println("=============");
        System.out.println("Full Name: " + getFullName());
        System.out.println("Address: " + address.getFullAddress());
        System.out.println();
    }

    public Address getAddress() {
        return this.address;
    }

    public String getAddressString() {
        if (this.address == null) {
            return "No Address";
        }

        return this.address.getFullAddress();
    }

    public String getAllNumbersAsString() {
        if (phoneNumbers.length == 0) {
            return "No phone numbers";
        }

        StringBuilder phoneNumbers = new StringBuilder();

        for (PhoneNumber number : getPhoneNumbers()) {
            phoneNumbers.append(number.getType()).append(": ").append(number.getNumber()).append("\n");
        }

        return phoneNumbers.toString();
    }
}
