package com.mycomerce.msprices.application.port.in;

import com.mycomerce.msprices.application.port.in.DTO.PriceDTO;

public interface FindPriceUseCase {
    PriceDTO execute(FindPriceArgs findPriceArgs) throws IllegalArgumentException;
}
