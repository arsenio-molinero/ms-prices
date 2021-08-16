package com.mycomerce.msprices.infrastructure.api;

import com.mycomerce.msprices.application.FindPriceArgs;
import com.mycomerce.msprices.application.FindPriceUseCase;
import com.mycomerce.msprices.application.PriceDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/price")
public class PriceControllerAdapter {

    private final FindPriceUseCase findPriceUseCase;

    public PriceControllerAdapter(FindPriceUseCase findPriceUseCase) {
        this.findPriceUseCase = findPriceUseCase;
    }

    @GetMapping(params={"brand", "product", "date"})
    public PriceDto getPrice(@RequestParam int brand, @RequestParam int product, @RequestParam String date) {
        PriceDto priceDto = null;
        try {
            priceDto = (PriceDto) findPriceUseCase.execute( new FindPriceArgs(brand, product, LocalDateTime.parse(date)));

            priceDto = (PriceDto) findPriceUseCase.execute( new FindPriceArgs(brand, product, LocalDateTime.parse(date)));
        } catch(Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if (priceDto == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return priceDto;
    }
}
