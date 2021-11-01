package models;


import java.util.Arrays;
import java.util.UUID;

public class Person {
    private UUID id;
    private String fullName;
    private PhoneNumber[] phoneNumbers = {};
    private Address address;

    public Person(String fullName) {
        this.fullName = fullName;
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return fullName.split(" ")[0];
    }

    public String getLastName() {
        String[] fullNameArr = fullName.split(" ");
        return fullNameArr[fullNameArr.length - 1];
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return this.fullName;
    }

    public PhoneNumber[] getPhoneNumbers() {
        return phoneNumbers;
    }

    public boolean hasPhoneNumber(double phoneNumber) {
        for (PhoneNumber number : this.phoneNumbers) {
            if (number.getNumber() == phoneNumber) {
                return true;
            }
        }

        return false;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
            phoneNumbers.append(number.getType()).append(": ").append(number.formattedPhoneNumber()).append("\n");
        }

        return phoneNumbers.toString();
    }

    public String infoSummary() {
        return "\n" +
                "\n" +
                this.getFullName() +
                "\n" +
                this.getAddressString() +
                "\nPhone Numbers:\n" +
                this.getAllNumbersAsString() +
                "\n" +
                "===========================================\n";
    }

    public String briefSummary() {
        return this.getFullName() + " " + this.getAddressString();
    }

    public void addPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumbers = Arrays.copyOf(this.phoneNumbers, this.phoneNumbers.length + 1);
        this.phoneNumbers[phoneNumbers.length - 1] = phoneNumber;
    }
}
