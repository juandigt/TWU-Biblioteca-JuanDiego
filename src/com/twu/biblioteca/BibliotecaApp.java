package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {


    public static void main(String[] args) {

        MainMenu app = new MainMenu();
        ArrayList<Book> libraryBooks = new ArrayList<Book>();
        ArrayList<Book> libraryBooksToReturn = new ArrayList<Book>();

        Library library = new Library(libraryBooks);
        library.fillLibrary();

        int option;
        app.showWellcome();

        do {
            app.showMenu();

            option = app.readOption();


            switch (option){
                case 1:
                    library.listOfBooks();
                    break;
                case 2:

                    library.listBooksForCheckout();
                    app.printChooseBookAction(option);
                    int idToCheckout = library.bookSelected();
                    Book bookSelectedToCheckout = library.findBookInLibrary(idToCheckout);
                    library.checkoutBook(bookSelectedToCheckout);
                    break;

                case 3:
                    library.listOfBooksForReturn();
                    app.printChooseBookAction(option);
                    int idToReturn = library.bookSelected();
                    Book bookSelectedToReturn = library.findBookInLibrary(idToReturn);
                    library.returnBook(bookSelectedToReturn);
                  break;
                case 4:
                    app.showGoodBye();
                    break;
            }

        }while (option != 4);

    }
}
