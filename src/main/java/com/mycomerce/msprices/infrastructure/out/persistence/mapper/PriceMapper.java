package com.mycomerce.msprices.infrastructure.out.persistence.mapper;

import com.mycomerce.msprices.domain.Price;
import com.mycomerce.msprices.infrastructure.out.persistence.data.PriceDBO;

public abstract class PriceMapper {
    public static Price toPrice(PriceDBO priceDbo){
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
