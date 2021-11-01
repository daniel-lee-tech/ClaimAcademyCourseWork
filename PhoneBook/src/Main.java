import views.*;
import controllers.PhoneBookController;
import models.Person;
import models.PhoneBook;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        InputView inputs = new InputView();
        OutputView outputs = new OutputView();
        PhoneBook phoneBook = new PhoneBook();

        while (!inputs.currentInput().equals("exit")) {
            switch (inputs.currentInput()) {
                case "print all" -> {
                    outputs.printAllContacts(phoneBook.getPersons());
                    inputs.setCurrentInput("RESTARTING PROGRAM");
                }

                case "add entry" -> {
                    Person newPerson = inputs.getEntryParams();
                    PhoneBookController phoneBookController = new PhoneBookController(phoneBook);
                    phoneBookController.addPersonAction(newPerson);
                }

                case "add many entries" -> {
                    Person[] persons = inputs.getManyPersonsParams();
                    PhoneBookController phoneBookController = new PhoneBookController(phoneBook);


                    for (Person person: persons) {
                        phoneBookController.addPersonAction(person);
                    }
                }

                case "add new" -> {
                    Person newPerson = inputs.getPersonParams();
                    PhoneBookController phoneBookController = new PhoneBookController(phoneBook);
                    phoneBookController.addPersonAction(newPerson);
                }

                case "find one" -> {
                    outputs.printContactFinderMenu();
                    String[] params = inputs.getFindManyContactsParams();
                    PhoneBookController phoneBookController = new PhoneBookController(phoneBook);
                    phoneBookController.findOneAction(params[0], params[1]);
                }

                case "find many" -> {
                    outputs.printContactFinderMenu();
                    String[] params = inputs.getFindManyContactsParams();
                    new PhoneBookController(phoneBook).
                            findManyAction(params[0], params[1]);
                }

                case "edit" -> {
                    outputs.printContactFinderMenu();
                    String[] params = inputs.getFindManyContactsParams();
                    PhoneBookController phoneBookController = new PhoneBookController(phoneBook);
                    phoneBookController.editPersonsAction(params[0], params[1]);
                }

                case "add phone number" -> {
                    outputs.printContactFinderMenu();
                    String[] params = inputs.getFindManyContactsParams();
                    PhoneBookController phoneBookController = new PhoneBookController(phoneBook);
                    Person person = phoneBookController.findOneAction(params[0], params[1]);

                    if (person == null) {
                        outputs.loadAndPrint("That person does not exist");
                    } else {
                        person = inputs.setPhoneNumberProcess(person);
                    }
                }

                case "delete" -> {
                    outputs.printContactFinderMenu();
                    String[] params = inputs.getFindManyContactsParams();
                    PhoneBookController phoneBookController = new PhoneBookController(phoneBook);
                    Person person = phoneBookController.findOneAction(params[0], params[1]);
                    if (person == null) {
                        outputs.loadAndPrint("Person does not exist");
                    } else {
                        phoneBook.deletePerson(person);
                    }
                }

                default -> {
                    outputs.printMainMenu();
                    inputs.getInput();
                }
            }
        }
    }
}


