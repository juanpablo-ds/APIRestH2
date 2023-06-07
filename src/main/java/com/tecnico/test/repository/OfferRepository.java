package com.tecnico.test.repository;

import com.tecnico.test.model.Offer;
import com.tecnico.test.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;


@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

}