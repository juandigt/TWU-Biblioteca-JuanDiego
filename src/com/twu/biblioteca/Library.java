package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    private ArrayList<Book> libraryBooks;
    MainMenu app = new MainMenu();


    public Library() {
    }

    public Library(ArrayList<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public void fillLibrary() {

        libraryBooks.add(new Book("author2", "Book2", 1920, 1));
        libraryBooks.add(new Book("author2", "Book2", 1901, 2));
        libraryBooks.add(new Book("author3", "Book3", 1902, 3));
        libraryBooks.add(new Book("author4", "Book4", 1903, 4));
    }


    public void listOfBooks () {
        for (int i = 0; i < libraryBooks.size(); i++) {
            System.out.println("Book " + (i + 1) + ":" + libraryBooks.get(i));
        }

    }

    public void listBooksForCheckout() {

        List<Book> availableBooks = new ArrayList<Book>();
        for (Book book : libraryBooks) {
            if (!book.getCheckout()) {
                availableBooks.add(book);
            }
        }
        for (int i = 0; i < availableBooks.size(); i++) {
            System.out.println("Book " + (i + 1) + ":" + availableBooks.get(i));
        }
    }


//    public List<Book> listOfBooksForReturn() {

//        List<Book> booksToReturn = new ArrayList<Book>();
//        for (Book book : libraryBooks) {
//            if (book.getCheckout()) {
//                booksToReturn.add(book);
//            }
////        }
//        for (int i = 0; i < booksToReturn.size(); i++) {
//            System.out.println("Book " + (i + 1) + ":" + booksToReturn.get(i));
//    }


//    public void listBooksForReturn() {
//
//        for (int i = 0; i < libraryBooks.size(); i++) {
//            System.out.println("Book " + (i + 1) + ":" + libraryBooks.get(i));
//        }
//    }
//
//
    public int bookSelected() {

        Scanner itemSelected = new Scanner(System.in);
        int idBookSelected = itemSelected.nextInt();

        if (idBookSelected > libraryBooks.size()) {
            app.showIncorrectBook();
        }
        return idBookSelected - 1;
    }
//
//    public boolean checkBookInBookList(int option, int numberOfBooks) {
//
//        if (option <= numberOfBooks) {
//            return true;
//        } else {
//            return false;
//        }
//
//    }

    public Book findBookInLibrary(int bookSelected) {
        Book book = new Book();

        for (int i = 0; i < libraryBooks.size(); i++) {
            if (libraryBooks.get(i).getId() == bookSelected) {
                book = libraryBooks.get(i);
            }
        }
        return book;
    }

    public void checkoutBook(Book book) {
        book.setCheckout();
       checkoutSuccessful(book);

    }

    public boolean checkoutSuccessful(Book book) {

        if (libraryBooks.contains(book) && book.getCheckout()) {
            app.printProcessSuccess();
            return true;
        } else {
            app.printProcessNotSuccess();
            return false;
        }
    }

    public void returnBook(Book book) {
        book.setReturnBook();
        retournSuccessful(book);
    }
//
//    public void returnBook(int bookSelected) {
//
//        int UserListBeforeCheckout = numberOfUserBooks();
//        if (bookSelected <= UserListBeforeCheckout){
//
//            bookSelected--;
//            libraryBooks.add(userBooks.get(bookSelected));
//            userBooks.remove(bookSelected);
//            processSuccessful(UserListBeforeCheckout);
//
//        }  else {
//            System.out.println("Your return didn't works! Try again.\n");
//        }
//    }


//
//
    public void retournSuccessful(Book book) {

        for( int i =0; i<libraryBooks.size(); i++){
            if (libraryBooks.get(i).getId() == book.getId() &&  !book.getCheckout()){
                app.printProcessSuccess();
            } else {
                app.printProcessNotSuccess();
            }
        }
    }
}