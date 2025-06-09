package com.project.ecommerce.entity.dto;

import com.project.ecommerce.entity.Item;

import java.io.Serializable;

public class StockReductionMessage implements Serializable {
    private Item item;

    public StockReductionMessage(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
