package com.mycomerce.msprices.application.port.out;

import com.mycomerce.msprices.domain.Price;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public interface PriceRepositoryPort {
    List<Price> findPriceByBrandIdAndProductIdAndDateTime(int brandId, long productId, LocalDateTime dateTime);
}
