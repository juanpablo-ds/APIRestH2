package com.tecnico.test.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


//RATE_ID ROOM_ID DATE_FROM DATE_TO PRICE OFFER_ID
// 1 100007 2024-10-01 2024-10-15 90.00 1
@Entity
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rateId;
    private Long roomId;
    private Date dateFrom;
    private Date dateTo;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "offerId")
    private Offer offer;
    // Getters y setters


    public Rate(Long roomId, Date dateFrom, Date dateTo, Double price, Offer offer) {
        this.roomId = roomId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.price = price;
        this.offer = offer;
    }

    public Rate() {
    }

    public Long getRateId() {
        return rateId;
    }

    public void setRateId(Long rateId) {
        this.rateId = rateId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }
}

