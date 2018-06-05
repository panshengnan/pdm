package com.cgwx.data.dto;

import com.cgwx.data.entity.UrmImagingRequirement;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class UserRequirementDetail {

    private String requirementId;

    private Integer isSensitive;

    private String requirementName;

    private Integer requirementStatus;

    private Integer priority;

    private Integer requirementType;

    private String imageGeometry;

    private Integer imagingFrequencyRequest;

    private Integer imagingTimes;

    private Integer imagingInternal;

    private Integer submitterId;

    private Date gmt_modified;

    private Date gmt_created;

    private Date requirementStartTime;

    private Date requirementEndTime;

    private String imageMode;

    private Integer imageDuration;

    private Integer isMultiGrid;

    private String requirementUser;

    private BigDecimal cloudPercent;

    private BigDecimal resolution;

    private BigDecimal rollSatelliteAngle;

    private Integer deliveryMethod;

    private Integer deliveryTime;

    private Integer dataFormat;

    private Integer dataLevel;

    private Integer spectralRequirement;

    private Integer geometryRequirement;

    private Integer radiationRequirement;

    private List<UrmImagingRequirement> imagingRequirement;

    public Date getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(Date gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

    public Date getGmt_created() {
        return gmt_created;
    }

    public void setGmt_created(Date gmt_created) {
        this.gmt_created = gmt_created;
    }

    public String getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(String requirementId) {
        this.requirementId = requirementId;
    }

    public Integer getIsSensitive() {
        return isSensitive;
    }

    public void setIsSensitive(Integer isSensitive) {
        this.isSensitive = isSensitive;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public Integer getRequirementStatus() {
        return requirementStatus;
    }

    public void setRequirementStatus(Integer requirementStatus) {
        this.requirementStatus = requirementStatus;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getRequirementType() {
        return requirementType;
    }

    public void setRequirementType(Integer requirementType) {
        this.requirementType = requirementType;
    }

    public String getImageGeometry() {
        return imageGeometry;
    }

    public void setImageGeometry(String imageGeometry) {
        this.imageGeometry = imageGeometry;
    }

    public Integer getImagingFrequencyRequest() {
        return imagingFrequencyRequest;
    }

    public void setImagingFrequencyRequest(Integer imagingFrequencyRequest) {
        this.imagingFrequencyRequest = imagingFrequencyRequest;
    }

    public Integer getImagingTimes() {
        return imagingTimes;
    }

    public void setImagingTimes(Integer imagingTimes) {
        this.imagingTimes = imagingTimes;
    }

    public Integer getImagingInternal() {
        return imagingInternal;
    }

    public void setImagingInternal(Integer imagingInternal) {
        this.imagingInternal = imagingInternal;
    }

    public Integer getSubmitterId() {
        return submitterId;
    }

    public void setSubmitterId(Integer submitterId) {
        this.submitterId = submitterId;
    }

    public Date getRequirementStartTime() {
        return requirementStartTime;
    }

    public void setRequirementStartTime(Date requirementStartTime) {
        this.requirementStartTime = requirementStartTime;
    }

    public Date getRequirementEndTime() {
        return requirementEndTime;
    }

    public void setRequirementEndTime(Date requirementEndTime) {
        this.requirementEndTime = requirementEndTime;
    }

    public String getImageMode() {
        return imageMode;
    }

    public void setImageMode(String imageMode) {
        this.imageMode = imageMode;
    }

    public Integer getImageDuration() {
        return imageDuration;
    }

    public void setImageDuration(Integer imageDuration) {
        this.imageDuration = imageDuration;
    }

    public Integer getIsMultiGrid() {
        return isMultiGrid;
    }

    public void setIsMultiGrid(Integer isMultiGrid) {
        this.isMultiGrid = isMultiGrid;
    }

    public String getRequirementUser() {
        return requirementUser;
    }

    public void setRequirementUser(String requirementUser) {
        this.requirementUser = requirementUser;
    }

    public BigDecimal getCloudPercent() {
        return cloudPercent;
    }

    public void setCloudPercent(BigDecimal cloudPercent) {
        this.cloudPercent = cloudPercent;
    }

    public BigDecimal getResolution() {
        return resolution;
    }

    public void setResolution(BigDecimal resolution) {
        this.resolution = resolution;
    }

    public BigDecimal getRollSatelliteAngle() {
        return rollSatelliteAngle;
    }

    public void setRollSatelliteAngle(BigDecimal rollSatelliteAngle) {
        this.rollSatelliteAngle = rollSatelliteAngle;
    }

    public Integer getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(Integer deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public Integer getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Integer deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Integer getDataFormat() {
        return dataFormat;
    }

    public void setDataFormat(Integer dataFormat) {
        this.dataFormat = dataFormat;
    }

    public Integer getDataLevel() {
        return dataLevel;
    }

    public void setDataLevel(Integer dataLevel) {
        this.dataLevel = dataLevel;
    }

    public Integer getSpectralRequirement() {
        return spectralRequirement;
    }

    public void setSpectralRequirement(Integer spectralRequirement) {
        this.spectralRequirement = spectralRequirement;
    }

    public Integer getGeometryRequirement() {
        return geometryRequirement;
    }

    public void setGeometryRequirement(Integer geometryRequirement) {
        this.geometryRequirement = geometryRequirement;
    }

    public Integer getRadiationRequirement() {
        return radiationRequirement;
    }

    public void setRadiationRequirement(Integer radiationRequirement) {
        this.radiationRequirement = radiationRequirement;
    }

    public List<UrmImagingRequirement> getImagingRequirement() {
        return imagingRequirement;
    }

    public void setImagingRequirement(List<UrmImagingRequirement> imagingRequirement) {
        this.imagingRequirement = imagingRequirement;
    }
}
