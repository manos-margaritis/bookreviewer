package com.abandonedlabs.bookreviewer.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.*;
import jakarta.validation.Valid;

/**
 * The type Book dto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "authors",
        "download_count",
        "id",
        "languages",
        "title"
})
public class BookDTO implements Serializable {

    @Serial
    private final static long serialVersionUID = 4161585919802398454L;

    @JsonProperty("authors")
    @Valid
    private List<AuthorDTO> authors;
    @JsonProperty("download_count")
    private Long downloadCount;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("languages")
    @Valid
    private List<String> languages;
    @JsonProperty("title")
    private String title;

    /**
     * No args constructor for use in serialization
     */
    public BookDTO() {
    }

    /**
     * Instantiates a new Book dto.
     *
     * @param authors       the authors
     * @param downloadCount the download count
     * @param id            the id
     * @param languages     the languages
     * @param title         the title
     */
    public BookDTO(List<AuthorDTO> authors, Long downloadCount, Long id, List<String> languages, String title) {
        super();
        this.authors = authors;
        this.downloadCount = downloadCount;
        this.id = id;
        this.languages = languages;
        this.title = title;
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static BookDTOBuilder getInstance() {
        return new BookDTOBuilder();
    }

    /**
     * Gets authors.
     *
     * @return the authors
     */
    @JsonProperty("authors")
    public List<AuthorDTO> getAuthors() {
        return authors;
    }

    /**
     * Sets authors.
     *
     * @param authors the authors
     */
    @JsonProperty("authors")
    public void setAuthors(List<AuthorDTO> authors) {
        this.authors = authors;
    }

    /**
     * Gets download count.
     *
     * @return the download count
     */
    @JsonProperty("download_count")
    public Long getDownloadCount() {
        return downloadCount;
    }

    /**
     * Sets download count.
     *
     * @param downloadCount the download count
     */
    @JsonProperty("download_count")
    public void setDownloadCount(Long downloadCount) {
        this.downloadCount = downloadCount;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets languages.
     *
     * @return the languages
     */
    @JsonProperty("languages")
    public List<String> getLanguages() {
        return languages;
    }

    /**
     * Sets languages.
     *
     * @param languages the languages
     */
    @JsonProperty("languages")
    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * The type Book dto builder.
     */
    public static class BookDTOBuilder {

        private List<AuthorDTO> authors;
        private Long downloadCount;
        private Long id;
        @Valid
        private List<String> languages;
        private String title;

        /**
         * With authors book dto builder.
         *
         * @param authors the authors
         * @return the book dto builder
         */
        public BookDTOBuilder withAuthors(List<AuthorDTO> authors) {
            this.authors = authors;
            return this;
        }

        /**
         * With download count book dto builder.
         *
         * @param downloadCount the download count
         * @return the book dto builder
         */
        public BookDTOBuilder withDownloadCount(Long downloadCount) {
            this.downloadCount = downloadCount;
            return this;
        }

        /**
         * With id book dto builder.
         *
         * @param id the id
         * @return the book dto builder
         */
        public BookDTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        /**
         * With languages book dto builder.
         *
         * @param languages the languages
         * @return the book dto builder
         */
        public BookDTOBuilder withLanguages(List<String> languages) {
            this.languages = languages;
            return this;
        }

        /**
         * With title book dto builder.
         *
         * @param title the title
         * @return the book dto builder
         */
        public BookDTOBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        /**
         * Build book dto.
         *
         * @return the book dto
         */
        public BookDTO build() {
            return new BookDTO(authors, downloadCount, id, languages, title);
        }
    }
}
