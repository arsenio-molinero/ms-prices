package com.mycomerce.msprices.application;

import java.time.LocalDateTime;

public interface FindPriceUseCase {
    PriceDto getPrice(int brandId, long productId, LocalDateTime dateTime) throws IllegalArgumentException;
}
