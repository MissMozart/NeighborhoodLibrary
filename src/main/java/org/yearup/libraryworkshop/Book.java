package org.yearup.libraryworkshop;

import java.util.Scanner;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;
    private Scanner scanner;

    public Book(int id, String isbn, String title, boolean isCheckedOut, String checkedOutTo) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut(boolean b) {
        return isCheckedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public static void main(String[] args) {

    }

    public static void checkOut() {
        Scanner scanner = new Scanner(System.in);
        boolean checkedOut = false;
        String consoleInput;
        do {
            System.out.printf("Which book would you like to check out? (Type in title or ISBN) \nOr you can exit typing 'X'. \n");

            // Read users response
            consoleInput = scanner.nextLine();

            Book[] booksToCheckOut = BookInventory.allBooks;

            String selectedTitle = consoleInput;
            String selectedIsbn = consoleInput;
            Book selectedBook = null;
            //match input to book title
            for (Book b : booksToCheckOut) {
                if (selectedTitle.equals(b.getTitle())) {
                    selectedBook = b;
                    System.out.println("What is your name?");
                    String name = scanner.nextLine();
                    selectedBook.setCheckedOutTo(name);
                    selectedBook.setCheckedOut(true);
                    System.out.println("Ok " + name + ", " + selectedTitle + " is now checked out.");
                    break;
                    // match input to ISBN
                } else if (selectedIsbn.equals(b.getIsbn())) {
                    selectedBook = b;
                    System.out.println("What is your name?");
                    String name = scanner.nextLine();
                    selectedBook.setCheckedOutTo(name);
                    selectedBook.setCheckedOut(true);
                    System.out.println("Ok, " + name + ", " + selectedTitle + " is now checked out.");
                    break;
                }

            }

        } while (!consoleInput.equals("X"));

    }

    public static void checkIn() {
        Scanner scanner = new Scanner(System.in);
        Book[] books = BookInventory.allBooks;

        System.out.printf("Which book would you like to check in? (Type in title)\nOr you can exit typing 'X'.\n");

        String bookInput = scanner.nextLine();
        if (bookInput.equals("X")) {
            System.out.println("Goodbye!");
            return;
        }

        // match inputted Title to .getTitle()
        for (Book bb : books) {
            if (bookInput.equals(bb.getTitle())) {
                bb.setCheckedOut(false);
                bb.setCheckedOutTo("");
                System.out.println(bb.getTitle() + " was successfully checked in!");
                break;
            }

        }
    }
}


