package com.cgwx.data.dto;

import java.util.Date;

public class UserRequirementList {

    private String requirementName;

    private Integer requirementType;

    private Integer requirementStatus;

    private Date requirementSubmitTime;

    private Integer submitterId;

    private String requirementId;


    public String getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(String requirementId) {
        this.requirementId = requirementId;
    }

    public Integer getSubmitterId() {
        return submitterId;
    }

    public void setSubmitterId(Integer submitterId) {
        this.submitterId = submitterId;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public Integer getRequirementType() {
        return requirementType;
    }

    public void setRequirementType(Integer requirementType) {
        this.requirementType = requirementType;
    }

    public Integer getRequirementStatus() {
        return requirementStatus;
    }

    public void setRequirementStatus(Integer requirementStatus) {
        this.requirementStatus = requirementStatus;
    }

    public Date getRequirementSubmitTime() {
        return requirementSubmitTime;
    }

    public void setRequirementSubmitTime(Date requirementSubmitTime) {
        this.requirementSubmitTime = requirementSubmitTime;
    }
}
