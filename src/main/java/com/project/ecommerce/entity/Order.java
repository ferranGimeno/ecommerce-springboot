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

    @Column(name = "itemId")
    private Long itemId;

    @Column(name = "quantity")
    private Integer quantity;

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

    public Long getItemId() {
        return itemId;
    }

    public Integer getQuantity() {
        return quantity;
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

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
