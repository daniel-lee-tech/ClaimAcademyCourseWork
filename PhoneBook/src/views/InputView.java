package views;

import java.util.Locale;
import java.util.Scanner;

import models.*;

public class InputView {
    private final Scanner in = new Scanner(System.in);
    private String input = "";

    public String getInput() {
        this.input = in.nextLine();
        if (input.equals("exit")) {
            System.exit(0);
        }

        return input;
    }

    public String currentInput() {
        return input;
    }

    public void setCurrentInput(String string) {
        this.input = string;
    }


    public String[] getFindManyContactsParams() {
        String option = getInput();

        System.out.println("Enter in the value of your query (ex, last name or phone number.. etc..)");

        String comparison = getInput();

        return new String[] {option, comparison};
    }


    public String getQueryValue() {
        System.out.println("Enter in the value of your query (ex, last name or phone number.. etc..)");
        return getInput();
    }

    public Person[] getManyPersonsParams() {
        Person[] persons = new Person[1];

        System.out.println("Enter many addresses in this format: ");

        // copy and paste from lab docx file
        String example = "John Doe, 114 Market St, St Louis, MO, 63403, 6366435698\n" +
                "\n" +
                "John E Doe, 324 Main St, St Charles, MO,63303, 8475390126\n" +
                "\n" +
                "John Michael West Doe, 574 Pole ave, St. Peters, MO, 63333, 5628592375";

        System.out.println(example);

        System.out.println("\n One mistake will invalidate the whole entry");
        System.out.println("Please type `done` when you're complete entering in all your entries.");

        StringBuilder entries = new StringBuilder();

        String input = getInput();

        while (!input.equals("done")) {
            entries.append(input);
            entries.append("&"); // this gets appended twice because of the double \n from the docx file
            input = getInput();
        }

        String[] entriesArray = entries.toString().split("&&");

        for (String entry: entriesArray) {
            System.out.println(entry);
        }

//        System.out.println(entries);
        return persons;
    }

    public Person getEntryParams() {
        System.out.println("Please copy and paste an entry");
        String entry = getInput();

        String[] entryArr = entry.split(", ");

        String fullName = entryArr[0];
        String address1 = entryArr[1];
        String city = entryArr[2];
        String state = entryArr[3];
        String zipString = entryArr[4];
        String phoneNumber = entryArr[5];
        Person person = new Person(fullName);
        Address address = new Address(address1, "", city, state, Integer.parseInt(zipString));
        person.setAddress(address);

        PhoneNumber phoneNumberObject;
        phoneNumberObject = new PhoneNumber(person, Long.parseLong(phoneNumber), NumberType.CELL);
        person.addPhoneNumber(phoneNumberObject);
        return person;
    }

    public Person getPersonParams() {
        System.out.println("Enter full name: ");
        String fullName = getInput();

        Person person = new Person(fullName);

        System.out.println("Do you want to add an address?, Enter y for yes");

        String answer = getInput().toLowerCase(Locale.ROOT);

        if (answer.equals("y")) {
           Address address = getAddressParams();
           person.setAddress(address);
        }

        System.out.println("Do you want to add phone numbers?, Enter y for yes");

        String phoneNumberAnswer = getInput().toLowerCase(Locale.ROOT);

        if (phoneNumberAnswer.equals("y")) {
            setPhoneNumberProcess(person);
        }

        return person;
    }

    public Address getAddressParams() {
        System.out.println("Enter address 1: ");
        String address1 = getInput();
        System.out.println("Enter address 2: ");
        String address2 = getInput();
        System.out.println("Enter city: ");
        String city = getInput();
        System.out.println("Enter state");
        String state = getInput();
        System.out.println("Enter zipcode");
        String zipcodeString = getInput();
        int zipcode = -1;
        try {
            zipcode = Integer.parseInt(zipcodeString);
        } catch (Exception exception) {
            System.out.println("Invalid zipcode, defaulting to value -1");
            System.out.println("Please update zipcode at a later time");
        }

        return new Address(address1,address2,city,state,zipcode);
    }

    public Person editPersonParams(Person person) {
        System.out.println("Full name is: " + person.getFullName());
        System.out.println("To edit input in a new value, to not edit please just press enter:");
        String fullName = getInput();


        if (!fullName.isEmpty()) person.setFullName(fullName);

        Address address = person.getAddress();

        if (address == null) {
            System.out.println("There is no address for this person, do you want to add an address? y for yes: ");
            String answer = getInput().toLowerCase(Locale.ROOT);

            if (!answer.equals("y")) return person;
        };

        person.setAddress(getAddressParams());
        return person;
    }

    public Person setPhoneNumberProcess(Person person) {
        String phoneNumberAnswer = "";
        do {
            System.out.println("Enter phone number: ");
            String phoneNumberString = getInput();
            long phoneNumber = -1;

            try {
                phoneNumber = Long.parseLong(phoneNumberString);
            } catch (Exception exception) {
                System.out.println("Bad phone number input, phone number will not be saved, to add a phone number, edit this contact");
                break;
            }

            System.out.println("Please enter phone number type: ");
            System.out.println("0 for CELL");
            System.out.println("1 for HOME");
            System.out.println("2 for FAX");
            System.out.println("3 for WORK");

            String typeInput = getInput();
            NumberType nt = null;

            switch (typeInput){
                case "0" -> nt = NumberType.CELL;
                case "1" -> nt = NumberType.HOME;
                case "2" -> nt = NumberType.FAX;
                case "3" -> nt = NumberType.WORK;
                default -> {
                    nt = NumberType.CELL;
                    System.out.println("Invalid type, will default to CELL");
                }
            }

            PhoneNumber pn = new PhoneNumber(person, phoneNumber, nt);
            person.addPhoneNumber(pn);
            System.out.println("Added phone number: " + pn.formattedPhoneNumber());
            System.out.println("Add another phone number? y for yes");
            phoneNumberAnswer = getInput().toLowerCase(Locale.ROOT);
        } while (phoneNumberAnswer.equals("y"));
        return person;
    }
}