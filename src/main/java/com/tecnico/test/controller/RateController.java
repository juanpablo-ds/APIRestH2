package com.tecnico.test.controller;


import com.tecnico.test.model.Rate;
import com.tecnico.test.model.dto.PriceQueryResponseDTO;
import com.tecnico.test.service.rate.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
@RequestMapping("/rates")
public class RateController {

    private final RateService rateService;

    @Autowired
    public RateController(RateService rateService) {
        this.rateService = rateService;
    }

    @GetMapping
    public ResponseEntity<PriceQueryResponseDTO> checkRoomPrice(@RequestParam("consultationDate") Date consultationDate, @RequestParam("roomId") Long roomId) {
        var priceQueryResponseDto = rateService.checkRoomPrice(consultationDate, roomId);
        if (priceQueryResponseDto != null ){
            return new ResponseEntity<>(priceQueryResponseDto, HttpStatus.OK);
        }
        return ResponseEntity.ok(new PriceQueryResponseDTO(-1L,-1L,0.0));
    }


}