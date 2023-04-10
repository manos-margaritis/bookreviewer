package com.abandonedlabs.bookreviewer.controller;

import com.abandonedlabs.bookreviewer.dto.*;
import com.abandonedlabs.bookreviewer.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * The type Book reviewer controller.
 */
@RestController
@RequestMapping("/api/v1/books")
public class BookReviewerController {

    private final static Logger logger = LoggerFactory.getLogger(BookReviewerController.class);

    /**
     * The Service.
     */
    @Autowired
    BookService service;

    /**
     * Gets books by title.
     *
     * @param searchTerm the search term
     * @param page       the page
     * @return the books by title
     */
    @GetMapping(value = "", produces = {"application/json"})
    @Operation(
            summary = "Retrieves a list of Books given a title",
            description = "Fetch a list of Books by specifying a portion of its title. The response is Book object with id, title, authors, languages, download_count.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = BookListResponseDTO.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema()) }) })
    public ResponseEntity<BookListResponseDTO> getBooksByTitle(@RequestParam String searchTerm, @RequestParam(required = false) Long page) {
        logger.info("getBooksByTitle({})", searchTerm);

        return ResponseEntity.status(HttpStatus.OK).body(service.getBooksByTitle(searchTerm, page));
    }

    /**
     * Create review response entity.
     *
     * @param reviewDTO the review dto
     * @return the response entity
     */
    @PostMapping(value = "", produces = {"application/json"}, consumes = {"application/json"})
    @Operation(
            summary = "Creates a new review",
            description = "Creates a new review given a book id, a rating and optionally a description.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = ReviewDTO.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema()) }) })
    public ResponseEntity<ReviewDTO> createReview(@RequestBody @Valid ReviewDTO reviewDTO) {
        logger.info("createReview({})", reviewDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(service.createReview(reviewDTO));
    }

    /**
     * Gets book details.
     *
     * @param id the id
     * @return the book details
     */
    @GetMapping(value = "/{id}", produces = {"application/json"})
    @Operation(
            summary = "Retrieves details about a book given an id",
            description = "Fetches details about a book given its id. The response is BookDetails object with id, title, authors, languages, download_count and reviews.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = BookDetailsResponseDTO.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema()) }) })
    public ResponseEntity<BookDetailsResponseDTO> getBookDetails(@PathVariable Long id) {
        logger.info("getBookDetails({})", id);

        return ResponseEntity.status(HttpStatus.OK).body(service.getBookDetails(id));
    }

    /**
     * Gets books by average rating.
     *
     * @param size the size
     * @return the books by average rating
     */
    @GetMapping(value = "/average", produces = {"application/json"})
    @Operation(
            summary = "Retrieves a list of Books based on their average rating",
            description = "Fetch a list of Books based on their average rating by specifying the size of it. The response is BookDetails object with id, title, authors, languages, download_count.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = BookListResponseDTO.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema()) }) })
    public ResponseEntity<List<BookDetailsResponseDTO>> getBooksByAverageRating(@RequestParam Long size) {
        logger.info("getBooksByAverageRating({})", size);

        return ResponseEntity.status(HttpStatus.OK).body(service.getBooksByAverage(size));
    }

    /**
     * Gets monthly average by books id.
     *
     * @param id the id
     * @return the monthly average by books id
     */
    @GetMapping(value = "/monthly/{id}", produces = {"application/json"})
    @Operation(
            summary = "Retrieves the average rating per month for a Book",
            description = "Fetch the average rating per month for a Book by specifying the book id. The response is BookAverage object with id and month")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = BookListResponseDTO.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema()) }) })
    public ResponseEntity<List<BookAverageDTO>> getMonthlyAverageByBooksId(@PathVariable Long id) {
        logger.info("getMonthlyAverageByBooksId({})", id);

        return ResponseEntity.status(HttpStatus.OK).body(service.getMonthlyAverageByBookId(id));
    }

}
