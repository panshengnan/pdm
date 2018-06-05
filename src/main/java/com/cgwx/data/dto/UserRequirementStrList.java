package com.cgwx.data.dto;

public class UserRequirementStrList {

    private String requirementName;

    private String requirementType;

    private String requirementStatus;

    private String requirementSubmitTime;

    private String submitterId;

    private String requirementId;

    private int resultCount;

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public String getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(String requirementId) {
        this.requirementId = requirementId;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public String getRequirementType() {
        return requirementType;
    }

    public void setRequirementType(String requirementType) {
        this.requirementType = requirementType;
    }

    public String getRequirementStatus() {
        return requirementStatus;
    }

    public void setRequirementStatus(String requirementStatus) {
        this.requirementStatus = requirementStatus;
    }

    public String getRequirementSubmitTime() {
        return requirementSubmitTime;
    }

    public void setRequirementSubmitTime(String requirementSubmitTime) {
        this.requirementSubmitTime = requirementSubmitTime;
    }

    public String getSubmitterId() {
        return submitterId;
    }

    public void setSubmitterId(String submitterId) {
        this.submitterId = submitterId;
    }
}
