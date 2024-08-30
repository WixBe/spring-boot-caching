package com.ust.springbootcaching.service;

import com.ust.springbootcaching.domain.Book;
import com.ust.springbootcaching.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    public BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(long id) {
        return bookRepository.findById(id);
    }

    @Cacheable(value = "books", key = "#id", condition = "#id")
    public Book addBook(Book book) {
        return bookRepository.saveAndFlush(book);
    }

    public Book upateBook(Book book) {
        if (bookRepository.findById(book.getId()).isPresent()) {
            return bookRepository.saveAndFlush(book);
        } else {
            throw new RuntimeException("Book not found");
        }
    }

    public void deleteBook(long id) {
        if (bookRepository.findById(id).isPresent()) {
            bookRepository.deleteById(id);
        } else {
            throw new RuntimeException("Book not found");
        }
    }
}