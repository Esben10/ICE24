package org.ICE24;
import java.util.Scanner;

public class Menu {
    //private String[] menuOptions;
    public boolean running;

    /*
    public Menu(String[] menuOptions) {
        this.menuOptions = menuOptions;
    }
     */

    public Menu() {

    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        this.running = true;
        while (this.running) {
            System.out.println("\nMenu");
            System.out.println("1. Login");
            System.out.println("2. Create user");
            System.out.println("3. Exit");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
            }

            switch (choice){
                case 1:
                    //login();
                    break;
                case 2:
                    LoginService.createUser();
                    break;
                case 3:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Not a valid option!");

            }


        }
    }
}
