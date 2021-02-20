package singletondesignpattern;
/**
 * 
 * @author Rachael
 */
import java.util.*;
public class Library {

    private HashMap<String, Integer> books = new HashMap<String, Integer>();
    private static Library library;

    private Library() {}

    public static Library getInstance() {
        if (library == null) {
			System.out.println("Creating our Library: Time to begin reading");
			library = new Library();
		}
		return library;
    }

    public boolean checkoutBook(String bookName) {
        if (this.books.containsKey(bookName)) {
            int count = this.books.get(bookName);
            if (count == 0) {
                System.out.println("Sorry " + bookName + "is not in stock");
            } else {
                this.books.put(bookName, count--);
                System.out.println("" + bookName + " was successfully checked out");
                return true;
            }
        }
        return false;
    }
    
    public void checkInBook(String bookName, int numToAdd) {
        if(books.containsKey(bookName)) {
            int count = books.get(bookName);
            books.put(bookName, count + numToAdd);
        }
        else {
            books.put(bookName, numToAdd);
        }
        System.out.println("" + bookName + " added to the library");
    }
   

    public void displayBooks() {
        System.out.println("Inventory:");
        for (Map.Entry<String, Integer> entry : this.books.entrySet()) {
		    System.out.println(" -" + entry.getKey() + ": " + entry.getValue());
		}
    }

    
}