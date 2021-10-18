package org.danlee;

public class Student extends Person implements Bills{

    @Override
    public double taxes(double amount) {
        return amount * 0.02;
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
