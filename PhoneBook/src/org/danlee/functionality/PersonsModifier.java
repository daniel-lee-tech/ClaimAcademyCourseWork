package org.danlee.functionality;

import org.danlee.models.PhoneBook;
import org.danlee.models.Person;

import java.util.Arrays;

public class PersonsModifier {
    private final PhoneBook phoneBook;

    public PersonsModifier(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }
//
//    public void addContact(String firstName, String lastName) throws InterruptedException {
//        Person[] persons = phoneBook.getPersons();
//
//        Person newPerson = new Person(firstName, lastName);
//
//        persons = Arrays.copyOf(persons, persons.length + 1);
//        persons[persons.length - 1] = newPerson;
//
//        phoneBook.loadAndPrint(firstName + " " + lastName + " has been added.");
//    }
//
//    public void editContact(Person contact, Person editedContact) throws Exception {
//        if (contactDoesNotExist(contact))
//            throw new Exception("Contact does not exist");
//
//        Person[] persons = phoneBook.getPersons();
//
//        for (int i = 0; i < persons.length; i++) {
//            Person currentContact = persons[i];
//            if (currentContact.getId().equals(editedContact.getId())) {
//                persons[i] = editedContact;
//                phoneBook.setPersons(persons);
//                return;
//            }
//        }
//    }
//
//    public void deleteContact(Person contact) throws Exception {
//        if (contactDoesNotExist(contact))
//            throw new Exception("Contact does not exist");
//
//        Person[] oldContacts = phoneBook.getPersons();
//        Person[] newContacts = new Person[oldContacts.length - 1];
//
//        for (int i = 0; i < newContacts.length; i++) {
//            Person currentContact = oldContacts[i];
//
//            if (currentContact.getId().equals(contact.getId())) {
//                continue;
//            }
//
//            newContacts[i] = currentContact;
//        }
//
//        phoneBook.setPersons(newContacts);
//    }
//
//    private boolean contactExists(Person contact) {
//        for (Person existingContact: phoneBook.getPersons()) {
//            if (existingContact.getId().equals(contact.getId())) {
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//    private boolean contactDoesNotExist(Person contact) {
//        return !contactExists(contact);
//    }
}
