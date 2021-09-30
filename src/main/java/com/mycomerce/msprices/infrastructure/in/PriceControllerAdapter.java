package com.mycomerce.msprices.infrastructure.in;

import com.mycomerce.msprices.application.port.in.FindPriceArgs;
import com.mycomerce.msprices.application.port.in.FindPriceUseCase;
import com.mycomerce.msprices.application.port.in.DTO.PriceDTO;
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
    public PriceDTO getPrice(@RequestParam int brand, @RequestParam int product, @RequestParam String date) {
        PriceDTO priceDto = null;
        try {
            priceDto = (PriceDTO) findPriceUseCase.execute( new FindPriceArgs(brand, product, LocalDateTime.parse(date)));
        } catch(Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if (priceDto == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return priceDto;
    }
}
