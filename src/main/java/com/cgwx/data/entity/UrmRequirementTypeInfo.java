package com.cgwx.data.entity;

public class UrmRequirementTypeInfo {
    private Integer requirementType;

    private String requirementTypeDescription;

    public Integer getRequirementType() {
        return requirementType;
    }

    public void setRequirementType(Integer requirementType) {
        this.requirementType = requirementType;
    }

    public String getRequirementTypeDescription() {
        return requirementTypeDescription;
    }

    public void setRequirementTypeDescription(String requirementTypeDescription) {
        this.requirementTypeDescription = requirementTypeDescription == null ? null : requirementTypeDescription.trim();
    }
}