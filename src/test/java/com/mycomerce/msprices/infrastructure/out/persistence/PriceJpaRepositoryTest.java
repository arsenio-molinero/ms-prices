package com.mycomerce.msprices.infrastructure.out.persistence;

import com.mycomerce.msprices.MsPricesApplication;
import com.mycomerce.msprices.infrastructure.out.persistence.data.PriceDBO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = MsPricesApplication.class)
class PriceJpaRepositoryTest {

    @Autowired
    PriceJpaRepository jpaPriceRepository;

    @Test
    public void database_initialized(){
        List<PriceDBO> datos = jpaPriceRepository.findAll();
        assertNotNull(datos);
        assertEquals(datos.get(0).getPriceList(), 1);
    }

    @Test
    public void get_price(){
        List<PriceDBO> datos = jpaPriceRepository.findByBrandIdAndProductIdAndDateTime(
                1, 35455, LocalDateTime.parse("2020-06-15T21:00:00"));
        assertNotNull(datos);
        assertEquals(datos.get(0).getPriceList(),4);
    }
}