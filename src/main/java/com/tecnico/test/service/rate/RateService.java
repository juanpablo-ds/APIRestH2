package com.tecnico.test.service.rate;

import com.tecnico.test.model.Rate;
import com.tecnico.test.model.dto.PriceQueryResponseDTO;

import java.sql.Date;
import java.util.List;

public interface RateService {

    PriceQueryResponseDTO checkRoomPrice(Date consultationDate, Long roomId);

    Rate getBestRate(List<Rate> rateList);
}
