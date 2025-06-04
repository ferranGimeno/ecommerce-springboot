package com.project.inventory_management.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "item")
public class Item implements Serializable {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Integer price;

}
