package com.mycomerce.msprices.domain;

import com.mycomerce.msprices.domain.data.Price;
import com.mycomerce.msprices.domain.spi.PriceRepositoryPort;

import java.time.LocalDateTime;
import java.util.Optional;

public class FindPrice {
    private final PriceRepositoryPort priceRepositoryPort;

    public FindPrice(PriceRepositoryPort priceRepositoryPort){
        this.priceRepositoryPort = priceRepositoryPort;
    }

    public Optional<Price> getPrice(int brandId, long productId, LocalDateTime dateTime){
        if (priceRepositoryPort == null)
            return Optional.empty();
        else
            return priceRepositoryPort.findPriceByBrandIdAndProductIdAndDateTime(brandId, productId, dateTime).stream().findFirst();
    }
}
