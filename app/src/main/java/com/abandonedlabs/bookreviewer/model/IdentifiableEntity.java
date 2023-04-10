package com.abandonedlabs.bookreviewer.model;

import jakarta.persistence.*;

import java.io.Serializable;

/**
 * The type Identifiable entity.
 */
@MappedSuperclass
public abstract class IdentifiableEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Instantiates a new Identifiable entity.
     */
    public IdentifiableEntity() {
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

}
