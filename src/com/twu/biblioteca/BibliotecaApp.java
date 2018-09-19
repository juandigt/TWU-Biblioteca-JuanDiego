package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {


    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        MainMenu app = new MainMenu();
        ArrayList<Book> libraryBooks = new ArrayList<Book>();

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
                    if (library.hashBookCheckout()) {
                        library.listBooksForCheckout();
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
                    if (library.hashBookReturn()) {
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
                    app.showGoodBye();
                    break;
            }

        }while (option != 4);

    }
}
