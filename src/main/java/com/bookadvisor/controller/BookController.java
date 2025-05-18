package com.bookadvisor.controller;

import com.bookadvisor.dto.BookDto;
import com.bookadvisor.service.BookService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/search")
    public List<BookDto> search(@RequestParam String query) {
        return bookService.searchBooks(query);
    }
}