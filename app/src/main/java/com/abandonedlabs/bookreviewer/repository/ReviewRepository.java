package com.abandonedlabs.bookreviewer.repository;

import com.abandonedlabs.bookreviewer.model.MonthlyStatistics;
import com.abandonedlabs.bookreviewer.model.Review;
import com.abandonedlabs.bookreviewer.model.ReviewStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Review repository.
 */
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    /**
     * Find by book id list.
     *
     * @param bookId the book id
     * @return the list
     */
    List<Review> findByBookId(Long bookId);

    /**
     * Find by average list.
     *
     * @return the list
     */
    @Query("select round(avg(r.rating), 1) as rating, r.bookId as bookId from Review r group by r.bookId order by rating desc")
    List<ReviewStatistics> findByAverage();

    /**
     * Find monthly average by book id list.
     *
     * @param bookId the book id
     * @return the list
     */
    @Query("select to_char(r.createdDate, 'MM-yyyy') as month, round(avg(r.rating), 1) as rating, r.bookId as bookId from Review r where bookId = :bookId group by to_char(r.createdDate, 'MM-yyyy'), bookId order by to_char(r.createdDate, 'MM-yyyy') desc")
    List<MonthlyStatistics> findMonthlyAverageByBookId(@Param("bookId") Long bookId);

}
