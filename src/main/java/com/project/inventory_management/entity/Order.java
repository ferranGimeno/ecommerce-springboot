package com.project.inventory_management.entity;

import jakarta.persistence.*;

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

    @Column(name = "date")
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
}
