package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> libraryBooks;
    private ArrayList<Book> userBooks;


    public Library(ArrayList<Book> libraryBooks, ArrayList<Book> userBooks) {
        this.libraryBooks = libraryBooks;
        this.userBooks = userBooks;
    }

    public void fillLibrary (){
        this.libraryBooks = libraryBooks;
        this.userBooks = userBooks;
        libraryBooks.add(new Book("author1", "Book1", 1900));
        libraryBooks.add(new Book("author2", "Book2", 1901));
        libraryBooks.add(new Book("author3", "Book3", 1902));
        libraryBooks.add(new Book("author4", "Book4", 1903));

        userBooks.add(new Book("author5", "Book5", 1904));
    }


    public void listBooks() {

        for(int i =0; i<libraryBooks.size(); i++) {
            System.out.println("Book "+(i+1)+":"+libraryBooks.get(i));
        }
    }

    public void listBooksUser() {
        for(int i =0; i<userBooks.size(); i++) {
            System.out.println("Book "+(i+1)+":"+userBooks.get(i));
        }
    }

    public int numberOfTotalBooks() {

       return this.libraryBooks.size();

    }

    public int numberOfUserBooks() {

        return this.userBooks.size();

    }

    public void checkoutBook(int bookSelected) {

        bookSelected--;
        int UserListBeforeCheckout = numberOfTotalBooks();

        if (bookSelected < libraryBooks.size()){

            userBooks.add(libraryBooks.get(bookSelected));
            libraryBooks.remove(bookSelected);
            processSuccessful(UserListBeforeCheckout);

        } else {
            System.out.println("Your checkout didn't works! Try again.\n");
        }
    }

    public void returnBook(int bookSelected) {

        int UserListBeforeCheckout = numberOfUserBooks();
        if (bookSelected <= UserListBeforeCheckout){

            bookSelected--;
            libraryBooks.add(userBooks.get(bookSelected));
            userBooks.remove(bookSelected);
            processSuccessful(UserListBeforeCheckout);

        }  else {
            System.out.println("Your return didn't works! Try again.\n");
        }
    }

    public boolean processSuccessful(int UserListBeforeProcess) {
        boolean success = false;
        if (userBooks.size() != UserListBeforeProcess){
            System.out.println("Process successful! Enjoy your book!\n");
            return success = true;
        }else{
            System.out.println("Your process didn't works! Try again.\n");
            return success = false;
        }
    }
}
