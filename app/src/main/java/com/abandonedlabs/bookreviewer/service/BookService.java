package com.abandonedlabs.bookreviewer.service;

import com.abandonedlabs.bookreviewer.client.GutendexClient;
import com.abandonedlabs.bookreviewer.dto.*;
import com.abandonedlabs.bookreviewer.factory.BookFactory;
import com.abandonedlabs.bookreviewer.model.MonthlyStatistics;
import com.abandonedlabs.bookreviewer.model.Review;
import com.abandonedlabs.bookreviewer.model.ReviewStatistics;
import com.abandonedlabs.bookreviewer.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The type Book service.
 */
@Service
public class BookService {

    private final static Logger logger = LoggerFactory.getLogger(BookService.class);

    private GutendexClient gutendexClient;

    private ReviewRepository repository;

    private BookFactory factory;

    /**
     * Instantiates a new Book service.
     *
     * @param gutendexClient the gutendex client
     * @param repository     the repository
     * @param factory        the factory
     */
    @Autowired
    public BookService(GutendexClient gutendexClient,
                       ReviewRepository repository,
                       BookFactory factory) {
        this.gutendexClient = gutendexClient;
        this.repository = repository;
        this.factory = factory;
    }

    /**
     * Gets books by title.
     *
     * @param title the title
     * @param page  the page
     * @return the books by title
     */
    @Cacheable("books")
    public BookListResponseDTO getBooksByTitle(String title, Long page) {
        page = Objects.nonNull(page) && page > 0 ? page : 1;
        GutendexResponseDTO booksByTerm = gutendexClient.getBooksByTerm(title, page);
        return BookListResponseDTO.getInstance()
                .withTotalResults(booksByTerm.getCount())
                .withPageResults(booksByTerm.getResults()
                        .stream()
                        .count())
                .withPage(page)
                .withBooks(booksByTerm.getResults())
                .build();
    }

    /**
     * Gets book details.
     *
     * @param bookId the book id
     * @return the book details
     */
    @Transactional
    @Cacheable("bookDetails")
    public BookDetailsResponseDTO getBookDetails(Long bookId) {
        BookDTO bookById = gutendexClient.getBookById(bookId);
        List<Review> reviews = repository.findByBookId(bookId);
        Double average = reviews.stream()
                .mapToLong(Review::getRating)
                .filter(Objects::nonNull)
                .average()
                .orElse(0.0);
        return BookDetailsResponseDTO.getInstance()
                .withBook(bookById)
                .withRating(new BigDecimal(average).setScale(1, RoundingMode.HALF_UP).doubleValue())
                .withReviews(reviews.stream().map(Review::getDescription).filter(Objects::nonNull).collect(Collectors.toList()))
                .build();
    }

    /**
     * Create review review dto.
     *
     * @param reviewDTO the review dto
     * @return the review dto
     */
    @Transactional
    @CacheEvict("bookDetails")
    public ReviewDTO createReview(ReviewDTO reviewDTO) {
        Review persistedReview = repository.save(factory.fromReviewDTO(reviewDTO));
        return factory.toReviewDTO(persistedReview);
    }

    /**
     * Gets books by average.
     *
     * @param size the size
     * @return the books by average
     */
    @Transactional
    public List<BookDetailsResponseDTO> getBooksByAverage(Long size) {
        List<ReviewStatistics> byAverage = repository.findByAverage();

        return byAverage.stream().limit(size).map(rs -> getBookDetails(rs.getBookId())).collect(Collectors.toList());
    }


    /**
     * Gets monthly average by book id.
     *
     * @param bookId the book id
     * @return the monthly average by book id
     */
    @Transactional
    public List<BookAverageDTO> getMonthlyAverageByBookId(Long bookId) {
        List<MonthlyStatistics> monthlyAverageByBookId = repository.findMonthlyAverageByBookId(bookId);

        return monthlyAverageByBookId.stream().map(factory::toBookAverageDTO).collect(Collectors.toList());
    }
}
