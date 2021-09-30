package com.mycomerce.msprices.infrastructure.out.persistence;

import com.mycomerce.msprices.MsPricesApplication;
import com.mycomerce.msprices.domain.Price;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = MsPricesApplication.class)
class PriceRepositoryAdapterTest {

    @Autowired
    PriceRepositoryAdapter priceRepositoryAdapter;

    @Test
    public void findPriceNotFound(){
        List<Price> datos = priceRepositoryAdapter.findPriceByBrandIdAndProductIdAndDateTime(1, 32222, LocalDateTime.parse("2020-06-15T21:00:00"));
        assertNotNull(datos);
        assertEquals(datos.size(),0);
    }

    @Test
    public void findPrice(){
        List<Price> datos = priceRepositoryAdapter.findPriceByBrandIdAndProductIdAndDateTime(1, 35455, LocalDateTime.parse("2020-06-15T21:00:00"));
        assertNotNull(datos);
        assertEquals(datos.size(),2);
        assertEquals(datos.get(0).getPriceList(),4);
    }
}