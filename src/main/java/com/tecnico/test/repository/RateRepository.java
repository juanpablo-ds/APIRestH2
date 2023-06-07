package com.tecnico.test.repository;


import com.tecnico.test.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {

    @Query("SELECT r FROM Rate r WHERE :consultationDate >= r.dateFrom  AND :consultationDate <= r.dateTo AND r.roomId = :roomId")
    List<Rate> findRatesByDateAndRoomId(Date consultationDate, Long roomId);
}