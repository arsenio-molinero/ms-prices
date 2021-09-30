package com.mycomerce.msprices.domain;

import com.mycomerce.msprices.application.port.out.PriceRepositoryPort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import java.time.LocalDateTime;
import java.util.*;

class FindPriceTest {
    @Test
    public void getPrice(){
        List<Price> datosARetornar = Arrays.asList(new Price(UUID.randomUUID(), 1,
                LocalDateTime.parse("2020-06-14T00:00:00"),
                LocalDateTime.parse("2020-12-31T23:59:59"),
                1,35455, 0, 35.50, "EUR"));

        PriceRepositoryPort repository = mock(PriceRepositoryPort.class);
        Mockito.when(repository.findPriceByBrandIdAndProductIdAndDateTime(1,1,
                LocalDateTime.parse("2020-06-14T10:00:00"))).thenReturn(datosARetornar);

        Optional<Price> priceDto = new FindPrice(repository)
                .getPrice(1, 1, LocalDateTime.parse("2020-06-14T10:00:00"));

        assertTrue(priceDto.isPresent());
        assertEquals(priceDto.get().getPriceList(), datosARetornar.get(0).getPriceList());
    }

    @Test
    public void priceNotFound(){
        ArrayList<Price> datosARetornar = new ArrayList();

        PriceRepositoryPort repository = mock(PriceRepositoryPort.class);
        Mockito.when(repository.findPriceByBrandIdAndProductIdAndDateTime(2,1,
                LocalDateTime.parse("2020-06-14T10:00:00"))).thenReturn(datosARetornar);

        Optional<Price> priceDto = new FindPrice(repository)
                .getPrice(2, 1, LocalDateTime.parse("2020-06-14T10:00:00"));

        assertFalse(priceDto.isPresent());
    }
}