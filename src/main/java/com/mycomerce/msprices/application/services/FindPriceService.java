package com.mycomerce.msprices.application.services;

import com.mycomerce.msprices.application.port.in.FindPriceArgs;
import com.mycomerce.msprices.application.port.in.FindPriceUseCase;
import com.mycomerce.msprices.application.port.in.DTO.PriceDTO;
import com.mycomerce.msprices.application.port.in.mapper.PriceDTOMapper;
import com.mycomerce.msprices.domain.FindPrice;
import com.mycomerce.msprices.infrastructure.out.persistence.PriceRepositoryAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindPriceService implements FindPriceUseCase {
    @Autowired
    PriceRepositoryAdapter priceRepositoryAdapter;

    public FindPriceService(PriceRepositoryAdapter priceRepositoryAdapter) {
        this.priceRepositoryAdapter = priceRepositoryAdapter;
    }


    @Override
    public PriceDTO execute(FindPriceArgs findPriceArgs) throws IllegalArgumentException {
        if(findPriceArgs.getBrandId() < 1 || findPriceArgs.getProductId() < 1 || findPriceArgs.getDateTime() == null)
            throw new IllegalArgumentException();

        return new FindPrice(priceRepositoryAdapter).getPrice(
                findPriceArgs.getBrandId(), findPriceArgs.getProductId(), findPriceArgs.getDateTime())
                .map(PriceDTOMapper::toDto).orElse(null);
    }
}
