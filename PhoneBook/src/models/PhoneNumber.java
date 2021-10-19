package models;

import java.util.UUID;

public class PhoneNumber {
    enum NumberType {
        CELL,
        HOME,
        FAX,
        WORK
    }

    private UUID id;
    private Person owner;
    private double number;
    private NumberType type;

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public double getNumber() {
        return number;
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
