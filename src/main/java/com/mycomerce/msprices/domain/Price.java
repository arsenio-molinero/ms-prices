package com.mycomerce.msprices.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Price {
    private UUID id;
    private int brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int priceList;
    private long productId;
    private int priority;
    private double price;
    private String curr;

    public Price(UUID id, int brandId, LocalDateTime startDate, LocalDateTime endDate,
                 int priceList, long productId, int priority, double price, String curr) {
        this.id = id;
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.priority = priority;
        this.price = price;
        this.curr = curr;
    }

}
