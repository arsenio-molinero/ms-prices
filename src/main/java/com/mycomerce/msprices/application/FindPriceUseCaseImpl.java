package com.mycomerce.msprices.application;

import com.mycomerce.msprices.domain.FindPrice;
import com.mycomerce.msprices.infrastructure.spi.persistence.PriceRepositoryAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindPriceUseCaseImpl implements FindPriceUseCase {
    @Autowired
    PriceRepositoryAdapter priceRepositoryAdapter;

    public FindPriceUseCaseImpl(PriceRepositoryAdapter priceRepositoryAdapter) {
        this.priceRepositoryAdapter = priceRepositoryAdapter;
    }


    @Override
    public PriceDto execute(FindPriceArgs findPriceArgs) throws IllegalArgumentException {
        if(findPriceArgs.getBrandId() < 1 || findPriceArgs.getProductId() < 1 || findPriceArgs.getDateTime() == null)
            throw new IllegalArgumentException();

        return new FindPrice(priceRepositoryAdapter).getPrice(
                findPriceArgs.getBrandId(), findPriceArgs.getProductId(), findPriceArgs.getDateTime())
                .map(PriceDto::toDto).orElse(null);
    }
}
