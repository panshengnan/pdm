package com.cgwx.data.dto;

import java.math.BigDecimal;

public class Location {
    private BigDecimal lat;

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    private BigDecimal lng;

}