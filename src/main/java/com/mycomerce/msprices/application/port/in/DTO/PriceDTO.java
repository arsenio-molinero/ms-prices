package com.mycomerce.msprices.application.port.in.DTO;

import com.mycomerce.msprices.domain.Price;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceDTO {
    private int brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int priceList;
    private long productId;
    private int priority;
    private double price;
    private String curr;
}
