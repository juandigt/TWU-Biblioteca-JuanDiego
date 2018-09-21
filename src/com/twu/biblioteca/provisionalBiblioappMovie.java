/*
package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static com.twu.biblioteca.User.findUser;

public class BibliotecaApp {


    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        MainMenu app = new MainMenu();
        ArrayList<Book> libraryBooks = new ArrayList<Book>();

        Library library = new Library(libraryBooks, new HashMap<String, String>());
        library.fillLibrary();
        ArrayList<User> userlist = library.getUsers();

        int option;
        boolean userLogged = false;
        app.showWellcome();
        User currentUser = new User();
        while(!userLogged){
            app.loginMessage();
            String name = app.askUserName();
            String password = app.askPassword();
            currentUser = User.findUser(name, password, userlist);

            if (User.isCurrentUserEmpty(currentUser)){
                userLogged = false;
            }else{
                userLogged = User.login(name, password, currentUser );
            }

        }

        app.loginSuccessful();
        library.setCurrentUserLogged(currentUser);

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
                        app.noBooksToCheckout();
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
                        app.noBooksToReturn();
                    }
                    break;

                case 4:
                    if (library.userHasMovieToCheckout()) {
                        library.listOfMovieForCheckout();
                        app.printChooseMovieAction(option);
                        int idMovieToCheckout = userInput.nextInt();

                        if (library.validBook(idMovieToCheckout)) {
                            Movie movieSelectedToCheckout = library.findMovieInLibrary(idMovieToCheckout);
                            library.checkoutMovie(movieSelectedToCheckout);
                        } else {
                            app.showIncorrectMovie();
                        }
                    }else {
                        app.noMoviesToCheckout();
                    }
                    break;

                case 5:
                    if (library.userHasMovieToCheckout()) {
                        library.listOfMovieForCheckout();
                        app.printChooseMovieAction(option);
                        int idMovieToCheckout = userInput.nextInt();

                        if (library.validMovie(idMovieToCheckout)) {
                            Movie movieSelectedToCheckout = library.findMovieInLibrary(idMovieToCheckout);
                            library.checkoutBook(bookSelectedToCheckout);
                        } else {
                            app.showIncorrectBook();
                        }
                    }else {
                        app.noBooksToCheckout();
                    }
                    break;

                case 6:
                    app.printRegister(library);
                    break;
                case 7:
                    app.showGoodBye();
                    break;
            }

        }while (option != 7);

    }
}
*/
