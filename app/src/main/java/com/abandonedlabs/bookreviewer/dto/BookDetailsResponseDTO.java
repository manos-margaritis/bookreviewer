package com.abandonedlabs.bookreviewer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * The type Book details response dto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "book",
        "rating",
        "reviews"
})
public class BookDetailsResponseDTO implements Serializable {

    @Serial
    private final static long serialVersionUID = 1L;

    @JsonProperty("book")
    private BookDTO bookDTO;
    @JsonProperty("rating")
    private Double rating;

    @JsonProperty("reviews")
    private List<String> reviews;

    /**
     * Instantiates a new Book details response dto.
     */
    public BookDetailsResponseDTO() {
    }

    /**
     * Instantiates a new Book details response dto.
     *
     * @param bookDTO the book dto
     * @param rating  the rating
     * @param reviews the reviews
     */
    public BookDetailsResponseDTO(BookDTO bookDTO, Double rating, List<String> reviews) {
        this.bookDTO = bookDTO;
        this.rating = rating;
        this.reviews = reviews;
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static BookDetailsResponseDTOBuilder getInstance() {
        return new BookDetailsResponseDTOBuilder();
    }

    /**
     * Gets book dto.
     *
     * @return the book dto
     */
    public BookDTO getBookDTO() {
        return bookDTO;
    }

    /**
     * Sets book dto.
     *
     * @param bookDTO the book dto
     */
    public void setBookDTO(BookDTO bookDTO) {
        this.bookDTO = bookDTO;
    }

    /**
     * Gets rating.
     *
     * @return the rating
     */
    public Double getRating() {
        return rating;
    }

    /**
     * Sets rating.
     *
     * @param rating the rating
     */
    public void setRating(Double rating) {
        this.rating = rating;
    }

    /**
     * Gets reviews.
     *
     * @return the reviews
     */
    public List<String> getReviews() {
        return reviews;
    }

    /**
     * Sets reviews.
     *
     * @param reviews the reviews
     */
    public void setReviews(List<String> reviews) {
        this.reviews = reviews;
    }

    /**
     * The type Book details response dto builder.
     */
    public static class BookDetailsResponseDTOBuilder {

        private BookDTO bookDTO;
        private Double rating;
        private List<String> reviews;

        /**
         * With book book details response dto builder.
         *
         * @param bookDTO the book dto
         * @return the book details response dto builder
         */
        public BookDetailsResponseDTOBuilder withBook(BookDTO bookDTO) {
            this.bookDTO = bookDTO;
            return this;
        }

        /**
         * With rating book details response dto builder.
         *
         * @param rating the rating
         * @return the book details response dto builder
         */
        public BookDetailsResponseDTOBuilder withRating(Double rating) {
            this.rating = rating;
            return this;
        }

        /**
         * With reviews book details response dto builder.
         *
         * @param reviews the reviews
         * @return the book details response dto builder
         */
        public BookDetailsResponseDTOBuilder withReviews(List<String> reviews) {
            this.reviews = reviews;
            return this;
        }

        /**
         * Build book details response dto.
         *
         * @return the book details response dto
         */
        public BookDetailsResponseDTO build() {
            return new BookDetailsResponseDTO(bookDTO, rating, reviews);
        }
    }
}