package com.cgwx.data.entity;

import java.util.Date;

public class UrmImagingRequirement implements Cloneable{
    private String imagingId;

    private Integer imagingStatus;

    private String requirementId;

    private String imagingSatellite;

    private Integer imagingMethod;

    private Integer imagingFrequencyRequest;

    private  Integer imagingInternal;

    private Integer satelliteImagingTimes;

    private Date imagingStartTime;

    private Date imagingEndTime;

    @Override
    public UrmImagingRequirement clone() {
        UrmImagingRequirement clone = null;
        try {
            clone = (UrmImagingRequirement) super.clone();

        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return clone;
    }


        public String getImagingId() {
        return imagingId;
    }

    public void setImagingId(String imagingId) {
        this.imagingId = imagingId == null ? null : imagingId.trim();
    }

    public Integer getImagingStatus() {
        return imagingStatus;
    }

    public void setImagingStatus(Integer imagingStatus) {
        this.imagingStatus = imagingStatus;
    }

    public String getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(String requirementId) {
        this.requirementId = requirementId == null ? null : requirementId.trim();
    }

    public String getImagingSatellite() {
        return imagingSatellite;
    }

    public void setImagingSatellite(String imagingSatellite) {
        this.imagingSatellite = imagingSatellite == null ? null : imagingSatellite.trim();
    }

    public Integer getImagingMethod() {
        return imagingMethod;
    }

    public void setImagingMethod(Integer imagingMethod) {
        this.imagingMethod = imagingMethod;
    }

    public Integer getSatelliteImagingTimes() {
        return satelliteImagingTimes;
    }

    public void setSatelliteImagingTimes(Integer satelliteImagingTimes) {
        this.satelliteImagingTimes = satelliteImagingTimes;
    }

    public Date getImagingStartTime() {
        return imagingStartTime;
    }

    public void setImagingStartTime(Date imagingStartTime) {
        this.imagingStartTime = imagingStartTime;
    }

    public Date getImagingEndTime() {
        return imagingEndTime;
    }

    public void setImagingEndTime(Date imagingEndTime) {
        this.imagingEndTime = imagingEndTime;
    }

    public Integer getImagingFrequencyRequest() {
        return imagingFrequencyRequest;
    }

    public void setImagingFrequencyRequest(Integer imagingFrequencyRequest) {
        this.imagingFrequencyRequest = imagingFrequencyRequest;
    }

    public Integer getImagingInternal() {
        return imagingInternal;
    }

    public void setImagingInternal(Integer imagingInternal) {
        this.imagingInternal = imagingInternal;
    }
}