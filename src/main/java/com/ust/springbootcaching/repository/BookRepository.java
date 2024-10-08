package com.ust.springbootcaching.repository;

import com.ust.springbootcaching.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
