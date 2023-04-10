package com.abandonedlabs.bookreviewer.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * The type Gutendex response dto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "count",
        "next",
        "previous",
        "results"
})
public class GutendexResponseDTO implements Serializable {

    @Serial
    private final static long serialVersionUID = 1L;

    @JsonProperty("count")
    private Long count;
    @JsonProperty("next")
    private String next;
    @JsonProperty("previous")
    private String previous;
    @JsonProperty("results")
    private List<BookDTO> results;

    /**
     * Instantiates a new Gutendex response dto.
     */
    public GutendexResponseDTO() {
    }

    /**
     * Instantiates a new Gutendex response dto.
     *
     * @param count    the count
     * @param next     the next
     * @param previous the previous
     * @param results  the results
     */
    public GutendexResponseDTO(Long count, String next, String previous, List<BookDTO> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    /**
     * Gets count.
     *
     * @return the count
     */
    public Long getCount() {
        return count;
    }

    /**
     * Sets count.
     *
     * @param count the count
     */
    public void setCount(Long count) {
        this.count = count;
    }

    /**
     * Gets next.
     *
     * @return the next
     */
    public String getNext() {
        return next;
    }

    /**
     * Sets next.
     *
     * @param next the next
     */
    public void setNext(String next) {
        this.next = next;
    }

    /**
     * Gets previous.
     *
     * @return the previous
     */
    public String getPrevious() {
        return previous;
    }

    /**
     * Sets previous.
     *
     * @param previous the previous
     */
    public void setPrevious(String previous) {
        this.previous = previous;
    }

    /**
     * Gets results.
     *
     * @return the results
     */
    public List<BookDTO> getResults() {
        return results;
    }

    /**
     * Sets results.
     *
     * @param results the results
     */
    public void setResults(List<BookDTO> results) {
        this.results = results;
    }
}
