package com.mycomerce.msprices.application;

public interface FindPriceUseCase {
    PriceDto execute(FindPriceArgs findPriceArgs) throws IllegalArgumentException;
}
