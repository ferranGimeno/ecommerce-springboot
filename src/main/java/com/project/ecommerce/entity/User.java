package com.project.ecommerce.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "creationDate")
    private Date creationDate;

    @Column(name = "enabled")
    private boolean enabled;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getEmail() {
        return email;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
