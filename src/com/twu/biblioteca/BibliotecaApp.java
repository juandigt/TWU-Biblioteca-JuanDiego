package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BibliotecaApp {


    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        MainMenu app = new MainMenu();
        ArrayList<Book> libraryBooks = new ArrayList<Book>();

        Library library = new Library(libraryBooks, new HashMap<String, String>());
        library.fillLibrary();

        int option;
        boolean userLogged = false;
        app.showWellcome();
        User user = new User();
        while(!userLogged){
            app.loginMessage();
            String name = app.askUserName();
            String password = app.askPassword();
            userLogged = user.login(name, password, library);
        }

        app.loginSuccessful();
        library.setCurrentUserLogged(user);

        do {
            app.showMenu();

            option = app.readOption();


            switch (option){
                case 1:
                    library.listOfBooks();
                    break;
                case 2:
                    if (library.userHasBookToCheckout()) {
                        library.listOfBooksForCheckout();
                        app.printChooseBookAction(option);
                        int idBookToCheckout = userInput.nextInt();

                        if (library.validBook(idBookToCheckout)) {
                            Book bookSelectedToCheckout = library.findBookInLibrary(idBookToCheckout);
                            library.checkoutBook(bookSelectedToCheckout);
                        } else {
                            app.showIncorrectBook();
                        }
                    }else {
                        System.out.println("No books to checkout");
                    }
                    break;

                case 3:
                    if (library.userHasBookToReturn()) {
                        library.listOfBooksForReturn();
                        app.printChooseBookAction(option);
                        int idBookToReturn = userInput.nextInt();
                        if (library.validBook(idBookToReturn)) {
                            Book bookSelectedToReturn = library.findBookInLibrary(idBookToReturn);
                            library.returnBook(bookSelectedToReturn);
                        } else {
                            app.showIncorrectBook();
                        }
                    }else {
                        System.out.println("No books to return");
                    }
                    break;
                case 4:
                    System.out.println(library.getRegister());
                    break;
                case 5:
                    app.showGoodBye();
                    break;
            }

        }while (option != 4);

    }
}
