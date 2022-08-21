package com.axceldev.model;

import java.time.LocalDateTime;

public class Sale {

    private Integer idSale;
    private LocalDateTime saleDate;
    
    public Sale(Integer idSale, LocalDateTime saleDate) {
        this.idSale = idSale;
        this.saleDate = saleDate;
    }

    public Integer getIdSale() {
        return idSale;
    }

    public void setIdSale(Integer idSale) {
        this.idSale = idSale;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }

    @Override
    public String toString() {
        return "Sale [idSale=" + idSale + ", saleDate=" + saleDate + "]";
    }
}
