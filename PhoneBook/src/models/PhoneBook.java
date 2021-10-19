package models;

import functionality.*;
import models.*;

import java.util.Arrays;

public class PhoneBook {
    private Person[] persons = {};

    public Person[] getPersons() {
        return persons;
    }

    public void setPersons(Person[] persons) {
        this.persons = persons;
    }

    public void addPerson(Person person) {
        this.persons = Arrays.copyOf(persons, persons.length + 1);
        this.persons[persons.length - 1] = person;
    }
}
