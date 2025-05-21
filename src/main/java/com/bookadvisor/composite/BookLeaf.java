package com.bookadvisor.composite;

import com.bookadvisor.dto.BookDto;
import java.util.ArrayList;
import java.util.List;


/**
 * The {@code BookLeaf} class represents a leaf node in the Composite design pattern.
 * It contains a single {@link BookDto} object and provides methods to display its details
 * and convert it to a list of {@code BookDto} objects.
 *
 * This class is a concrete implementation of {@link BookComponent} and does not support
 * adding or removing child components.
 * 
 * @author: Luca Santomassimo
 */

public class BookLeaf extends BookComponent {

    // The BookDto object representing the book (leaf node)
    private BookDto book;

    /**
     * Constructs a BookLeaf with the specified BookDto.
     * @param book the BookDto object to be wrapped by this leaf
     */

    public BookLeaf(BookDto book) {
        this.book = book;
    }

    /**
     * Returns the title of the book.
     * @return the book title
     */

    @Override
    public String getTitle() {
        return book.getTitle();
    }

    /**
     * Displays the book's title to the standard output.
     */
    
    @Override
    public void display() {
        System.out.println("Libro: " + book.getTitle());
    }

    /**
     * Converts this leaf to a list containing its BookDto.
     * @return a list with a single BookDto element
     */
    @Override
    public List<BookDto> toBookDtoList() {
        List<BookDto> list = new ArrayList<>();
        list.add(book);
        return list;
    }
}