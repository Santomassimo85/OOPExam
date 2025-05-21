package com.bookadvisor.controller;

import com.bookadvisor.dto.BookDto;
import com.bookadvisor.service.BookService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST controller for managing books.
 * Provides endpoints for searching books.
 * 
 * @author Luca Santomassimo
 */

@RestController
@RequestMapping("/api/books")
public class BookController {
    
    // Service layer dependency for book-related operations
    private final BookService bookService;

    /**
     * Constructor for dependency injection of BookService.
     * @param bookService the service used to handle book operations
     */

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Endpoint to search for books by a query string.
     * Example: GET /api/books/search?query=java
     *
     * @param query the search string provided by the user
     * @return a list of BookDto objects matching the search query
     * @throws IllegalArgumentException if the query is null or empty
     */

    @GetMapping("/search")
    public List<BookDto> search(@RequestParam String query) {
        // Validate the search query
        if (query == null || query.trim().isEmpty()) {
            throw new IllegalArgumentException("La query di ricerca non può essere vuota");
        }
        // Delegate the search to the service layer
        return bookService.searchBooks(query.trim());
    }
}