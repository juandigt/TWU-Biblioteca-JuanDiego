package com.twu.biblioteca;

import java.util.Scanner;

public class MainMenu {

    private Scanner userInput;

    public MainMenu() {
        this.userInput = new Scanner(System.in);;
    }

    public String readString() {
        return userInput.nextLine();
    }

    public void showMenu(){

        System.out.println("Choose one option");
        System.out.println("1. List \n2. Checkout a Book \n3. Return a Book \n4. Checkout a Movie \n5. Return a Movie \n6. Register \n 7. Quit");

    }

    public int readOption(){
        int option = userInput.nextInt();
        boolean result = checkOption(option);
        if (!result) {
           this.showIncorrectOption();
        }
        return option;
    }

    public boolean checkOption(int option) {

        return option == 1 || option == 2 || option == 3 || option == 4 || option == 5;
    }

    public void showIncorrectOption() {

        System.out.println("Incorrect option! You must select a correct option. (1, 2, 3 or 4)");

    }

    public void showIncorrectBook() {

        System.out.println("You must select a correct book from the list");

    }


    public void showWellcome() {

        System.out.println("Wellcome to La BIBLIOTECA");
    }

    public void showGoodBye() {

        System.out.println("Good Bye!");
    }

    public void printChooseBookAction(int option) {

        System.out.println("Choose the book you want " + userAction(option));
    }

    public String userAction(int option) {
        String action = new String();
        if (option == 2) {
            action = "checkout";
        }
        if (option == 3) {
            action = "return";
        }
        return action;
    }


    public void printProcessStatus(boolean status) {

        if(status) {
            System.out.println("Process successful! Enjoy your book!\n");
        }else {
            System.out.println("Your process didn't works! Try again.\n");
        }
    }

    public void loginMessage (){
        System.out.println("Please, login:");
    }

    public String askUserName(){
        System.out.println("Name: ");
        String name = readString();
        return  name;

    }

    public String askPassword(){
        System.out.println("Password: ");
        String password = readString();
        return  password;
    }

    public void loginSuccessful(){

        System.out.println("Login successful!");
    }

    public void printRegister(Library library){

        System.out.println(library.getRegister());
    }

    public void noBooksToCheckout(){
        System.out.println("No books to checkout");
    }
    public void noBooksToReturn(){
        System.out.println("No books to return");
    }
}
