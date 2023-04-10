package com.abandonedlabs.bookreviewer.service;

import com.abandonedlabs.bookreviewer.client.GutendexClient;
import com.abandonedlabs.bookreviewer.dto.*;
import com.abandonedlabs.bookreviewer.factory.BookFactory;
import com.abandonedlabs.bookreviewer.model.MonthlyStatistics;
import com.abandonedlabs.bookreviewer.model.Review;
import com.abandonedlabs.bookreviewer.model.ReviewStatistics;
import com.abandonedlabs.bookreviewer.repository.ReviewRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.mockito.Mockito.*;

public class BookServiceTest {
    @Mock
    Logger logger;
    @Mock
    GutendexClient gutendexClient;
    @Mock
    ReviewRepository repository;
    @Mock
    BookFactory factory;
    @InjectMocks
    BookService bookService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetBooksByTitle() throws Exception {
        when(gutendexClient.getBooksByTerm(anyString(), anyLong())).thenReturn(new GutendexResponseDTO(Long.valueOf(1), null, null, List.of(new BookDTO(List.of(new AuthorDTO(Long.valueOf(1), Long.valueOf(1), "name")), Long.valueOf(1), Long.valueOf(1), List.of("String"), "title"))));

        BookListResponseDTO result = bookService.getBooksByTitle("title", Long.valueOf(1));
        Assert.assertEquals(1, result.getBooks().size());
        Assert.assertEquals(1, result.getBooks().get(0).getAuthors().size());
        Assert.assertEquals("name", result.getBooks().get(0).getAuthors().get(0).getName());
    }

    @Test
    public void testGetBookDetails() throws Exception {
        when(gutendexClient.getBookById(anyLong())).thenReturn(new BookDTO(List.of(new AuthorDTO(Long.valueOf(1), Long.valueOf(1), "name")), Long.valueOf(1), Long.valueOf(1), List.of("String"), "title"));
        Review review = new Review();
        review.setRating(5L);
        review.setBookId(1L);
        review.setId(2L);
        when(repository.findByBookId(anyLong())).thenReturn(List.of(review));

        BookDetailsResponseDTO result = bookService.getBookDetails(Long.valueOf(1));
        Assert.assertEquals("title", result.getBookDTO().getTitle());
    }

    @Test(expected = RuntimeException.class)
    public void testGetBookDetailsException() throws Exception {
        when(gutendexClient.getBookById(anyLong())).thenThrow(new RuntimeException());

        BookDetailsResponseDTO result = bookService.getBookDetails(Long.valueOf(1));
    }

    @Test
    public void testCreateReview() throws Exception {
        when(factory.toReviewDTO(any())).thenReturn(new ReviewDTO(Long.valueOf(1), Long.valueOf(1), Long.valueOf(1), "description", LocalDateTime.of(2023, Month.APRIL, 9, 20, 9, 30)));
        when(factory.fromReviewDTO(any())).thenReturn(new Review());

        ReviewDTO result = bookService.createReview(new ReviewDTO(Long.valueOf(1), Long.valueOf(1), Long.valueOf(1), "description", LocalDateTime.of(2023, Month.APRIL, 9, 20, 9, 30)));
        Assert.assertEquals("description", result.getDescription());
    }

    @Test
    public void testGetBooksByAverage() throws Exception {
        when(gutendexClient.getBookById(anyLong())).thenReturn(new BookDTO(List.of(new AuthorDTO(Long.valueOf(1), Long.valueOf(1), "name")), Long.valueOf(1), Long.valueOf(1), List.of("String"), "title"));
        Review review = new Review();
        review.setRating(5L);
        review.setBookId(1L);
        review.setId(2L);
        when(repository.findByBookId(anyLong())).thenReturn(List.of(review));
        when(repository.findByAverage()).thenReturn(List.of(new ReviewStatistics() {
            @Override
            public Double getRating() {
                return 4.0;
            }

            @Override
            public Long getBookId() {
                return 2L;
            }
        }));

        List<BookDetailsResponseDTO> result = bookService.getBooksByAverage(Long.valueOf(1));
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("title", result.get(0).getBookDTO().getTitle());
    }

    @Test
    public void testGetMonthlyAverageByBookId() throws Exception {
        when(repository.findMonthlyAverageByBookId(anyLong())).thenReturn(List.of(new MonthlyStatistics() {
            @Override
            public String getMonth() {
                return "03-2022";
            }

            @Override
            public Double getRating() {
                return 3.1;
            }

            @Override
            public Long getBookId() {
                return 5L;
            }
        }));

        List<BookAverageDTO> result = bookService.getMonthlyAverageByBookId(Long.valueOf(1));
        Assert.assertEquals(1, result.size());
    }
}