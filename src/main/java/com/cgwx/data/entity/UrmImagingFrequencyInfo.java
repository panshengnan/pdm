package com.cgwx.data.entity;

public class UrmImagingFrequencyInfo {
    private Integer imagingFrequency;

    private String imagingFrequencyDescription;

    public Integer getImagingFrequency() {
        return imagingFrequency;
    }

    public void setImagingFrequency(Integer imagingFrequency) {
        this.imagingFrequency = imagingFrequency;
    }

    public String getImagingFrequencyDescription() {
        return imagingFrequencyDescription;
    }

    public void setImagingFrequencyDescription(String imagingFrequencyDescription) {
        this.imagingFrequencyDescription = imagingFrequencyDescription == null ? null : imagingFrequencyDescription.trim();
    }
}