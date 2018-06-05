package com.cgwx.data.dto;

import com.cgwx.data.entity.UrmImagingRequirement;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class UserRequirementDetailStr {

    private String requirementId;

    private String isSensitive;

    private String requirementName;

    private String requirementStatus;

    private String priority;

    private String requirementType;

    private String imageGeometry;

    private String imagingFrequencyRequest;

    private String imagingTimes;

    private String imagingInternal;

    private String submitterId;

    private String gmt_modified;

    private String gmt_created;

    private String requirementStartTime;

    private String requirementEndTime;

    private String imageMode;

    private String imageDuration;

    private String isMultiGrid;

    private String requirementUser;

    private String cloudPercent;

    private String resolution;

    private String rollSatelliteAngle;

    private String deliveryMethod;

    private String deliveryTime;

    private String dataFormat;

    private String dataLevel;

    private String spectralRequirement;

    private String geometryRequirement;

    private String radiationRequirement;

    private List<UrmImagingRequirementStr> imagingRequirement;

    public String getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(String requirementId) {
        this.requirementId = requirementId;
    }

    public String getIsSensitive() {
        return isSensitive;
    }

    public void setIsSensitive(String isSensitive) {
        this.isSensitive = isSensitive;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public String getRequirementStatus() {
        return requirementStatus;
    }

    public void setRequirementStatus(String requirementStatus) {
        this.requirementStatus = requirementStatus;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getRequirementType() {
        return requirementType;
    }

    public void setRequirementType(String requirementType) {
        this.requirementType = requirementType;
    }

    public String getImageGeometry() {
        return imageGeometry;
    }

    public void setImageGeometry(String imageGeometry) {
        this.imageGeometry = imageGeometry;
    }

    public String getImagingFrequencyRequest() {
        return imagingFrequencyRequest;
    }

    public void setImagingFrequencyRequest(String imagingFrequencyRequest) {
        this.imagingFrequencyRequest = imagingFrequencyRequest;
    }

    public String getImagingTimes() {
        return imagingTimes;
    }

    public void setImagingTimes(String imagingTimes) {
        this.imagingTimes = imagingTimes;
    }

    public String getImagingInternal() {
        return imagingInternal;
    }

    public void setImagingInternal(String imagingInternal) {
        this.imagingInternal = imagingInternal;
    }

    public String getSubmitterId() {
        return submitterId;
    }

    public void setSubmitterId(String submitterId) {
        this.submitterId = submitterId;
    }

    public String getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(String gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

    public String getGmt_created() {
        return gmt_created;
    }

    public void setGmt_created(String gmt_created) {
        this.gmt_created = gmt_created;
    }

    public String getRequirementStartTime() {
        return requirementStartTime;
    }

    public void setRequirementStartTime(String requirementStartTime) {
        this.requirementStartTime = requirementStartTime;
    }

    public String getRequirementEndTime() {
        return requirementEndTime;
    }

    public void setRequirementEndTime(String requirementEndTime) {
        this.requirementEndTime = requirementEndTime;
    }

    public String getImageMode() {
        return imageMode;
    }

    public void setImageMode(String imageMode) {
        this.imageMode = imageMode;
    }

    public String getImageDuration() {
        return imageDuration;
    }

    public void setImageDuration(String imageDuration) {
        this.imageDuration = imageDuration;
    }

    public String getIsMultiGrid() {
        return isMultiGrid;
    }

    public void setIsMultiGrid(String isMultiGrid) {
        this.isMultiGrid = isMultiGrid;
    }

    public String getRequirementUser() {
        return requirementUser;
    }

    public void setRequirementUser(String requirementUser) {
        this.requirementUser = requirementUser;
    }

    public String getCloudPercent() {
        return cloudPercent;
    }

    public void setCloudPercent(String cloudPercent) {
        this.cloudPercent = cloudPercent;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getRollSatelliteAngle() {
        return rollSatelliteAngle;
    }

    public void setRollSatelliteAngle(String rollSatelliteAngle) {
        this.rollSatelliteAngle = rollSatelliteAngle;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getDataFormat() {
        return dataFormat;
    }

    public void setDataFormat(String dataFormat) {
        this.dataFormat = dataFormat;
    }

    public String getDataLevel() {
        return dataLevel;
    }

    public void setDataLevel(String dataLevel) {
        this.dataLevel = dataLevel;
    }

    public String getSpectralRequirement() {
        return spectralRequirement;
    }

    public void setSpectralRequirement(String spectralRequirement) {
        this.spectralRequirement = spectralRequirement;
    }

    public String getGeometryRequirement() {
        return geometryRequirement;
    }

    public void setGeometryRequirement(String geometryRequirement) {
        this.geometryRequirement = geometryRequirement;
    }

    public String getRadiationRequirement() {
        return radiationRequirement;
    }

    public void setRadiationRequirement(String radiationRequirement) {
        this.radiationRequirement = radiationRequirement;
    }

    public List<UrmImagingRequirementStr> getImagingRequirement() {
        return imagingRequirement;
    }

    public void setImagingRequirement(List<UrmImagingRequirementStr> imagingRequirement) {
        this.imagingRequirement = imagingRequirement;
    }
}
