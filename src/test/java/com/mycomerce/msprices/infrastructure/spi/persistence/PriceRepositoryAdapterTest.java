package com.mycomerce.msprices.infrastructure.spi.persistence;

import com.mycomerce.msprices.domain.data.Price;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PriceRepositoryAdapterTest {

    @Test
    public void findPriceNotFound(){
        PriceRepositoryAdapter priceRepositoryAdapter = new PriceRepositoryAdapter();
        List<Price> datos = priceRepositoryAdapter.findPriceByBrandIdAndProductIdAndDateTime(1, 32222, LocalDateTime.parse("2020-06-15T21:00:00"));
        assertNotNull(datos);
        assertEquals(datos.size(),0);
    }

    @Test
    public void findPrice(){
        PriceRepositoryAdapter priceRepositoryAdapter = new PriceRepositoryAdapter();
        List<Price> datos = priceRepositoryAdapter.findPriceByBrandIdAndProductIdAndDateTime(1, 35455, LocalDateTime.parse("2020-06-15T21:00:00"));
        assertNotNull(datos);
        assertEquals(datos.size(),1);
        assertEquals(datos.get(0).getPriceList(),4);
    }
}