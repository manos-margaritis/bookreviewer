package com.abandonedlabs.bookreviewer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * The type Book list response dto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "books",
        "totalResults",
        "pageResults",
        "page"
})
public class BookListResponseDTO implements Serializable {

    @Serial
    private final static long serialVersionUID = 1L;

    @JsonProperty("totalResults")
    private Long totalResults;
    @JsonProperty("pageResults")
    private Long pageResults;
    @JsonProperty("page")
    private Long page;
    @JsonProperty("books")
    private List<BookDTO> books;

    /**
     * Instantiates a new Book list response dto.
     */
    public BookListResponseDTO() {
    }

    /**
     * Instantiates a new Book list response dto.
     *
     * @param totalResults the total results
     * @param pageResults  the page results
     * @param page         the page
     * @param books        the books
     */
    public BookListResponseDTO(Long totalResults, Long pageResults, Long page, List<BookDTO> books) {
        this.totalResults = totalResults;
        this.pageResults = pageResults;
        this.page = page;
        this.books = books;
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static BookListResponseDTOBuilder getInstance() {
        return new BookListResponseDTOBuilder();
    }

    /**
     * Gets total results.
     *
     * @return the total results
     */
    public Long getTotalResults() {
        return totalResults;
    }

    /**
     * Sets total results.
     *
     * @param totalResults the total results
     */
    public void setTotalResults(Long totalResults) {
        this.totalResults = totalResults;
    }

    /**
     * Gets page results.
     *
     * @return the page results
     */
    public Long getPageResults() {
        return pageResults;
    }

    /**
     * Sets page results.
     *
     * @param pageResults the page results
     */
    public void setPageResults(Long pageResults) {
        this.pageResults = pageResults;
    }

    /**
     * Gets page.
     *
     * @return the page
     */
    public Long getPage() {
        return page;
    }

    /**
     * Sets page.
     *
     * @param page the page
     */
    public void setPage(Long page) {
        this.page = page;
    }

    /**
     * Gets books.
     *
     * @return the books
     */
    public List<BookDTO> getBooks() {
        return books;
    }

    /**
     * Sets books.
     *
     * @param books the books
     */
    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }

    /**
     * The type Book list response dto builder.
     */
    public static class BookListResponseDTOBuilder {

        private Long totalResults;
        private Long pageResults;
        private Long page;
        private List<BookDTO> books;

        /**
         * With total results book list response dto builder.
         *
         * @param totalResults the total results
         * @return the book list response dto builder
         */
        public BookListResponseDTOBuilder withTotalResults(Long totalResults) {
            this.totalResults = totalResults;
            return this;
        }

        /**
         * With page results book list response dto builder.
         *
         * @param pageResults the page results
         * @return the book list response dto builder
         */
        public BookListResponseDTOBuilder withPageResults(Long pageResults) {
            this.pageResults = pageResults;
            return this;
        }

        /**
         * With page book list response dto builder.
         *
         * @param page the page
         * @return the book list response dto builder
         */
        public BookListResponseDTOBuilder withPage(Long page) {
            this.page = page;
            return this;
        }

        /**
         * With books book list response dto builder.
         *
         * @param books the books
         * @return the book list response dto builder
         */
        public BookListResponseDTOBuilder withBooks(List<BookDTO> books) {
            this.books = books;
            return this;
        }

        /**
         * Build book list response dto.
         *
         * @return the book list response dto
         */
        public BookListResponseDTO build() {
            return new BookListResponseDTO(totalResults, pageResults, page, books);
        }
    }
}