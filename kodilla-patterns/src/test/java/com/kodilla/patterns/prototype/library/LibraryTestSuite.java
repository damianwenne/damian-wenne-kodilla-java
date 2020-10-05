package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.library.Book;
import com.kodilla.patterns.library.Library;
import org.junit.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class LibraryTestSuite {
    @Test
    public void testGetBooks() {
        //Given
        Library library = new Library("Library 1");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> new Book("Book " + n, "Author " + n, LocalDate.now()));



    }
}
