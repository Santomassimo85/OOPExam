package com.bookadvisor.factory;

import com.bookadvisor.dto.BookDto;

/**
 * Factory class for creating instances of {@link BookDto}.
 * <p>
 * Provides a static method to instantiate BookDto objects with the specified parameters.
 * </p>
 *
 * @author Your Name
 */
 
/**
 * Creates a new {@link BookDto} instance with the provided details.
 *
 * @param title the title of the book
 * @param author the author of the book
 * @param coverUrl the URL of the book's cover image
 * @param publishDate the publication date of the book
 * @param key a unique key identifying the book
 * @return a new instance of {@link BookDto} initialized with the given parameters
 */
public class BookDtoFactory {

    public static BookDto create(String title, String author, String coverUrl, String publishDate, String key) {
        return new BookDto(title, author, coverUrl, publishDate, key);
    }
}
