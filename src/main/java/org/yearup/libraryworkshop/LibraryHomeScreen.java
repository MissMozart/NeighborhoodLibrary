package org.yearup.libraryworkshop;

import java.util.Scanner;

public class LibraryHomeScreen {

    // Welcome user and show home screen with available and checked out books
    public static void main(String[] args) {
        Scanner checkInOrOut = new Scanner(System.in);
        boolean done = false;
        while (done == false) {
            System.out.println("Welcome to the Neighborhood Library! \nHere are our available books: ");
            // Show ISBN and title
            Book[] books = BookInventory.allBooks;

            for (Book b : books) {
                if (b.isCheckedOut(true)) continue;
                System.out.println("Library ID: " + b.getId() + ", " + b.getTitle() + ", ISBN: " + b.getIsbn());
            }
            System.out.println("Here are the books that are currently checked out: ");
            for (Book b : books) {
                if (b.isCheckedOut(true)) System.out.print(b.getTitle() + " , ISBN: " + b.getIsbn() + ", checked out by "  + b.getCheckedOutTo());
            }

            // ask user if they want to check out, check in a book or exit
            System.out.printf("\nWould you like to 'check in' or 'check out' a book? \nyou can also exit by typing 'X'. \n");
            String userInput = checkInOrOut.nextLine();

            // If the user wants to check in a book
            if (userInput.equals("check in")) {
                Book.checkIn();
            }

            // If they want to check out a book
            else if (userInput.equals("check out")) {
                Book.checkOut();
            } else if (userInput.equals("X")) {
                System.out.println("Goodbye!");
                done = true;
            }
        }
    }
}


