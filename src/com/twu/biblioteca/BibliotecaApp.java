package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {

        MainMenu app = new MainMenu();
        Library library = new Library();

        int option;
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

                    library.checkout(bookSelected);
                    break;
                case 3:
                    library.listBooksUser();
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
