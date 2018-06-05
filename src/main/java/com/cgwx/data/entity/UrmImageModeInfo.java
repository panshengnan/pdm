package com.cgwx.data.entity;

public class UrmImageModeInfo {
    private Integer imageMode;

    private String imageModeDescription;

    public Integer getImageMode() {
        return imageMode;
    }

    public void setImageMode(Integer imageMode) {
        this.imageMode = imageMode;
    }

    public String getImageModeDescription() {
        return imageModeDescription;
    }

    public void setImageModeDescription(String imageModeDescription) {
        this.imageModeDescription = imageModeDescription == null ? null : imageModeDescription.trim();
    }
}