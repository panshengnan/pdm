package com.cgwx.data.entity;

public class UrmGeometryRequirementInfo {
    private Integer geometryRequirement;

    private String geometryRequirementDescription;

    public Integer getGeometryRequirement() {
        return geometryRequirement;
    }

    public void setGeometryRequirement(Integer geometryRequirement) {
        this.geometryRequirement = geometryRequirement;
    }

    public String getGeometryRequirementDescription() {
        return geometryRequirementDescription;
    }

    public void setGeometryRequirementDescription(String geometryRequirementDescription) {
        this.geometryRequirementDescription = geometryRequirementDescription == null ? null : geometryRequirementDescription.trim();
    }
}