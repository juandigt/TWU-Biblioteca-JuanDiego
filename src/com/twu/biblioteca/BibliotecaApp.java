package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {

        MainMenu app = new MainMenu();

        int option;
        app.showWellcome();

        do {
            app.showMenu();
            ArrayList<Book> libraryBooks = new ArrayList<Book>();
            ArrayList<Book> userBooks = new ArrayList<Book>();

            Library library = new Library(libraryBooks, userBooks);
            library.fillLibrary();
            option = app.readOption();

            switch (option){
                case 1:
                    library.listBooks();
                    break;
                case 2:
                    library.listBooks();
                    int numberOfBooks = library.numberOfTotalBooks();
                    app.printChooseBookAction(option);
                    int bookSelected = app.bookSelected(numberOfBooks);

                    library.checkoutBook(bookSelected);
                    break;

                case 3:
                    library.listBooksUser();
                    int numberOfUserBooks = library.numberOfUserBooks();
                    app.printChooseBookAction(option);
                    bookSelected = app.bookSelected(numberOfUserBooks);

                    library.returnBook(bookSelected);
                    break;
                case 4:
                    app.showGoodBye();
                    break;
            }

        }while (option != 4);


    }
}
