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

    public void checkoutBook(int bookSelected) {

        bookSelected--;
        int UserListBeforeCheckout = userBooks.size();

        try {
            userBooks.add(libraryBooks.get(bookSelected));
        }
        catch (IndexOutOfBoundsException excepcion){

            System.out.println("Invalid option! Please choose une of the books listed " + (libraryBooks.size()-1));
        }

        libraryBooks.remove(bookSelected);
        checkoutSuccess(UserListBeforeCheckout);
    }

    public void checkoutSuccess (int UserListBeforeCheckout) {

        if (userBooks.size() != UserListBeforeCheckout){

            System.out.println("Checkout successful! Enjoy your book!\n");

        }else{

            System.out.println("Your checkout didn't works! Try again.\n");
        }
    }

    public void returnBook(int bookSelected) {
        bookSelected--;

        try{
            libraryBooks.add(userBooks.get(bookSelected));
        }
        catch (IndexOutOfBoundsException exception){
            System.out.println("Invalid option! Please choose une of the books"+(libraryBooks.size()-1) +  " listed");
        }

        userBooks.remove(bookSelected);
    }


}
