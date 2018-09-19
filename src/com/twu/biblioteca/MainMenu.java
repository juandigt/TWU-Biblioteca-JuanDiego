package com.twu.biblioteca;

import java.util.Scanner;

public class MainMenu {

    public void showMenu(){

        System.out.println("Choose one option");
        System.out.println("1. List \n2. Checkout a Book \n3. Return a Book \n4. Quit");

    }

    public int readOption(){

        Scanner userInput = new Scanner(System.in);
                int option = userInput.nextInt();
                boolean result = checkOption(option);
                if (!result) {
                   showIncorrectOption();
                }
        return option;
    }

    public boolean checkOption(int option) {

        return option == 1 || option == 2 || option == 3 || option == 4;
    }

    public String showIncorrectOption() {

         String  s = new String ("You must select a correct option. (1, 2, 3 or 4)");
        return s;

    }

    public String showIncorrectBook() {

        String showIncorrectBookkMessage = new String("You must select a correct book from the list");
        return  showIncorrectBookkMessage;
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


    public void printProcessSuccess() {

        System.out.println("Process successful! Enjoy your book!\n");
    }

    public void printProcessNotSuccess() {

        System.out.println("Your process didn't works! Try again.\n");
    }




}
