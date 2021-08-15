package com.mycomerce.msprices.infrastructure.spi.persistence;

import com.mycomerce.msprices.domain.data.Price;
import com.mycomerce.msprices.domain.spi.PriceRepositoryPort;
import com.mycomerce.msprices.infrastructure.spi.persistence.data.PriceDbo;
import com.mycomerce.msprices.infrastructure.spi.persistence.mapper.PriceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PriceRepositoryAdapter implements PriceRepositoryPort {
    @Autowired
    private JpaPriceRepository jpaPriceRepository;

    @Override
    public List<Price> findPriceByBrandIdAndProductIdAndDateTime(int brandId, long productId, LocalDateTime dateTime) {
        if (jpaPriceRepository == null) {
            return Collections.emptyList();
        } else {
            List<PriceDbo> result = jpaPriceRepository.findByBrandIdAndProductIdAndDateTime(
                    brandId, productId, dateTime);
            return result == null ? Collections.emptyList() : result.stream().map(PriceMapper::toPrice).collect(Collectors.toList());
        }
    }
}
