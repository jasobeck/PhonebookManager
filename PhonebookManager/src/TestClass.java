// Jane Sobeck
// 2/16/2024
// Assignment 2: Phone Book
// CS 145 2958

//The purpose of this java file is to handle the base menu of user interaction in the first menu
//, to create the phonebook object and call it's methods.

import java.util.Scanner;

public class TestClass {

    // Main prints an intro message and runs the base menu method
    public static void main(String[] args) {
        System.out.println("Thank you for using the Phonebook program!");
        selectFunction();
    }

    // Prints function options to the console as a user readable menu
    public static void menu() {
        System.out.println("Please select an option:");
        System.out.println("    (A)dd an entry");
        System.out.println("    (S)how an entry");
        System.out.println("    (E)dit an entry");
        System.out.println("    (D)elete an entry");
        System.out.println("    (L)ist all entries");
        System.out.println("    (Q)uit the program");
    }

    // Creates the phonebook manager object and takes in user input to select which
    // function
    // to execute
    public static void selectFunction() {
        PhonebookManager book = new PhonebookManager();
        Scanner userInput = new Scanner(System.in);
        char selector = 0;
        while (selector != 'q') {
            menu();
            selector = (userInput.nextLine().toLowerCase()).charAt(0);
            switch (selector) {
                case 'a':
                    book.insertMenu(userInput);
                    break;
                case 's':
                    book.showMenu(userInput);
                    break;
                case 'e':
                    book.editMenu(userInput);
                    break;
                case 'l':
                    book.listAll();
                    break;
                case 'd':
                    book.deleteMenu(userInput);
                    break;
                case 'q':
                    System.out.println("See you next time!");
                    break;
                default:
                    System.out.println("Please enter a valid option!");
                    System.out.println();
                    break;
            }
        }
        userInput.close();
    }
}
