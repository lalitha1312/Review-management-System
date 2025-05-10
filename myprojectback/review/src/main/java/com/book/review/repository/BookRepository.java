package com.book.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.book.review.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
