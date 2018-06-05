package com.cgwx.data.entity;

public class UrmDepartmentNameInfo {
    private Integer departmentId;

    private String departmentIdDescription;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentIdDescription() {
        return departmentIdDescription;
    }

    public void setDepartmentIdDescription(String departmentIdDescription) {
        this.departmentIdDescription = departmentIdDescription == null ? null : departmentIdDescription.trim();
    }
}