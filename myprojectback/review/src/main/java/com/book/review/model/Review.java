package com.book.review.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String reviewerName;
    private int rating;
    
    @Column(length = 1000)
    private String comment;
    
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReviewerName() {
		return reviewerName;
	}

	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Review(Long id, String reviewerName, int rating, String comment, Book book) {
		super();
		this.id = id;
		this.reviewerName = reviewerName;
		this.rating = rating;
		this.comment = comment;
		this.book = book;
	}
    
    public Review() {
    	
    	
    }
}
