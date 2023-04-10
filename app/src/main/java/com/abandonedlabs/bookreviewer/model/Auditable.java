package com.abandonedlabs.bookreviewer.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;

import javax.json.bind.annotation.JsonbDateFormat;
import java.time.LocalDateTime;

/**
 * The type Auditable.
 */
@MappedSuperclass
public abstract class Auditable extends IdentifiableEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "created_at")
    @JsonbDateFormat("yyyy-MM-dd HH:mm")
    private LocalDateTime createdDate;

    /**
     * Pre persist.
     */
    @PrePersist
    public void prePersist() {
        this.createdDate = LocalDateTime.now();
    }

    /**
     * Instantiates a new Auditable.
     */
    public Auditable() {
    }

    /**
     * Gets created date.
     *
     * @return the created date
     */
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    /**
     * Sets created date.
     *
     * @param createdDate the created date
     */
    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
