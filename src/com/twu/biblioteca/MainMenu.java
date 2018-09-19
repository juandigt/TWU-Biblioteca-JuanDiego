package com.twu.biblioteca;

import java.util.Scanner;

public class MainMenu {

    private Scanner userInput;

    public MainMenu() {
        this.userInput = new Scanner(System.in);;
    }

    public void showMenu(){

        System.out.println("Choose one option");
        System.out.println("1. List \n2. Checkout a Book \n3. Return a Book \n4. Quit");

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

        return option == 1 || option == 2 || option == 3 || option == 4;
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





}
