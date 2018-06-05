package com.cgwx.data.entity;

public class UrmDataLevelInfo {
    private Integer dataLevel;

    private String dataLevelDescription;

    public Integer getDataLevel() {
        return dataLevel;
    }

    public void setDataLevel(Integer dataLevel) {
        this.dataLevel = dataLevel;
    }

    public String getDataLevelDescription() {
        return dataLevelDescription;
    }

    public void setDataLevelDescription(String dataLevelDescription) {
        this.dataLevelDescription = dataLevelDescription == null ? null : dataLevelDescription.trim();
    }
}