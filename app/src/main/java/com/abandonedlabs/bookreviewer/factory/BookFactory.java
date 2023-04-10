package com.abandonedlabs.bookreviewer.factory;

import com.abandonedlabs.bookreviewer.dto.BookAverageDTO;
import com.abandonedlabs.bookreviewer.dto.ReviewDTO;
import com.abandonedlabs.bookreviewer.model.MonthlyStatistics;
import com.abandonedlabs.bookreviewer.model.Review;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

/**
 * The type Book factory.
 */
@Component
public class BookFactory {

    /**
     * To review dto review dto.
     *
     * @param review the review
     * @return the review dto
     */
    public ReviewDTO toReviewDTO(Review review) {
        return ReviewDTO.getInstance()
                .withId(review.getId())
                .withBookId(review.getBookId())
                .withRating(review.getRating())
                .withDescription(review.getDescription())
                .withCreatedAt(review.getCreatedDate())
                .build();
    }

    /**
     * From review dto review.
     *
     * @param reviewDTO the review dto
     * @return the review
     */
    public Review fromReviewDTO(ReviewDTO reviewDTO) {
        Review review = new Review();
        review.setBookId(reviewDTO.getBookId());
        review.setRating(reviewDTO.getRating());
        review.setDescription(reviewDTO.getDescription());
        return review;
    }

    /**
     * To book average dto book average dto.
     *
     * @param monthlyStatistics the monthly statistics
     * @return the book average dto
     */
    public BookAverageDTO toBookAverageDTO(MonthlyStatistics monthlyStatistics) {
        return new BookAverageDTO(monthlyStatistics.getRating(), LocalDate.parse(monthlyStatistics.getMonth(), new DateTimeFormatterBuilder()
                .appendPattern("MM-yyyy")
                .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
                .toFormatter()));
    }

}
