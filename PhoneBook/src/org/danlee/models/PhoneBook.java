package org.danlee.models;

import org.danlee.controllers.PhoneBookController;
import org.danlee.functionality.*;
import org.danlee.models.*;

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
