package com.abandonedlabs.bookreviewer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * The type Review dto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "id",
        "bookId",
        "rating",
        "review",
        "createdAt"
})
public class ReviewDTO implements Serializable {

    @Serial
    private final static long serialVersionUID = 1L;

    @JsonProperty("id")
    private Long id;

    @NotNull
    @Positive
    @JsonProperty("bookId")
    private Long bookId;

    @Min(value = 1, message = "Rating must be in the range of 1-5")
    @Max(value = 5, message = "Rating must be in the range of 1-5")
    @JsonProperty("rating")
    private Long rating;

    @JsonProperty("review")
    private String description;

    @JsonProperty("createdAt")
    private LocalDateTime createdAt;

    /**
     * Instantiates a new Review dto.
     */
    public ReviewDTO() {
    }

    /**
     * Instantiates a new Review dto.
     *
     * @param id          the id
     * @param bookId      the book id
     * @param rating      the rating
     * @param description the description
     * @param createdAt   the created at
     */
    public ReviewDTO(Long id, Long bookId, Long rating, String description, LocalDateTime createdAt) {
        this.id = id;
        this.bookId = bookId;
        this.rating = rating;
        this.description = description;
        this.createdAt = createdAt;
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static ReviewDTOBuilder getInstance() {
        return new ReviewDTOBuilder();
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
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

    /**
     * Gets created at.
     *
     * @return the created at
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets created at.
     *
     * @param createdAt the created at
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * The type Review dto builder.
     */
    public static class ReviewDTOBuilder {

        private Long id;
        private Long bookId;
        private Long rating;
        private String description;
        private LocalDateTime createdAt;

        /**
         * With id review dto builder.
         *
         * @param id the id
         * @return the review dto builder
         */
        public ReviewDTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        /**
         * With book id review dto builder.
         *
         * @param bookId the book id
         * @return the review dto builder
         */
        public ReviewDTOBuilder withBookId(Long bookId) {
            this.bookId = bookId;
            return this;
        }

        /**
         * With rating review dto builder.
         *
         * @param rating the rating
         * @return the review dto builder
         */
        public ReviewDTOBuilder withRating(Long rating) {
            this.rating = rating;
            return this;
        }

        /**
         * With description review dto builder.
         *
         * @param description the description
         * @return the review dto builder
         */
        public ReviewDTOBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        /**
         * With created at review dto builder.
         *
         * @param createdAt the created at
         * @return the review dto builder
         */
        public ReviewDTOBuilder withCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * Build review dto.
         *
         * @return the review dto
         */
        public ReviewDTO build() {
            return new ReviewDTO(id, bookId, rating, description, createdAt);
        }
    }

    @Override
    public String toString() {
        return "ReviewDTO{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
