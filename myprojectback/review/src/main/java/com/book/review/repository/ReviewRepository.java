package com.book.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.book.review.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
