package singletondesignpattern;
/**
 * this singleton class is an instance of a library that has method to control the books in it
 * @author Rachael
 */
import java.util.*;
public class Library {

    private HashMap<String, Integer> books = new HashMap<String, Integer>(); //a hash map that contains the books and the number of copies of each book
    private static Library library; //static instance of the library class, doesn't need an instance of the class to access

    /**
     * the constructor method is private so that a new library can't be added in another class, only one instance
     */
    private Library() {} 

    /**
     * static method that creates the instance of library and prints that the library is being created
     * @return instance of library
     */
    public static Library getInstance() {
        if (library == null) {
			System.out.println("Creating our Library: Time to begin reading");
			library = new Library();
		}
		return library;
    }

    /**
     * method that checks a book out and removes it from the hashmap 
     * @param bookName the name of the book to remove
     * @return returns true if the book was checked out and false if it wasn't in the hashmap or there weren't any copies left
     */
    public boolean checkoutBook(String bookName) {
        if (this.books.containsKey(bookName)) {
            int count = this.books.get(bookName);
            if (count <= 0) {
                System.out.println("Sorry " + bookName + " is not in stock");
            } else {
                this.books.put(bookName, count-1);
                System.out.println("" + bookName + " was successfully checked out");
                return true;
            }
        }
        return false;
    }
    
    /**
     * method to add a new book to the hashmap of books
     * @param bookName the name of the book to add
     * @param numToAdd the number of copies of books to add
     */
    public void checkInBook(String bookName, int numToAdd) {
        if(books.containsKey(bookName)) {
            int count = books.get(bookName);
            books.put(bookName, count + numToAdd);
            System.out.println("A new copy of " + bookName + " was added to the library");
        }
        else {
            books.put(bookName, numToAdd);
            System.out.println("" + bookName + " was added to the library");
        }
    }
   
    /**
     * traverses through the hashmap of books and prints each with its key and value
     */
    public void displayBooks() {
        System.out.println("\nInventory:");
        for (Map.Entry<String, Integer> entry : this.books.entrySet()) {
		    System.out.println(" -" + entry.getKey() + ", copies: " + entry.getValue());
		}
    }

    
}