package org.danlee.controllers;

import org.danlee.models.PhoneBook;
import org.danlee.functionality.ContactFinder;
import org.danlee.functionality.PersonsModifier;
import org.danlee.models.Person;

import java.util.Arrays;
import java.util.UUID;

public class PhoneBookController extends Controller {
    private final PhoneBook phoneBook;

    public PhoneBookController(PhoneBook phoneBook) throws InterruptedException {
        this.phoneBook = phoneBook;

        while (!currentInput().equals("exit")) {
            printMainMenu();
            getInput();
            switch (currentInput()) {
                case "0" -> {
                    printAllContacts();
                }
                case "1" -> {
                    System.out.println("Enter first name: ");
                    String firstName = getInput();

                    System.out.println("Enter last name: ");
                    String lastName = getInput();

                    Person person = new Person(firstName, lastName);

                    phoneBook.addPerson(person);
                    loadAndPrint("Added contact!");
                }

                case "2" -> {
                    printContactFinderMenu();
                    String option = getInput();

                    System.out.println("Enter in the value of your query (ex, last name or phone number.. etc..)");

                    String comparison = getInput();
                }

                case "3" -> {
                    printContactFinderMenu();

                    String option = getInput();

                    System.out.println("Enter in the value of your query (ex, last name or phone number.. etc..)");

                    String comparison = getInput();

                    Person[] filteredContacts = filterPersonsByCase(option, comparison);
                    printOutContacts(filteredContacts);

                }
//
//                case "4" -> {
//                    PersonsModifier personsModifier = new PersonsModifier(phoneBook);
//
//                }
            }
        }
    }

    public void printAllContacts() throws InterruptedException {
        if (phoneBook.getPersons().length == 0) {
            loadAndPrint("No contacts");
            return;
        }
        StringBuilder all = new StringBuilder();

        for (Person person : phoneBook.getPersons()) {
            all
                    .append(person.getFullName())
                    .append(" => with ")
                    .append(person.getPhoneNumbers().length)
                    .append(" numbers.")
                    .append("\n");
        }

        loadAndPrint(all.toString());
    }

    private Person[] filterPersonsByCase(String caseInput, String comparison) {
        Person[] contacts = {};
        for (Person person : phoneBook.getPersons()) {
            switch (caseInput) {
                case "0":
                    if (person.getId().equals(UUID.fromString(comparison)))
                        contacts = addToContactsArray(contacts, person);
                case "1":
                    if (person.getLastName().equals(comparison)) contacts = addToContactsArray(contacts, person);
                case "2":
                    if (person.getFirstName().equals(comparison)) contacts = addToContactsArray(contacts, person);
            }
        }

        return contacts;
    }

    private Person[] addToContactsArray(Person[] contacts, Person person) {
        contacts = Arrays.copyOf(contacts, contacts.length + 1);
        contacts[contacts.length - 1] = person;
        return contacts;
    }

    private void printContactFinderMenu() {
        System.out.println("How do you want to find your contact(s)?");
        System.out.println("1 by last name");
        System.out.println("2 by first name");
        System.out.println("3 by full name (first last)");
        System.out.println("4 by phone number");
    }


    private void printOutContacts(Person[] contacts) throws InterruptedException {
        StringBuilder output = new StringBuilder();

        output.append("Found ").append(contacts.length).append(" contact(s) with your search parameters.\n");

        for (Person contact : contacts) {
            output
                    .append(contact.getId())
                    .append("\n")
                    .append(contact.getFullName())
                    .append("\n")
                    .append(contact.getAddressString())
                    .append("\nPhone Numbers:\n")
                    .append(contact.getAllNumbersAsString())
                    .append("\n")
                    .append("===========================================\n");
        }

        loadAndPrint(output.toString());
    }
}
