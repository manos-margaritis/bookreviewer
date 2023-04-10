package com.abandonedlabs.bookreviewer.model;

/**
 * The interface Monthly statistics.
 */
public interface MonthlyStatistics {

    /**
     * Gets month.
     *
     * @return the month
     */
    String getMonth();

    /**
     * Gets rating.
     *
     * @return the rating
     */
    Double getRating();

    /**
     * Gets book id.
     *
     * @return the book id
     */
    Long getBookId();
}
