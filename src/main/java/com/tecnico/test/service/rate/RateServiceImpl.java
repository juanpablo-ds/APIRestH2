package com.tecnico.test.service.rate;

import com.tecnico.test.model.Rate;
import com.tecnico.test.model.dto.PriceQueryResponseDTO;
import com.tecnico.test.operations.MathRateOperations;
import com.tecnico.test.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Comparator;
import java.util.List;

@Service
public class RateServiceImpl implements RateService{
    @Autowired
    private RateRepository rateRepository;


    @Override
    public PriceQueryResponseDTO checkRoomPrice(Date consultationDate, Long roomId) {
        PriceQueryResponseDTO response = null;
        var result = this.rateRepository.findRatesByDateAndRoomId(consultationDate, roomId);
        var bestRate = getBestRate(result);
        if (bestRate!= null){
            var finalPrice = MathRateOperations.calculateDiscount(bestRate.getPrice(),bestRate.getOffer().getPercentageDiscount());
            response = new PriceQueryResponseDTO(bestRate.getRateId(),bestRate.getOffer().getOfferId(),finalPrice);
        }
        return response;
    }

    @Override
    public Rate getBestRate(List<Rate> rateList) {
        var bestRate = rateList.stream()
                .min(Comparator.comparingDouble( element -> MathRateOperations.calculateDiscount(element.getPrice(), element.getOffer().getPercentageDiscount()) ))
                .orElse(null);
        return bestRate;
    }


}
