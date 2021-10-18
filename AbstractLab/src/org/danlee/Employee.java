package org.danlee;

public class Employee extends Person implements Bills{

    @Override
    public double taxes(double amount) {
        return amount * 0.2;
    }

    @Override
    public double calculateTelephoneBill(double amount) {
        return this.taxes(amount) + amount;
    }

    @Override
    public double calculateOtherBills(double amount) {
        return this.taxes(amount) + amount;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }

    @Override
    public double gasBill() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double carInsurance() {
        // TODO Auto-generated method stub
        return 0;
    }
}
