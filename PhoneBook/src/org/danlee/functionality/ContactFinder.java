package org.danlee.functionality;

import org.danlee.models.PhoneBook;
import org.danlee.models.Person;

import java.util.Arrays;
import java.util.UUID;

public class ContactFinder {
//    private final PhoneBook phoneBook;
//
//    public ContactFinder(PhoneBook phoneBook) {
//        this.phoneBook = phoneBook;
//    }
//
//    public Person findOne() throws InterruptedException {
//
//        printContactFinderMenu();
//
//        phoneBook.getInput();
//
//        switch (phoneBook.currentInput()) {
//            case "1" -> {
//                System.out.println("Enter last name");
//                String lastName = phoneBook.getInput();
//
//                Person[] contacts = filterPersonsByCase("1", lastName);
//                printOutContacts(contacts);
//
//                for (int i = 0; i < contacts.length; i++) {
//                    System.out.println("Enter " + i + " for " + contacts[i].getFullName());
//                }
//
//                Integer selection = null;
//
//                while(selection == null) {
//                    try {
//                        String selectionInput = phoneBook.getInput();
//                        selection = Integer.parseInt(selectionInput);
//                    } catch (Exception e) {
//                        System.out.println("Please enter a number between 0 and " + (contacts.length - 1));
//                    }
//                }
//
//                return contacts[selection];
//            }
//            case "2" -> {
//                System.out.println("Enter first name");
//                String firstName = phoneBook.getInput();
//
//                Person[] contacts = filterPersonsByCase("1", firstName);
//                printOutContacts(contacts);
//
//
////                phonebook.getInput();
//            }
//            case "3" -> {}
//        }
//    }


//

//

//
//        return contacts;
//    }
//
//

}
