package controllers;

import models.Address;
import models.PhoneBook;
import models.Person;

import java.util.Locale;

import models.PhoneNumber;
import views.InputView;
import views.OutputView;

public class PhoneBookController extends Controller {
    private final PhoneBook phoneBook;
    private final OutputView outputs = super.outputs;

    public PhoneBookController(PhoneBook phoneBook) throws InterruptedException {
        this.phoneBook = phoneBook;
    }

    public Person findOneAction(String option, String comparison) {
        outputs.printContactFinderMenu();
        Person[] filteredContacts = phoneBook.filterPersonsByCase(option, comparison);
        return outputs.choseOneContactFromArrayToPrint(filteredContacts);
    }

    public void findManyAction(String option, String comparison) throws InterruptedException {
        Person[] filteredContacts = phoneBook.filterPersonsByCase(option, comparison);
        outputs.printOutContacts(filteredContacts);
    }


    public void addPersonAction(Person newPerson) throws InterruptedException {
        phoneBook.addPerson(newPerson);
        outputs.loadAndPrint("Added contact!");
    }

    public void editPersonsAction(String option, String comparison) throws InterruptedException {
        InputView input = new InputView();

        Person person = findOneAction(option, comparison);
        if (person == null) {
            outputs.loadAndPrint("That person does not exist");
            return;
        }

        input.editPersonParams(person);
    }

    public void addPhoneNumberAction(PhoneNumber phoneNumber) {

    }
}
