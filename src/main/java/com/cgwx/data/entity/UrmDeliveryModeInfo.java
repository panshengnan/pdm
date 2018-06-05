package com.cgwx.data.entity;

public class UrmDeliveryModeInfo {
    private Integer deliveryMode;

    private String deliveryModeDescription;

    public Integer getDeliveryMode() {
        return deliveryMode;
    }

    public void setDeliveryMode(Integer deliveryMode) {
        this.deliveryMode = deliveryMode;
    }

    public String getDeliveryModeDescription() {
        return deliveryModeDescription;
    }

    public void setDeliveryModeDescription(String deliveryModeDescription) {
        this.deliveryModeDescription = deliveryModeDescription == null ? null : deliveryModeDescription.trim();
    }
}