package models;

import java.util.UUID;

public class PhoneNumber {
    private UUID id;
    private Person owner;
    private long number;
    private NumberType type;

    public PhoneNumber(Person owner, long number, NumberType type) {
        this.owner = owner;
        this.number = number;
        this.type = type;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public double getNumber() {
        return number;
    }

    public String formattedPhoneNumber() {
        String number = Long.toString(this.number);

        String formattedNumber = "(" + (number.substring(0, 3) + ") ");
        formattedNumber += number.substring(3, 6) + "-";
        formattedNumber += number.substring(6);

        return formattedNumber;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public NumberType getType() {
        return type;
    }

    public void setType(NumberType type) {
        this.type = type;
    }
}
