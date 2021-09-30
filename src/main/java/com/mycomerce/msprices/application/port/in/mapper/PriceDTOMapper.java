package com.mycomerce.msprices.application.port.in.mapper;

import com.mycomerce.msprices.application.port.in.DTO.PriceDTO;
import com.mycomerce.msprices.domain.Price;
import com.mycomerce.msprices.infrastructure.out.persistence.data.PriceDBO;

public abstract class PriceDTOMapper {
    public static PriceDTO toDto(Price price) {
        return price == null ? null : new PriceDTO(price.getBrandId(),
                price.getStartDate(),
                price.getEndDate(),
                price.getPriceList(),
                price.getProductId(),
                price.getPriority(),
                price.getPrice(),
                price.getCurr());
    }
}
