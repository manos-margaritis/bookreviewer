package com.abandonedlabs.bookreviewer.dto;

import com.fasterxml.jackson.annotation.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * The type Book average dto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "rating",
        "month"
})
public class BookAverageDTO implements Serializable {

    @Serial
    private final static long serialVersionUID = 4161585919802398454L;

    @JsonProperty("rating")
    private Double rating;

    @JsonFormat(pattern = "MM-yyyy")
    @JsonProperty("month")
    private LocalDate month;

    /**
     * Instantiates a new Book average dto.
     */
    public BookAverageDTO() {
    }

    /**
     * Instantiates a new Book average dto.
     *
     * @param rating the rating
     * @param month  the month
     */
    public BookAverageDTO(Double rating, LocalDate month) {
        this.rating = rating;
        this.month = month;
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
     * Gets month.
     *
     * @return the month
     */
    public LocalDate getMonth() {
        return month;
    }

    /**
     * Sets month.
     *
     * @param month the month
     */
    public void setMonth(LocalDate month) {
        this.month = month;
    }
}
