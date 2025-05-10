package com.book.review;

import com.book.review.model.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return reviewService.saveReview(review);
    }
}
