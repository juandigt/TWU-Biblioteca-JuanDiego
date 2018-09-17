package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {

        MainMenu app = new MainMenu();
        ArrayList<Book> libraryBooks = new ArrayList<Book>();
        ArrayList<Book> userBooks = new ArrayList<Book>();

        Library library = new Library(libraryBooks, userBooks);
        library.fillLibrary();

        int option;
        app.showWellcome();

        do {
            app.showMenu();
            option = app.readOption();

            switch (option){
                case 1:
                    library.listBooks();
                    break;
                case 2:
                    library.listBooks();
                    int bookSelected = app.readOption();

                    library.checkoutBook(bookSelected);
                    app.showChooseBookAction();
                    break;
                case 3:
                    library.listBooksUser();
                    app.showChooseBookAction();
                    bookSelected = app.readOption();

                    library.returnBook(bookSelected);
                    break;
                case 4:
                    app.showGoodBye();
                    break;
            }

        }while (option != 4);


    }
}
