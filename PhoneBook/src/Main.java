import controllers.PhoneBookController;
import models.PhoneBook;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        PhoneBook phoneBook = new PhoneBook();
        PhoneBookController phoneBookController = new PhoneBookController(phoneBook);
    }
}


