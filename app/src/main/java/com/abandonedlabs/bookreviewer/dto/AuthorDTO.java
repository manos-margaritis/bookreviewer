package com.abandonedlabs.bookreviewer.dto;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;
import jakarta.validation.Valid;

/**
 * The type Author dto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "birth_year",
        "death_year",
        "name"
})
public class AuthorDTO implements Serializable {

    private final static long serialVersionUID = 3064759036527259489L;

    @JsonProperty("birth_year")
    private Long birthYear;
    @JsonProperty("death_year")
    private Long deathYear;
    @JsonProperty("name")
    private String name;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AuthorDTO() {
    }

    /**
     * Instantiates a new Author dto.
     *
     * @param birthYear the birth year
     * @param deathYear the death year
     * @param name      the name
     */
    public AuthorDTO(Long birthYear, Long deathYear, String name) {
        super();
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        this.name = name;
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static AuthorDTOBuilder getInstance() {
        return new AuthorDTOBuilder();
    }

    /**
     * Gets birth year.
     *
     * @return the birth year
     */
    @JsonProperty("birth_year")
    public Long getBirthYear() {
        return birthYear;
    }

    /**
     * Sets birth year.
     *
     * @param birthYear the birth year
     */
    @JsonProperty("birth_year")
    public void setBirthYear(Long birthYear) {
        this.birthYear = birthYear;
    }

    /**
     * Gets death year.
     *
     * @return the death year
     */
    @JsonProperty("death_year")
    public Long getDeathYear() {
        return deathYear;
    }

    /**
     * Sets death year.
     *
     * @param deathYear the death year
     */
    @JsonProperty("death_year")
    public void setDeathYear(Long deathYear) {
        this.deathYear = deathYear;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets additional properties.
     *
     * @return the additional properties
     */
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    /**
     * Sets additional property.
     *
     * @param name  the name
     * @param value the value
     */
    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    /**
     * The type Author dto builder.
     */
    public static class AuthorDTOBuilder {

        private Long birthYear;
        private Long deathYear;
        private String name;

        /**
         * With birth year author dto builder.
         *
         * @param birthYear the birth year
         * @return the author dto builder
         */
        public AuthorDTOBuilder withBirthYear(Long birthYear) {
            this.birthYear = birthYear;
            return this;
        }

        /**
         * With death year author dto builder.
         *
         * @param deathYear the death year
         * @return the author dto builder
         */
        public AuthorDTOBuilder withDeathYear(Long deathYear) {
            this.deathYear = deathYear;
            return this;
        }

        /**
         * With name author dto builder.
         *
         * @param name the name
         * @return the author dto builder
         */
        public AuthorDTOBuilder withName(String name) {
            this.name = name;
            return this;
        }

        /**
         * Build author dto.
         *
         * @return the author dto
         */
        public AuthorDTO build() {
            return new AuthorDTO(birthYear, deathYear, name);
        }

    }

}
