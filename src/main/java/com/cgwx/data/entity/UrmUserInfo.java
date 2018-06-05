package com.cgwx.data.entity;

public class UrmUserInfo {
    private Integer departmentName;

    private String phoneNumber;

    private String password;

    private String userName;

    private Integer role;

    public Integer getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(Integer departmentName) {
        this.departmentName = departmentName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}