package org.ICE24;
import java.util.Scanner;

public class Menu {
    //private String[] menuOptions;

    /*
    public Menu(String[] menuOptions) {
        this.menuOptions = menuOptions;
    }
     */
    public Menu() {

    }
    public static void showLoginMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
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
                    if (LoginService.login()) {
                        running = false;
                        showMainMenu();
                    }

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
    public static void showMainMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("\nWelcome");
            System.out.println("1. Browse Items");
            System.out.println("2. Add an item to your own UserShop!");
            System.out.println("3. View your items");
            System.out.println("4. Logout");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
            }

            switch (choice) {
                case 1:
                    UserShop.viewAllItems();
                    running = false;


                    break;

                case 2:

                    LoginService.getCurrentUser().shop.createItem();

                    break;
                case 3:

                    LoginService.getCurrentUser().shop.viewItems();

                    break;
                case 4:

                    running = false;
                    showLoginMenu();

                    break;

                default:
                    System.out.println("Not a valid option!");

            }


        }
    }

}
