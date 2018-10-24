package com.cgwx.data.entity;

public class PdmThemeticProductInfo {
    private String productId;

    private String themeticProductName;

    private String industry;

    private String parentDirectory;

    private Integer isMultiPeriod;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getThemeticProductName() {
        return themeticProductName;
    }

    public void setThemeticProductName(String themeticProductName) {
        this.themeticProductName = themeticProductName == null ? null : themeticProductName.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public String getParentDirectory() {
        return parentDirectory;
    }

    public void setParentDirectory(String parentDirectory) {
        this.parentDirectory = parentDirectory == null ? null : parentDirectory.trim();
    }

    public Integer getIsMultiPeriod() {
        return isMultiPeriod;
    }

    public void setIsMultiPeriod(Integer isMultiPeriod) {
        this.isMultiPeriod = isMultiPeriod;
    }
}