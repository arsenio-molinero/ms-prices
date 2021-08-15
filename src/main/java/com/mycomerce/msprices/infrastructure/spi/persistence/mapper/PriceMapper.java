package com.mycomerce.msprices.infrastructure.spi.persistence.mapper;

import com.mycomerce.msprices.domain.data.Price;
import com.mycomerce.msprices.infrastructure.spi.persistence.data.PriceDbo;

public abstract class PriceMapper {
    public static Price toPrice(PriceDbo priceDbo){
        return new Price(priceDbo.getId(),
                priceDbo.getBrandId(),
                priceDbo.getStartDate(),
                priceDbo.getEndDate(),
                priceDbo.getPriceList(),
                priceDbo.getProductId(),
                priceDbo.getPriority(),
                priceDbo.getPrice(),
                priceDbo.getCurr());
    }
}
