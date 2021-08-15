package com.mycomerce.msprices.infrastructure.api;

import com.mycomerce.msprices.application.PriceDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PriceControllerAdapterTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void priceNotFound(){
        ResponseEntity<String> response = restTemplate.exchange(
                String.format("http://localhost:%s/price?brand=1&product=123&date=2020-06-15T21:00:00", port),
                HttpMethod.GET, null, String.class);

        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void getPrice(){
        PriceDto priceDto = restTemplate.getForObject(
                String.format("http://localhost:%s/price?brand=1&product=35455&date=2020-06-15T21:00:00", port),
                PriceDto.class);

        assertNotNull(priceDto);
        assertEquals(4, priceDto.getPriceList());
    }

    @Test
    public void badRequestErroneousDate(){
        ResponseEntity<String> response = restTemplate.exchange(
                String.format("http://localhost:%s/price?brand=1&product=123&date=2020-06-15 21:00:00", port),
                HttpMethod.GET, null, String.class);

        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void badRequestErroneousBrandId(){
        ResponseEntity<String> response = restTemplate.exchange(
                String.format("http://localhost:%s/price?brand=0&product=123&date=2020-06-15T21:00:00", port),
                HttpMethod.GET, null, String.class);

        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void badRequestErroneousProductId(){
        ResponseEntity<String> response = restTemplate.exchange(
                String.format("http://localhost:%s/price?brand=1&product=0&date=2020-06-15T21:00:00", port),
                HttpMethod.GET, null, String.class);

        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }}