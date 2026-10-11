// Lesson 2: Classes, objects, ArrayList, enums and records
// Run with:  java Lesson2_Objects.java

import java.util.ArrayList;
import java.util.List;

public class Lesson2_Objects {

     // ---- An enum: a fixed set of named values (like a TS union "LOW" | "MEDIUM" | "HIGH") ----
    enum Priority {
        LOW,
        MEDIUM,
        HIGH,
    }

    // ---- A record: a short, immutable data class (Java 16+). Like a readonly TS type. ----
    // Java auto-generates the constructor, getters (name(), price()), equals and toString.
    // A record is a shortcut for one specific kind of class: a class that only holds data and never changes. Java writes most of the code for you.
    record Product(String name, double price, Priority priority) { }


     // ---- A class: a blueprint with fields (data) and methods (behaviour) ----
    static class Book {
        
        // "private" fields can only be touched inside this class (encapsulation)
        private final String title;
        private final String author;
        private final int pages;
        private boolean isRead;

        // Constructor: same name as the class, no return type
        Book(String title, String author, int pages) {
            this.title = title;
            this.author = author;
            this.pages = pages;
            this.isRead = false;
        }

        // "Getters" expose the private data in a controlled way
        String getTitle() {
            return title; 
        }
        boolean isRead() {
            return isRead; 
        }
        String getAuthor() {
            return author; 
        }

        int getPages() {
            return pages;
        }

        void markAsRead() {
            this.isRead = true;
        }

        // toString() is what gets printed when you print the object (like a custom .toString() in JS)
        // @Override tells the compiler: “this method replaces one I inherited from a parent class. Check that I got it right.”
        @Override 
        public String toString() {
            return (this.isRead ? "[x] " : "[] ") + title + " by " + this.author;
        }
        
    }

    public static void main(String[] args) {
        
        // ---- Creating objects with "new" ----
        System.out.println("=== Classes & objects ===");

        Book b1 = new Book("Clean code", "Robert C Martin", 300);
        Book b2 = new Book("Effective Java", "Joshua Bloch", 400);
        b2.markAsRead();
        System.out.println(b1);
        System.out.println(b2);


        // ---- ArrayList: a resizable list (the closest thing to a JS array) ----
        // List<Book> is a generic, just like Array<Book> / Book[] in TypeScript
        System.out.println("\n=== ArrayList ===");
        List<Book> library = new ArrayList<>();
        library.add(b1);
        library.add(b2);
        library.add(new Book("ABC", "NAME_abc", 100));

        System.out.println("Books in library: " + library.size());
        System.out.println("First book: " + library.get(0).getTitle());

        // Loop with index
        // "1. " + <Book object>
// You’re joining a String with an object, so Java needs that object as text. It calls the object’s toString() method automatically. That’s the method we overrode in Book:
        for (int i = 0; i < library.size(); i++) {
            System.out.println((i + 1) + ". " + library.get(i));
        }

         // ---- Lambdas and streams: Java's version of .filter / .map ----
        System.out.println("\n=== Streams (filter/map) ===");

        // .stream() turns the list into a stream: a pipeline that items flow through one at a time. You attach steps to the pipeline, and at the end you collect the results.
        List<String> unreadTitles = library.stream()
            .filter(book -> !book.isRead())
            .map(b -> b.getTitle())
            .toList();
        System.out.println("Unread: " + unreadTitles);

        library.removeIf(b -> b.isRead());              // remove every book that is read
        // library.removeIf(Book::isRead);      // same as above. Book::getTitle is shorthand for book -> book.getTitle().
        System.out.println("After removing read books: " + library.size() + " left");

        int totalPages = library.stream()
            .filter(book -> !book.isRead())
            .map(book -> book.getPages())
            .mapToInt(Integer::intValue)
            .sum();
        
        System.out.println("unread pages " + totalPages );


        // ---- Records and enums together ----
        System.out.println("\n=== Records & enums ===");
        Product laptop = new Product("Laptop",750000,Priority.HIGH);
        Product mouse = new Product("Mouse", 800.0, Priority.LOW);

        System.out.println(laptop);
        System.out.println(mouse.name() + " costs " + mouse.price());

        if (laptop.priority() == Priority.HIGH) {    // enums CAN be compared with ==
            System.out.println("Buy the " + laptop.name() + " first!");
        }
    }
}
