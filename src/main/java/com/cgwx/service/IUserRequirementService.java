package com.cgwx.service;

import com.cgwx.data.cri.Condition;
import com.cgwx.data.cri.UserRequirementCri;
import com.cgwx.data.dto.*;
import com.cgwx.data.entity.UrmDataLevelInfo;
import com.cgwx.data.entity.UrmImagingRequirement;
import com.cgwx.data.entity.UrmUserRequirement;

import java.util.List;

/**
 * Created by PanSN on 2018/5/14.
 */
public interface IUserRequirementService {

    List<UrmDataLevelInfo> getAllRocords(String args);
    List<UrmDataLevelInfo> getSimpleRocords(String args);
    List<UserRequirementStrList> getUserRequirementList(UserRequirementCri cri);
    Condition generateUserRequirementList(UserRequirementCri cri);
    UserRequirementDetailStr getUserRequirementDetailByRequirementId(String requirementId);
    String saveUserRequirementAndImagingRequirement(String userRequirementData);
    UserRequirementDetail transformJsonToUserRequirementDetail(String userRequirementData);
    UrmUserRequirement initializeUrmUserRequirement(UserRequirementInfoSubmitted userRequirementInfo);
    List<UrmImagingRequirement> getUrmImagingRequirementList(UserRequirementDetail userRequirementDetail, String userRequirementId);
    UrmUserRequirement transformJsonToUrmUserRequirement(String userRequirementData);
    String getNextReqId();
    List<ImagingRequirementStrList> getImagingRequirementStrList(String userRequirementId);
    List<UrmImagingRequirement> getImagingRequirementDetailList(String userRequirementId);
    UserRequirementDetailStr transformUserRequirementDetailToDetailStr(UserRequirementDetail userRequirementDetail);
    List<UserRequirementStrList> transformUserRequirementListToStrList(List<UserRequirementList> userRequirementList, int count);
    String loginByPasswd(String account, String passwd);
}
