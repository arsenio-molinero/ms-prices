package com.mycomerce.msprices.domain.data;

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
    }
}