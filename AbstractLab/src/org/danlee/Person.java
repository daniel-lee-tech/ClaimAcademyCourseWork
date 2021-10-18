package org.danlee;

public abstract class Person {
    protected String firstName;
    protected String lastName;

    abstract public double taxes(double amount);

    abstract double calculateTelephoneBill(double amount);

    abstract double calculateOtherBills(double amount);

    public String toString() {
        return this.firstName + this.lastName;
    };
}
