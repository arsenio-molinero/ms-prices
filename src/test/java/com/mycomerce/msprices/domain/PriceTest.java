package com.mycomerce.msprices.domain;

import com.mycomerce.msprices.domain.Price;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceTest {

    @Test
    void createPrice() {
        UUID id = UUID.randomUUID();
        Price price = new Price(id, 1, null, null, 1,
                1,1,0.0,"EUR");
        assertEquals(id,price.getId());
        assertEquals(1,price.getBrandId());
        assertNull(price.getStartDate());
        assertNull(price.getEndDate());
        assertEquals(1,price.getPriceList());
        assertEquals(1,price.getProductId());
        assertEquals(1,price.getPriority());
        assertEquals(0.0,price.getPrice());
        assertEquals("EUR",price.getCurr());
    }
}