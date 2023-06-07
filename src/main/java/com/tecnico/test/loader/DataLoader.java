package com.tecnico.test.loader;

import com.tecnico.test.model.Offer;
import com.tecnico.test.model.Rate;
import com.tecnico.test.repository.OfferRepository;
import com.tecnico.test.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class DataLoader implements CommandLineRunner {

    private final RateRepository rateRepository;
    private final OfferRepository offerRepository;

    @Autowired
    public DataLoader(RateRepository rateRepository, OfferRepository offerRepository) {
        this.rateRepository = rateRepository;
        this.offerRepository = offerRepository;
    }

    @Override
    public void run(String... args) {

        // Código para cargar los datos iniciales en la base de datos
        Offer offer1 = new Offer(1L,0);
        Offer offer2 = new Offer(2L,50);
        Offer offer3 = new Offer(3L,10);


        this.offerRepository.save(offer1);
        this.offerRepository.save(offer2);
        this.offerRepository.save(offer3);

        Rate rate1 = new Rate(100007L, Date.valueOf("2024-10-01"), Date.valueOf("2024-10-15"), 90.00, offer1);
        Rate rate2 = new Rate(100007L, Date.valueOf("2024-10-16"), Date.valueOf("2024-10-20"), 110.50, offer2);
        Rate rate3 = new Rate(100007L, Date.valueOf("2024-10-21"), Date.valueOf("2024-10-27"), 200.00, offer2);
        Rate rate4 = new Rate(100007L, Date.valueOf("2024-10-25"), Date.valueOf("2024-10-27"), 85.00, offer3);

        rateRepository.save(rate1);
        rateRepository.save(rate2);
        rateRepository.save(rate3);
        rateRepository.save(rate4);
    }
}