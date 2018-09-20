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
        ArrayList<Book> libraryBooksToCheckout = new ArrayList<Book>();
        ArrayList<Book> libraryBooksToReturn = new ArrayList<Book>();

        Library library = new Library(libraryBooks, new HashMap<String, String>());
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

        }while (option != 5);

    }
}
