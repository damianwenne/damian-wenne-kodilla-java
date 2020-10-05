package com.kodilla.patterns.library;

import com.kodilla.patterns.prototype.Prototype;

import java.util.HashSet;
import java.util.Set;

public final class Library extends Prototype {
    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return (Library)super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library cloneLibrary = (Library)super.clone();
        cloneLibrary.books = new HashSet<>();
            for (Book book: this.books) {
                Book cloneBook = new Book(book.getTitle(), book.getAuthor(), book.getPublicationDate());
                cloneLibrary.books.add(cloneBook);
            }

        return cloneLibrary;
    }
}
