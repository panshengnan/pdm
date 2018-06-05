package com.cgwx.data.entity;

public class UrmDataFormatInfo {
    private Integer dataFormat;

    private String dataFormatDescription;

    public Integer getDataFormat() {
        return dataFormat;
    }

    public void setDataFormat(Integer dataFormat) {
        this.dataFormat = dataFormat;
    }

    public String getDataFormatDescription() {
        return dataFormatDescription;
    }

    public void setDataFormatDescription(String dataFormatDescription) {
        this.dataFormatDescription = dataFormatDescription == null ? null : dataFormatDescription.trim();
    }
}