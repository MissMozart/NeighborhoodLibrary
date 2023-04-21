package org.yearup.libraryworkshop;
import java.util.Scanner;
public class LibraryHomeScreen {


    public static void main(String[] args) {
        System.out.println("Welcome to the Neighborhood Library! \nHere are our available books: ");
        // Show ISBN and title
        Book[] booksToCheckOut = BookInventory.BooksToCheckOut;

        for (Book b : booksToCheckOut) {
            if (b.isCheckedOut()) continue;
            System.out.println("Library ID: " + b.getId() + ", " + b.getTitle() + ", ISBN: " + b.getIsbn());
        }
        System.out.println("Here are the books that are currently checked out: ");
        System.out.println();
        for (Book b : booksToCheckOut) {
            if (b.isCheckedOut()) System.out.print(b.getTitle() + " , ISBN: " + b.getIsbn());
        }

        Scanner scanner = new Scanner(System.in);
        boolean checkedOut = false;
        do {
            System.out.printf("Which book would you like to check out? (Type in title or ISBN) \nOr you can exit typing EXIT. \n");

            // Read users response
            String consoleInput = scanner.nextLine();

            String selectedTitle = consoleInput;
            String selectedIsbn = consoleInput;
            Book selectedBook = null;

            for (Book b : booksToCheckOut) {
                if (selectedTitle.equals(b.getTitle())) {
                    selectedBook = b;
                    System.out.println("What is your name?");
                    String name = scanner.nextLine();
                    Book.setCheckedOutTo(name);
                    checkedOut = true;
                    Book.setCheckedOut(true);
                    System.out.println("Ok, " + name + ", " + selectedTitle + " is now checked out.");
                    break;
                } else if (selectedIsbn.equals(b.getIsbn())) {
                    selectedBook = b;
                    System.out.println("What is your name?");
                    String name = scanner.nextLine();
                    Book.setCheckedOutTo(name);
                    checkedOut = true;
                    Book.setCheckedOut(true);
                    System.out.println("Ok, " + name + ", " + selectedTitle + " is now checked out.");
                    break;
                } else if (selectedTitle.equals("EXIT")) {
                    return;
                }
            }


        } while (!checkedOut);


    }
}
