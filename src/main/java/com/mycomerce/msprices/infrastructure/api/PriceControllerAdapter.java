package com.mycomerce.msprices.infrastructure.api;

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
    @GetMapping(params={"brand", "product", "date"})
    public PriceDto getPrice(@RequestParam int brand, @RequestParam int product, @RequestParam String date) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
