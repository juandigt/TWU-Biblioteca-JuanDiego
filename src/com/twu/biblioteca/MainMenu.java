package com.twu.biblioteca;

import java.util.Scanner;

public class MainMenu {

    public void showMenu(){

        System.out.println("Choose one option");
        System.out.println("1. List \n2. Checkout a Book \n3. Return a Book \n4. Quit");

    }

    public int readOption(){
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        boolean result = checkOption(option);
        if (!result) {
            showIncorrectOption();
        }

        return option;
    }

    public boolean checkOption(int option) {

        return option == 1 || option == 2 || option == 3 || option == 4;
    }


    public void showIncorrectOption() {

        System.out.println("You must select a correct option. (1, 2, 3 or 4)");
    }

    public void showWellcome() {

        System.out.println("Wellcome to La BIBLIOTECA");
    }

    public void showGoodBye() {

        System.out.println("Good Bye!");
    }

    public void showChooseBookAction() {

        System.out.println("Choose the book you want " + userAction());
    }

    public String userAction() {
        String action = new String();
        if (readOption() == 2){
            action = "checkout";
        }
        if (readOption() == 3){
            action = "return";
        }
        return action;

    }
}
