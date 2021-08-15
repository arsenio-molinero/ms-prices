package com.mycomerce.msprices.application;

import java.time.LocalDateTime;

public class FindPriceUseCaseImpl implements FindPriceUseCase {
    @Override
    public PriceDto getPrice(int brandId, long productId, LocalDateTime dateTime) throws IllegalArgumentException {
        return new PriceDto();
    }
}
