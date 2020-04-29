package com.kodilla.zadania;

import java.util.LinkedList;
import java.util.HashMap;

class Book {

    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return title + author;
    }


    @Override
    public boolean equals(Object o) {
        Book book = (Book) o;
        return this.title.equals(book.title) && this.author.equals(book.author);
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }
}

class Application {
    public static void main(String[] args) {

        Book book1 = new Book(" ", " ");

        LinkedList<Book> theLinkedList = new LinkedList<Book>();

        for(int n=0; n<500000; n++)
        {
            theLinkedList.add(book1);
        }

        System.out.println("Initial Linked List size: " + theLinkedList.size());

        //first object removing
        long begin = System.nanoTime();
        theLinkedList.remove(0);
        long end = System.nanoTime();

        System.out.println("\nList size after removing first object: " + theLinkedList.size());
        System.out.println("Time taken to remove first object: " + (end - begin) + "ns");

        //last object removing
        begin = System.nanoTime();
        theLinkedList.remove(theLinkedList.size()-1);
        end = System.nanoTime();

        System.out.println(" \nList size after removing last object: " + theLinkedList.size());
        System.out.println("Time taken to remove last object: " + (end - begin) + "ns");

        //HashMap

        HashMap<Book, String> theMap = new HashMap<Book, String>();

        for(int i=0; i<500000; i++)
        {
            Book book2 = new Book("cool book" + i, "cool author");
            theMap.put(book2, "");
        }

        System.out.println("\nInitial HashMap size: " + theMap.size());

        // Getting key from HashMap
        begin = System.nanoTime();
        theMap.get("cool book325647");
        end = System.nanoTime();

        System.out.println("Time taken to find object in HashMap: " + (end - begin) + "ns\n");

        // Adding new entry to HashMap
        begin = System.nanoTime();
        for(int i=500000; i<500001; i++)
        {
            Book book2 = new Book("cool book" + i, "cool author");
            theMap.put(book2, "");
        }
        end = System.nanoTime();

        System.out.println("HashMap size: " + theMap.size());
        System.out.println("Time taken to add new entry to HashMap: " + (end - begin) + "ns");

        // Removing entry from HashMap
        begin = System.nanoTime();
        theMap.remove("cool book");
        end = System.nanoTime();

        System.out.println("\nHashMap size: " + theMap.size());
        System.out.println("Time taken to remove entry from HashMap: " + (end - begin) + "ns");

        System.out.println("Damian Wenne");

    }
}
