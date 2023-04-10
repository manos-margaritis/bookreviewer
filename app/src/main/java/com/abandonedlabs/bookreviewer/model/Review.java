package com.abandonedlabs.bookreviewer.model;

import jakarta.persistence.*;

/**
 * The type Review.
 */
@Entity
@Table(name = "REVIEWS", schema = "public")
public class Review extends Auditable {

    private Long bookId;

    private Long rating;

    private String description;

    /**
     * Instantiates a new Review.
     */
    public Review() {
    }

    /**
     * Gets book id.
     *
     * @return the book id
     */
    public Long getBookId() {
        return bookId;
    }

    /**
     * Sets book id.
     *
     * @param bookId the book id
     */
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    /**
     * Gets rating.
     *
     * @return the rating
     */
    public Long getRating() {
        return rating;
    }

    /**
     * Sets rating.
     *
     * @param rating the rating
     */
    public void setRating(Long rating) {
        this.rating = rating;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
