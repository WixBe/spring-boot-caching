package com.ust.springbootcaching.controller;

import com.ust.springbootcaching.domain.Book;
import com.ust.springbootcaching.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/")
    private ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok().body(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    private ResponseEntity<Optional<Book>> getBookById(@PathVariable long id) {
        return ResponseEntity.ok().body(bookService.getBookById(id));
    }

    @PostMapping("/")
    private ResponseEntity<Book> addBook(@RequestBody Book book) {
        return ResponseEntity.ok().body(bookService.addBook(book));
    }

    @PutMapping("/")
    private ResponseEntity<Book> updateBook(Book book) {
        return ResponseEntity.ok().body(bookService.upateBook(book));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<HttpStatus> deleteBook(@PathVariable long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }
}
