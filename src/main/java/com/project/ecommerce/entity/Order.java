package com.project.ecommerce.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "order")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userId")
    private Long userId;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "creationDate")
    private Date date;

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Date getDate() {
        return date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
