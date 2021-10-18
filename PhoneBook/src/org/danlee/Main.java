package org.danlee;

import org.danlee.controllers.PhoneBookController;
import org.danlee.models.PhoneBook;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        PhoneBook phoneBook = new PhoneBook();
        PhoneBookController phoneBookController = new PhoneBookController(phoneBook);
    }
}


