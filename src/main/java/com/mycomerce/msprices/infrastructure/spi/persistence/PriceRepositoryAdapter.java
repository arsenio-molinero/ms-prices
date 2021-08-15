package com.mycomerce.msprices.infrastructure.spi.persistence;

import com.mycomerce.msprices.domain.data.Price;
import com.mycomerce.msprices.domain.spi.PriceRepositoryPort;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class PriceRepositoryAdapter implements PriceRepositoryPort {
    @Override
    public List<Price> findPriceByBrandIdAndProductIdAndDateTime(int brandId, long productId, LocalDateTime dateTime) {
        return Collections.emptyList();
    }
}
