package com.cgwx.data.entity;

public class UrmRadiationRequirementInfo {
    private Integer radiationRequirement;

    private String radiationRequirementDescription;

    public Integer getRadiationRequirement() {
        return radiationRequirement;
    }

    public void setRadiationRequirement(Integer radiationRequirement) {
        this.radiationRequirement = radiationRequirement;
    }

    public String getRadiationRequirementDescription() {
        return radiationRequirementDescription;
    }

    public void setRadiationRequirementDescription(String radiationRequirementDescription) {
        this.radiationRequirementDescription = radiationRequirementDescription == null ? null : radiationRequirementDescription.trim();
    }
}