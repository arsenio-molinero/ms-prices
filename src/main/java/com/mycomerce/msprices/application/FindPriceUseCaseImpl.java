package com.mycomerce.msprices.application;

import com.mycomerce.msprices.domain.FindPrice;
import com.mycomerce.msprices.infrastructure.spi.persistence.PriceRepositoryAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FindPriceUseCaseImpl implements FindPriceUseCase {
    @Autowired
    PriceRepositoryAdapter priceRepositoryAdapter;

    public FindPriceUseCaseImpl(PriceRepositoryAdapter priceRepositoryAdapter) {
        this.priceRepositoryAdapter = priceRepositoryAdapter;
    }

    @Override
    public PriceDto getPrice(int brandId, long productId, LocalDateTime dateTime) throws IllegalArgumentException {
        if(brandId < 1 || productId < 1 || dateTime == null)
            throw new IllegalArgumentException();

        return new FindPrice(priceRepositoryAdapter).getPrice(brandId, productId, dateTime)
                .map(PriceDto::toDto).orElse(null);
    }
}
