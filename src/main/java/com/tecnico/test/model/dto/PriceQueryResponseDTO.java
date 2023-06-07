package com.tecnico.test.model.dto;

public class PriceQueryResponseDTO {

    private Long rateid;
    private Long offerId;
    private Double finalPrice;


    public PriceQueryResponseDTO(Long rateid, Long offerId, Double finalPrice) {
        this.rateid = rateid;
        this.offerId = offerId;
        this.finalPrice = finalPrice;
    }

    public Long getRateid() {
        return rateid;
    }

    public void setRateid(Long rateid) {
        this.rateid = rateid;
    }

    public Long getOfferId() {
        return offerId;
    }

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }
}
