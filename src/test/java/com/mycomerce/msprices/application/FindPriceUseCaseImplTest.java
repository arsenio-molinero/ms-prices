package com.mycomerce.msprices.application;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FindPriceUseCaseImplTest {
    @Autowired
    FindPriceUseCase findPriceUseCase;

    @Test
    public void getPrice(){
        PriceDto priceDto = new FindPriceUseCaseImpl()
                .getPrice(1, 1, LocalDateTime.parse("2020-06-14T10:00:00"));
        assertNotNull(priceDto);
        assertEquals(0,priceDto.getBrandId());
        assertNull(priceDto.getStartDate());
        assertNull(priceDto.getEndDate());
        assertEquals(0,priceDto.getPriceList());
        assertEquals(0,priceDto.getProductId());
        assertEquals(0,priceDto.getPriority());
        assertEquals(0.0,priceDto.getPrice());
        assertNull(priceDto.getCurr());
    }
}