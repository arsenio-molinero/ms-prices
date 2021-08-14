package com.mycomerce.msprices.domain.spi;

import com.mycomerce.msprices.domain.data.Price;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public interface PriceRepositoryPort {
    List<Price> findPriceByBrandIdAndProductIdAndDateTime(int brandId, long productId, LocalDateTime dateTime);
}
