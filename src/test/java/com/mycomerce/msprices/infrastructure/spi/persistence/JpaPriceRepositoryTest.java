package com.mycomerce.msprices.infrastructure.spi.persistence;

import com.mycomerce.msprices.MsPricesApplication;
import com.mycomerce.msprices.infrastructure.spi.persistence.data.PriceDbo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = MsPricesApplication.class)
class JpaPriceRepositoryTest {

    @Autowired
    JpaPriceRepository jpaPriceRepository;

    @Test
    public void database_initialized(){
        List<PriceDbo> datos = jpaPriceRepository.findAll();
        assertNotNull(datos);
        assertEquals(datos.get(0).getPriceList(), 1);
    }

    @Test
    public void get_price(){
        List<PriceDbo> datos = jpaPriceRepository.findByBrandIdAndProductIdAndDateTime(
                1, 35455, LocalDateTime.parse("2020-06-15T21:00:00"));
        assertNotNull(datos);
        assertEquals(datos.get(0).getPriceList(),4);
    }
}