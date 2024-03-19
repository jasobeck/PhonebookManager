// Jane Sobeck
// 2/16/2024
// Assignment 2: Phone Book
// CS 145 2958

//  The purpose of this java file is to hold the submenus for each user function, and to create
//and pass the ListNodes around

import java.util.Scanner;

public class PhonebookManager {

    public ListNode rootNode; // Creates the node that will be used as the root node in
                              // the linked list.

    // insertMenu manages where the user wants to place an entry in the linked list.
    public void insertMenu(Scanner userInput) {
        System.out.println("Where in the list would you like to add the entry?");
        System.out.println("    (B)eginning of the list");
        System.out.println("    (E)nd of the list");
        System.out.println("    At a (S)pecific index on the list");
        char selector = (userInput.nextLine().toLowerCase()).charAt(0);
        switch (selector) {
            case 'b':
                // When adding to beginning of list, sets the current rootNode as the next node
                // after
                // newly created node, then sets newly created node as the new rootNode
                ListNode newNode = createNode(userInput);
                newNode.next = rootNode;
                rootNode = newNode;
                break;
            case 'e':
                // sets the end node's 'next' to be the newly created node
                if (rootNode == null) {
                    rootNode = createNode(userInput);
                } else {
                    rootNode.append(createNode(userInput));
                }
                break;
            case 's':
                System.out.println("At which index?");
                int index = Integer.parseInt(userInput.nextLine());
                ListNode currentNode = rootNode;
                // for loop cycles through to node at desired index
                for (int i = 1; i < index - 1; i++) {
                    if (currentNode.isTail() || currentNode == null) { // checks if entry exists
                        System.out.println("Err: Index " + index + "is greater than size " + i);
                        currentNode = null;
                        break;
                    }
                    currentNode = currentNode.next;
                }
                if (currentNode != null) {
                    currentNode.insertAfter(createNode(userInput));
                }
                break;
            default:
                break;
        }
    }

    // deleteMenu manages the user's selection of which node to delete
    public void deleteMenu(Scanner userInput) {
        System.out.println("Where in the list would you like to delete an entry?");
        System.out.println("    (B)eginning of the list");
        System.out.println("    (E)nd of the list");
        System.out.println("    At a (S)pecific index on the list");
        char selector = (userInput.nextLine().toLowerCase()).charAt(0);
        switch (selector) {
            case 'b':
                rootNode = rootNode.next;
                break;
            case 'e':
                if (rootNode == null) {
                    System.out.println("Err: no entries in list");
                } else {
                    rootNode.trimTail();
                }
                break;
            case 's':
                System.out.println("At which index?");
                int index = Integer.parseInt(userInput.nextLine());
                ListNode currentNode = rootNode;
                currentNode = currentNode.getNodeAt(index - 1);
                if (currentNode == null) {
                    System.out.println("Index: " + index + " is greater than size of list");
                    break;
                }
                currentNode.removeNode();
                break;
            default:
                break;
        }
    }

    // prompts the user for which index to view the parameters of
    public void showMenu(Scanner userInput) {
        System.out.println("Which index would you like to view?");
        int index = Integer.parseInt(userInput.nextLine());
        var node = rootNode.getNodeAt(index);
        if (node != null) {
            displayNode(node);
        }
    }

    // takes the user specified index number, finds that specific node, and then
    // prompts the user for which bit of information to modify
    public void editMenu(Scanner userInput) {
        System.out.println("Which index would you like to modify?");
        int index = Integer.parseInt(userInput.nextLine());
        var node = rootNode.getNodeAt(index);
        if (node != null) {
            displayNode(node);
        } else {
            return;
        }
        System.out.println("Which field to modify?");
        System.out.println("    (F)irst name");
        System.out.println("    (L)ast name");
        System.out.println("    (A)ddress");
        System.out.println("    (C)ity");
        System.out.println("    (P)hone number");
        char selector = (userInput.nextLine().toLowerCase()).charAt(0);
        switch (selector) {
            case 'f':
                System.out.println("New First name?");
                String newFirst = userInput.nextLine();
                node.setFirst(newFirst);
                break;
            case 'l':
                System.out.println("New Last name?");
                String newLast = userInput.nextLine();
                node.setLast(newLast);
                break;
            case 'a':
                System.out.println("New Address?");
                String newAddress = userInput.nextLine();
                node.setAddress(newAddress);
                break;
            case 'c':
                System.out.println("New City?");
                String newCity = userInput.nextLine();
                node.setCity(newCity);
                break;
            case 'p':
                System.out.println("New Phone number?");
                String newPhone = userInput.nextLine();
                node.setPhone(newPhone);
                break;
            default:
                System.out.println("Please enter a valid selector next time");
                break;
        }
    }

    // Prints the information contained in a node to a single line
    public void displayNode(ListNode current) {
        System.out.print(current.getFirst() + " ");
        System.out.print(current.getLast() + ", ");
        System.out.print(current.getAddress() + ", ");
        System.out.print(current.getCity() + ", ");
        System.out.println(current.getPhone());
    }

    // Prompts the user for each bit of information when making a new entry
    // then sets each parameter for that node to the specified info
    public ListNode createNode(Scanner userInput) {
        System.out.println("First name?");
        String firstName = userInput.nextLine();
        System.out.println("Last name?");
        String lastName = userInput.nextLine();
        System.out.println("Address?");
        String address = userInput.nextLine();
        System.out.println("City?");
        String city = userInput.nextLine();
        System.out.println("Phone Number?");
        String phoneNumber = userInput.nextLine();

        return new ListNode(firstName, lastName, address, city, phoneNumber);
    }

    // Prints all entry nodes to console in order
    public void listAll() {
        ListNode currentNode = rootNode;
        int i = 0;
        while (currentNode != null) {
            System.out.print("(" + i + "): ");
            displayNode(currentNode);
            if (currentNode.next == null) {
                System.out.println();
                return;
            }
            currentNode = currentNode.next;
            i++;
        }
    }
}
