package com.mycomerce.msprices.application;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class FindPriceArgs {
    private int brandId;
    private long productId;
    private LocalDateTime dateTime;
}
