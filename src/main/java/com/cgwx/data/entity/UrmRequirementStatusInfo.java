package com.cgwx.data.entity;

public class UrmRequirementStatusInfo {
    private Integer requirementStatus;

    private String requirementStatusDescription;

    public Integer getRequirementStatus() {
        return requirementStatus;
    }

    public void setRequirementStatus(Integer requirementStatus) {
        this.requirementStatus = requirementStatus;
    }

    public String getRequirementStatusDescription() {
        return requirementStatusDescription;
    }

    public void setRequirementStatusDescription(String requirementStatusDescription) {
        this.requirementStatusDescription = requirementStatusDescription == null ? null : requirementStatusDescription.trim();
    }
}