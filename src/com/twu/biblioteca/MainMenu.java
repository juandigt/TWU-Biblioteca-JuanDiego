package com.twu.biblioteca;

import java.util.Scanner;

public class MainMenu {

    public void showMenu(){

        System.out.println("Wellcome");

        System.out.println("choose one option");
        System.out.println("1. list \n 2. Checkout \n 3.Return \n 4. Quit");

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

    public boolean checkOption(int option){
        return option == 1 || option == 2 || option == 3 || option == 4;
    }

    public void showIncorrectOption() {
        System.out.println("You must select a correct option. (1, 2, 3 or 4)");
    }
    public void showGoodBye() {
        System.out.println("Good Bye!");
    }
}
