package com.mycomerce.msprices.application;

import com.mycomerce.msprices.MsPricesApplication;
import com.mycomerce.msprices.application.port.in.FindPriceArgs;
import com.mycomerce.msprices.application.port.in.FindPriceUseCase;
import com.mycomerce.msprices.application.services.FindPriceService;
import com.mycomerce.msprices.application.port.in.DTO.PriceDTO;
import com.mycomerce.msprices.domain.Price;
import com.mycomerce.msprices.infrastructure.out.persistence.PriceRepositoryAdapter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = MsPricesApplication.class)
class FindPriceServiceTest {
    @Autowired
    FindPriceUseCase findPriceUseCase;

    @Mock
    PriceRepositoryAdapter priceRepositoryAdapter;

    @Test
    public void getPrice(){
        List<Price> dataToReturn = Arrays.asList(new Price(UUID.randomUUID(), 1,
                LocalDateTime.parse("2020-06-14T00:00:00"),
                LocalDateTime.parse("2020-12-31T23:59:59"),
                1,35455, 0, 35.50, "EUR"));

        Mockito.when(priceRepositoryAdapter.findPriceByBrandIdAndProductIdAndDateTime(1,1,
                LocalDateTime.parse("2020-06-14T10:00:00"))).thenReturn(dataToReturn);

        PriceDTO priceDto = new FindPriceService(priceRepositoryAdapter)
                .execute( new FindPriceArgs(1, 1, LocalDateTime.parse("2020-06-14T10:00:00")));

        assertNotNull(priceDto);
        assertEquals(1, priceDto.getPriceList());
    }

    @Test
    public void controlOfErroneousParamBrandId(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            PriceDTO priceDto = new FindPriceService(null)
                    .execute( new FindPriceArgs(0, 1, LocalDateTime.parse("2020-06-14T10:00:00")));
        });
    }

    @Test
    public void controlOfErroneousParamProductId(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            PriceDTO priceDto = new FindPriceService(null)
                    .execute( new FindPriceArgs(1, 0, LocalDateTime.parse("2020-06-14T10:00:00")));
        });
    }

    @Test
    public void controlOfErroneousParamDateTime(){
        Assertions.assertThrows(DateTimeParseException.class, () -> {
            PriceDTO priceDto = new FindPriceService(null)
                    .execute( new FindPriceArgs(1, 1, LocalDateTime.parse("2020-02-30 10:00:00")));
        });
    }

    @Test
    public void controlOfErroneousParamDateTimeNull(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            PriceDTO priceDto = new FindPriceService(null)
                    .execute( new FindPriceArgs(1, 1, null));
        });
    }
}