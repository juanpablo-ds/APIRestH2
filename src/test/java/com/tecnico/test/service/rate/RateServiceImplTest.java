package com.tecnico.test.service.rate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RateServiceImplTest {

    @Autowired
    private RateService rateService;

    @BeforeEach
    public void setup() {

    }

    @Test
    void testCheckRoomPriceWithDate1() {
        //arrange
        String dateInString = "2024-10-03";
        var date = Date.valueOf(dateInString);
        var roomId = 100007L;
        var priceExpected = 90.0;
        //act
        var result = rateService.checkRoomPrice(date,roomId);
        //assert
        assertEquals(priceExpected,result.getFinalPrice());

    }

    @Test
    void testCheckRoomPriceWithDate2() {
        //arrange
        String dateInString = "2024-10-17";
        var date = Date.valueOf(dateInString);
        var roomId = 100007L;
        var priceExpected = 55.25;
        //act
        var result = rateService.checkRoomPrice(date,roomId);
        //assert
        assertEquals(priceExpected,result.getFinalPrice());

    }

    @Test
    void testCheckRoomPriceWithDate3() {
        //arrange
        String dateInString = "2024-10-26";
        var date = Date.valueOf(dateInString);
        var roomId = 100007L;
        var priceExpected = 76.5;
        //act
        var result = rateService.checkRoomPrice(date,roomId);
        //assert
        assertEquals(priceExpected,result.getFinalPrice());

    }


    @Test
    void testCheckRoomPriceWithDate4() {
        //arrange
        String dateInString = "2024-10-30";
        var date = Date.valueOf(dateInString);
        var roomId = 100007L;
        var priceExpected = -1L;
        //act
        var result = rateService.checkRoomPrice(date,roomId);
        //assert
        assertNull(result);

    }

}