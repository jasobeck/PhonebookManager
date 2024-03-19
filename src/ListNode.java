// Jane Sobeck
// 2/16/2024
// Assignment 2: Phone Book
// CS 145 2958

//The purpose of this java file is to represent a Node object in a linked list, and provide
//multiple functions to edit node data and to return important information(i.e. node is
// at end of linked list)

public class ListNode {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String phoneNumber;
    ListNode next;

    // Constructor method creates the entry with given parameters
    public ListNode(String firstName, String lastName,
            String address, String city, String phoneNumber) {
        this.next = null;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    // returns true if node is currently at the end of the linked list chain
    public boolean isTail() {
        return (this.next == null);
    }

    // Returns a new node that is placed after given node, first checks if node
    // exists
    public ListNode insertAfter(ListNode newNode) {
        if (isTail()) {
            this.next = newNode;
            return this.next;
        } else {
            newNode.next = this.next;
            this.next = newNode;
            return this.next;
        }
    }

    // Returns with the node at the specified index
    public ListNode getNodeAt(int index) {
        ListNode current = this;
        if (index == 0) {
            return current;
        }
        for (int i = 1; i <= index; i++) {

            // If index is greated than the size of the list, lets the user know
            if (current.isTail()) {
                System.out.println("Index: " + index + " is greater than size " + i);
                current = null;
                break;
            }

            current = current.next;
        }
        return current;
    }

    // Appends newly created node onto the end of the linked list chain
    public ListNode append(ListNode newTail) {
        return this.findTail().insertAfter(newTail);
    }

    // Returns the tail node of the Linked List chain
    public ListNode findTail() {
        ListNode current = this;
        while (!current.isTail()) {
            current = current.next;
        }
        return current;
    }

    // Removes the node at the end of the Linked
    public void trimTail() {
        ListNode current = this;
        while (!current.isTail()) {
            if (current.next != null && current.next.isTail()) {
                current.next = null;
                return;
            }
            current = current.next;
        }
    }

    // Removes the next node and connects the one after that to the current node
    public void removeNode() {
        this.next = this.next.next;
    }

    // Setter for first name data
    public void setFirst(String firstName) {
        this.firstName = firstName;
    }

    // Setter for last name data
    public void setLast(String lastName) {
        this.lastName = lastName;
    }

    // Setter for address data
    public void setAddress(String address) {
        this.address = address;
    }

    // Setter for city data
    public void setCity(String city) {
        this.city = city;
    }

    // Setter for phone number data
    public void setPhone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // getter for first name
    public String getFirst() {
        return this.firstName;
    }

    // getter for last name
    public String getLast() {
        return this.lastName;
    }

    public String getAddress() {
        return this.address;
    }

    // getter for city
    public String getCity() {
        return this.city;
    }

    // getter for phone number
    public String getPhone() {
        return this.phoneNumber;
    }

}