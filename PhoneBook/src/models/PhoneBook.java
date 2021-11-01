package models;

import java.util.Arrays;
import java.util.UUID;

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

        for (int i = 0; i < this.persons.length; i++) {
            Person iObject = this.persons[i];

            for (int j = 0; j < this.persons.length; j++) {
                Person jObject = this.persons[j];

                if (iObject.getFullName().compareToIgnoreCase(jObject.getFullName()) < 0) {
                    Person temp = iObject;
                    this.persons[i] = jObject;
                    this.persons[j] = temp;
                }
            }
        }
    }

    public void deletePerson(Person person) {
        Person[] contacts = new Person[1];

        for (Person loopedPerson: getPersons()) {
            if (loopedPerson.getId() != person.getId()) {
                contacts[contacts.length - 1] = loopedPerson;
                contacts = Arrays.copyOf(contacts, contacts.length + 1);
            }
        }

        this.persons = contacts;
    }

    public Person[] filterPersonsByCase(String caseInput, String comparison) {
        Person[] contacts = {};
        for (Person person : getPersons()) {
            switch (caseInput) {
                case "0":
                    if (person.getId().equals(UUID.fromString(comparison)))
                        contacts = addToContactsArray(contacts, person);
                    break;
                case "1":
                    if (person.getLastName().equals(comparison))
                        contacts = addToContactsArray(contacts, person);
                    break;

                case "2":
                    if (person.getFirstName().equals(comparison))
                        contacts = addToContactsArray(contacts, person);
                    break;

                case "3":
                    if (person.getFullName().equals(comparison))
                        contacts = addToContactsArray(contacts, person);
                    break;

                case "4":
                    long phoneNumber;
                    try {
                        phoneNumber = Long.parseLong(comparison);
                        if (person.hasPhoneNumber(phoneNumber))
                            contacts = addToContactsArray(contacts, person);
                    } catch (Exception e) {
                        System.out.println("Not a valid input, Returning to main menu.");
                        return contacts;
                    }
                    break;
            }
        }

        return contacts;
    }

    private Person[] addToContactsArray(Person[] contacts, Person person) {
        contacts = Arrays.copyOf(contacts, contacts.length + 1);
        contacts[contacts.length - 1] = person;
        return contacts;
    }
}
