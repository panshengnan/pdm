package com.cgwx.data.entity;

public class UrmSpectralRequirementInfo {
    private Integer spectralRequirement;

    private String spectralRequirementDescription;

    public Integer getSpectralRequirement() {
        return spectralRequirement;
    }

    public void setSpectralRequirement(Integer spectralRequirement) {
        this.spectralRequirement = spectralRequirement;
    }

    public String getSpectralRequirementDescription() {
        return spectralRequirementDescription;
    }

    public void setSpectralRequirementDescription(String spectralRequirementDescription) {
        this.spectralRequirementDescription = spectralRequirementDescription == null ? null : spectralRequirementDescription.trim();
    }
}