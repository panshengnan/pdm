package com.cgwx.data.cri;

import java.util.Date;

/**
 * Created by PanSN 2018/5/14.
 */
public class UserRequirementCri {

    private int curPageNum;

    private int totalPageNum;

    private int maxResult;

    private int resultCount;

    private String requirementSatellite;

    private String imagingMode;

    private Date dateStart;

    private Date dateEnd;

    private String requestName;

    private String orderby;

    private boolean onlyme;

    public int getCurPageNum() {
        return curPageNum;
    }

    public void setCurPageNum(int curPageNum) {
        this.curPageNum = curPageNum;
    }

    public int getTotalPageNum() {
        return totalPageNum;
    }

    public void setTotalPageNum(int totalPageNum) {
        this.totalPageNum = totalPageNum;
    }

    public int getMaxResult() {
        return maxResult;
    }

    public void setMaxResult(int maxResult) {
        this.maxResult = maxResult;
    }

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public String getRequirementSatellite() {
        return requirementSatellite;
    }

    public void setRequirementSatellite(String requirementSatellite) {
        this.requirementSatellite = requirementSatellite;
    }

    public String getImagingMode() {
        return imagingMode;
    }

    public void setImagingMode(String imagingMode) {
        this.imagingMode = imagingMode;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public String getOrderby() {
        return orderby;
    }

    public void setOrderby(String orderby) {
        this.orderby = orderby;
    }

    public boolean isOnlyme() {
        return onlyme;
    }

    public void setOnlyme(boolean onlyme) {
        this.onlyme = onlyme;
    }
}
