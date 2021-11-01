package views;

import java.util.Locale;

import models.Address;
import models.NumberType;
import models.Person;
import models.PhoneNumber;


public class OutputView {
    public void printMainMenu() {
        System.out.println("========= MENU ===========");
        System.out.println("Type 'exit' without quotes to cancel the program at anytime");
        System.out.println("Menu: ");
        System.out.println("type `print all` to print all contacts");
        System.out.println("type `add entry` to add new contact");
        System.out.println("type `add many entries` to add new contact");
        System.out.println("type `add new` to add new contact");
        System.out.println("type `add many` to add many contacts");
        System.out.println("type `find one` to find a single contact");
        System.out.println("type `find many` to find many contacts by a condition");
        System.out.println("type `add phone number` to add a phone number for a contact");
        System.out.println("type `edit` to edit contact");
        System.out.println("type `delete` delete contact");
        System.out.println("Type `exit` without quotes to cancel the program at anytime");
        System.out.println("========= MENU END ===========");
    }

    public void printAllContacts(Person[] persons) throws InterruptedException {
        if (persons.length == 0) {
            loadAndPrint("No contacts");
            return;
        }
        StringBuilder all = new StringBuilder();

        for (Person person : persons) {
            all
                    .append(person.getFullName())
                    .append(" => with ")
                    .append(person.getPhoneNumbers().length)
                    .append(" numbers.")
                    .append("\n");
        }

        loadAndPrint(all.toString());
    }

    public void printContactFinderMenu() {
        System.out.println("How do you want to find your contact(s)?");
        System.out.println("1 by last name");
        System.out.println("2 by first name");
        System.out.println("3 by full name (first last)");
        System.out.println("4 by phone number");
    }

    public void printOutContacts(Person[] contacts) throws InterruptedException {
        if (contacts.length == 0) {
            System.out.println("No contacts");
            return;
        }

        StringBuilder output = new StringBuilder();

        output.append("Found ").append(contacts.length).append(" contact(s) with your search parameters.\n");

        for (Person contact : contacts) {
            output.append(contact.infoSummary());
        }

        loadAndPrint(output.toString());
    }

    public Person choseOneContactFromArrayToPrint(Person[] filteredContacts) {
        Person contact = null;
        if (filteredContacts.length == 0) {
            System.out.println("No contacts by that condition");
            return null;
        }

        if (filteredContacts.length == 1) {
            contact = filteredContacts[0];
            System.out.println(filteredContacts[0].infoSummary());
            return contact;
        }

        System.out.println("Please pick <NUMBER> for contact you want to focus on: ");
        for (int i = 0; i < filteredContacts.length; i++) {
            System.out.println("<NUMBER>: " + i);
            System.out.println(filteredContacts[i].briefSummary());
        }

        String number = new InputView().getInput();

        try {
            int index = Integer.parseInt(number);
            contact = filteredContacts[index];
            System.out.println(filteredContacts[index].infoSummary());
        } catch (Exception e) {
            System.out.println("Invalid <NUMBER> input");
        }

        return contact;
    }

    public void loadAndPrint(String message) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            System.out.println("loading...");
            Thread.sleep(350);
        }
        System.out.println(message);

        Thread.sleep(2000);
    }

}
