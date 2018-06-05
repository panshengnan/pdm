package com.cgwx.service.impl;

import com.alibaba.fastjson.JSON;
import com.cgwx.dao.*;
import com.cgwx.data.cri.Condition;
import com.cgwx.data.cri.UserRequirementCri;
import com.cgwx.data.dto.*;
import com.cgwx.data.entity.UrmDataLevelInfo;
import com.cgwx.data.entity.UrmImagingRequirement;
import com.cgwx.data.entity.UrmUserRequirement;
import com.cgwx.service.IUserRequirementService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by PanSN on 2018/5/14.
 */
@Service
public class UserRequirementServiceImpl implements IUserRequirementService {


    @Autowired
    UrmDataLevelInfoMapper urmDataLevelInfoMapper;

    @Autowired
    UrmUserRequirementMapper urmUserRequirementMapper;

    @Autowired
    UrmImagingRequirementMapper urmImagingRequirementMapper;

    @Autowired
    UrmRequirementStatusInfoMapper urmRequirementStatusInfoMapper;

    @Autowired
    UrmPriorityInfoMapper urmPriorityInfoMapper;

    @Autowired
    UrmRequirementTypeInfoMapper urmRequirementTypeInfoMapper;

    @Autowired
    UrmImagingFrequencyInfoMapper urmImagingFrequencyInfoMapper;

    @Autowired
    UrmUserInfoMapper urmUserInfoMapper;

    @Autowired
    UrmImageModeInfoMapper urmImageModeInfoMapper;

    @Autowired
    UrmDeliveryModeInfoMapper urmDeliveryModeInfoMapper;

    @Autowired
    UrmDataFormatInfoMapper urmDataFormatInfoMapper;

    @Autowired
    UrmSpectralRequirementInfoMapper urmSpectralRequirementInfoMapper;

    @Autowired
    UrmGeometryRequirementInfoMapper urmGeometryRequirementInfoMapper;

    @Autowired
    UrmRadiationRequirementInfoMapper urmRadiationRequirementInfoMapper;

    @Autowired
    UrmDeliveryTimeInfoMapper urmDeliveryTimeInfoMapper;



    @Override
    public List<UrmDataLevelInfo> getAllRocords(String args)
    {
        return urmDataLevelInfoMapper.selectAll();
    }

    @Override
    public List<UrmDataLevelInfo> getSimpleRocords(String args)
    {
        return urmDataLevelInfoMapper.selectData_level();
    }

    @Override
    public List<UserRequirementStrList> getUserRequirementList(UserRequirementCri cri){

        String condition=generateUserRequirementList(cri).getWhere()+generateUserRequirementList(cri).getOrderby();
        PageHelper.startPage(cri.getCurPageNum(), cri.getMaxResult());
        List<UserRequirementList> list = urmUserRequirementMapper.selectUserRequirementByCondition(condition);
        condition=generateUserRequirementList(cri).getWhere();
        int count = urmUserRequirementMapper.selectUserRequirementCountByCondition(condition);
        List<UserRequirementStrList> userRequirementStrList =new ArrayList<UserRequirementStrList>();
        if(list.size()!=0)
        userRequirementStrList = transformUserRequirementListToStrList(list,count);
        return userRequirementStrList;
    }

    @Override
    public Condition generateUserRequirementList(UserRequirementCri cri) {


        String  where = " and 1=1";
        Date dateStart = cri.getDateStart();
         if (null != dateStart) {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            where += " and r.gmt_created > '" + f.format(dateStart) + "' ";
        }
        Date dateEnd = cri.getDateEnd();
         if (null != dateEnd) {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            where += " and r.gmt_created < '" + f.format(dateEnd) + "' ";
        }
        String requestName = cri.getRequestName();
         if (null != requestName && !"".equals(requestName)) {
            where += " and r.requirement_name like '%" + requestName + "%' ";
        }

        String requestSatellite = cri.getRequirementSatellite();
         if(null != requestSatellite && !"".equals(requestSatellite)) {
            List satelliteList = Arrays.asList(requestSatellite.split(","));
            where += " and "+"(";
            for(int num=0;num<satelliteList.size();num++)
            {
                if(num==satelliteList.size()-1)
                where += "  i.imaging_satellite like '%" + satelliteList.get(num) + "%' ";
                else
                where += "  i.imaging_satellite like '%" + satelliteList.get(num) + "%' OR ";
            }
            where+=" ) ";
        }

        String imagingMode = cri.getImagingMode();
         if (null != imagingMode && !"".equals(imagingMode))
        {
            List imageModeList = Arrays.asList(imagingMode.split(","));

            where += " and "+"(";
            for(int num=0;num<imageModeList.size();num++)
            {
                if(num==imageModeList.size()-1)
                    where += "  r.image_mode like '%" + imageModeList.get(num) + "%' ";
                else
                    where += "  r.image_mode like '%" + imageModeList.get(num) + "%' OR ";
            }
            where+=" ) ";
        }

        String orderby = " order by ";
        String mode = cri.getOrderby();

         if (null != mode && !"".equals(mode)) {
            if ("submitTimeAsc".equals(mode)) {
                orderby += "r.gmt_created asc";

            }
             else if ("submitTimeDesc".equals(mode)) {
                orderby += "r.gmt_created desc";

            }
            else
            {
                orderby = "";
            }
         } else {
            orderby += "r.gmt_created desc";
         }

//        boolean onlyme = cri.isOnlyme();//需要和正阳确认新用户返回形式
//        if (onlyme) {
//            Cavalier me = (Cavalier) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
//            where += " and submitter.id = " + me.getId();
//        }
        Condition condition = new Condition();
        condition.setWhere(where);
        condition.setOrderby(orderby);
        return condition;
    }



    @Override
    public UserRequirementDetailStr getUserRequirementDetailByRequirementId(String requirementId)
    {
        UserRequirementDetail userRequirementDetail = urmUserRequirementMapper.selectUserRequirementDetailByRequirementId(requirementId);
        List<UrmImagingRequirement> urmImagingRequirementList = getImagingRequirementDetailList(requirementId);
        userRequirementDetail.setImagingRequirement(urmImagingRequirementList);
        UserRequirementDetailStr userRequirementDetailStr = transformUserRequirementDetailToDetailStr(userRequirementDetail);
        return userRequirementDetailStr;

    }

    @Override
    public String saveUserRequirementAndImagingRequirement(String userRequirementData)
    {
        UrmUserRequirement userRequirement = transformJsonToUrmUserRequirement(userRequirementData);

        String userRequirementId = getNextReqId();
        userRequirement.setRequirementId(userRequirementId);

        userRequirement.setImageGeometry(userRequirement.getImageGeometry().toString());
        urmUserRequirementMapper.insert(userRequirement);

        UserRequirementDetail userRequirementDetail = transformJsonToUserRequirementDetail(userRequirementData);
        List<UrmImagingRequirement> urmImagingRequirement = getUrmImagingRequirementList(userRequirementDetail,userRequirement.getRequirementId());
        for (UrmImagingRequirement imagingRequirement : urmImagingRequirement)
        {
          urmImagingRequirementMapper.insert(imagingRequirement);
        }


        return "success";
    }

    @Override
    public UserRequirementDetail transformJsonToUserRequirementDetail(String userRequirementData)
    {

        UserRequirementDetail userRequirementDetail= JSON.parseObject(userRequirementData,UserRequirementDetail.class);
        return userRequirementDetail;
    }

    @Override
    public UrmUserRequirement transformJsonToUrmUserRequirement(String userRequirementData)
    {

        UrmUserRequirement userRequirement = JSON.parseObject(userRequirementData,UrmUserRequirement.class);
        return userRequirement;
    }


    @Override
    public UrmUserRequirement initializeUrmUserRequirement(UserRequirementInfoSubmitted userRequirementInfo)
    {
        UrmUserRequirement urmUserRequirement = new UrmUserRequirement();
        urmUserRequirement.setRequirementId("");
        urmUserRequirement.setIsSensitive(userRequirementInfo.getData().getIsSensitive());
        urmUserRequirement.setRequirementName(userRequirementInfo.getData().getRequirementName());
        urmUserRequirement.setRequirementStatus(userRequirementInfo.getData().getRequirementStatus());
        urmUserRequirement.setPriority(userRequirementInfo.getData().getPriority());
        urmUserRequirement.setRequirementType(userRequirementInfo.getData().getRequirementType());
        //urmUserRequirement.setImageGeometry(userRequirementInfo.getData().getImageGeometry());
        urmUserRequirement.setSubmitterId(userRequirementInfo.getData().getSubmitterId());
        urmUserRequirement.setImagingFrequencyRequest(userRequirementInfo.getData().getImagingFrequencyRequest());
        urmUserRequirement.setImagingTimes(userRequirementInfo.getData().getImagingTimes());
        urmUserRequirement.setImagingInternal(userRequirementInfo.getData().getImagingInternal());
        urmUserRequirement.setRequirementStartTime(userRequirementInfo.getData().getRequirementStartTime());
        urmUserRequirement.setRequirementEndTime(userRequirementInfo.getData().getRequirementEndTime());
        urmUserRequirement.setImageMode(userRequirementInfo.getData().getImageMode());
        urmUserRequirement.setImageDuration(userRequirementInfo.getData().getImageDuration());
        urmUserRequirement.setIsMultiGrid(userRequirementInfo.getData().getIsMultiGrid());
        urmUserRequirement.setRequirementUser(userRequirementInfo.getData().getRequirementUser());
        urmUserRequirement.setCloudPercent(userRequirementInfo.getData().getCloudPercent());
        urmUserRequirement.setResolution(userRequirementInfo.getData().getResolution());
        urmUserRequirement.setRollSatelliteAngle(userRequirementInfo.getData().getRollSatelliteAngle());
        urmUserRequirement.setDeliveryMethod(userRequirementInfo.getData().getDeliveryMethod());
        urmUserRequirement.setDeliveryTime(userRequirementInfo.getData().getDeliveryTime());
        urmUserRequirement.setDataFormat(userRequirementInfo.getData().getDataFormat());
        urmUserRequirement.setDataLevel(userRequirementInfo.getData().getDataLevel());
        urmUserRequirement.setSpectralRequirement(userRequirementInfo.getData().getSpectralRequirement());
        urmUserRequirement.setGeometryRequirement(userRequirementInfo.getData().getGeometryRequirement());
        urmUserRequirement.setRadiationRequirement(userRequirementInfo.getData().getRadiationRequirement());

        return urmUserRequirement;
    }

    @Override
    public List<UrmImagingRequirement> getUrmImagingRequirementList(UserRequirementDetail userRequirementDetail,String userRequirementId)
    {
        List<UrmImagingRequirement> urmImagingRequirementList = new ArrayList<UrmImagingRequirement>();
        int totalCount = 1;
        for(int count=0;count<userRequirementDetail.getImagingRequirement().size();count++)
        {
           UrmImagingRequirement urmImagingRequirement = new UrmImagingRequirement();
           urmImagingRequirement.setImagingSatellite(userRequirementDetail.getImagingRequirement().get(count).getImagingSatellite());
           urmImagingRequirement.setImagingMethod(userRequirementDetail.getImagingRequirement().get(count).getImagingMethod());
           urmImagingRequirement.setSatelliteImagingTimes(userRequirementDetail.getImagingRequirement().get(count).getSatelliteImagingTimes());
           urmImagingRequirement.setImagingStartTime(userRequirementDetail.getImagingRequirement().get(count).getImagingStartTime());
           urmImagingRequirement.setImagingEndTime(userRequirementDetail.getImagingRequirement().get(count).getImagingEndTime());
           urmImagingRequirement.setImagingFrequencyRequest(userRequirementDetail.getImagingRequirement().get(count).getImagingFrequencyRequest());
           urmImagingRequirement.setImagingInternal(userRequirementDetail.getImagingRequirement().get(count).getImagingInternal());
           urmImagingRequirement.setRequirementId(userRequirementId);
           urmImagingRequirement.setImagingStatus(1);

           if(userRequirementDetail.getImagingRequirement().get(count).getImagingFrequencyRequest()==1)
            for(int num=0;num<urmImagingRequirement.getSatelliteImagingTimes();num++)
            {
                String imagingId = userRequirementId +"_IMA_00"+Integer.toString(totalCount++);
                urmImagingRequirement.setImagingId(imagingId);
                urmImagingRequirement.setSatelliteImagingTimes(1);
                UrmImagingRequirement urmImagingRequirementTmp = urmImagingRequirement.clone();
                urmImagingRequirementList.add(urmImagingRequirementTmp);

            }
        }
        return urmImagingRequirementList;
    }

    @Override
    public String getNextReqId() {
        Date currentDate = new Date();
        SimpleDateFormat formatyyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd 00:00:01");
        String currentDateStr = formatyyyy_MM_dd.format(currentDate);
        String where="r.gmt_created >= " + "\'"+currentDateStr+ "\'";
        int count = urmUserRequirementMapper.selectUserRequirementCountByDate(where);
        SimpleDateFormat formatyyyyMMdd = new SimpleDateFormat("yyyyMMdd");
        String timestamp = formatyyyyMMdd.format(new Date());
        return "REQ_USR_" + timestamp + "_" + (new String(10001 + count + "").substring(1, 5));
    }

    @Override
    public List<ImagingRequirementStrList> getImagingRequirementStrList(String userRequirementId)
    {

        List<ImagingRequirementList> imagingRequirementList = urmImagingRequirementMapper.selectImagingRequirementByUserRequirementId(userRequirementId);
        List<ImagingRequirementStrList> imagingRequirementStrList = new ArrayList<ImagingRequirementStrList>();
        for(ImagingRequirementList imagingRequirement :imagingRequirementList)
        {
            ImagingRequirementStrList imagingRequirementStr =new ImagingRequirementStrList();
            imagingRequirementStr.setImagingSatellite(imagingRequirement.getImagingSatellite());
            imagingRequirementStr.setImagingStatus(urmRequirementStatusInfoMapper.selectDescriptionByCode(imagingRequirement.getImagingStatus()));
            imagingRequirementStrList.add(imagingRequirementStr);
        }
        return  imagingRequirementStrList;
    }

    @Override
    public List<UrmImagingRequirement> getImagingRequirementDetailList(String userRequirementId)
    {

        List<UrmImagingRequirement> imagingRequirementDetaiList = urmImagingRequirementMapper.selectImagingRequirementDetailByUserRequirementId(userRequirementId);
        return  imagingRequirementDetaiList;
    }


    @Override
    public UserRequirementDetailStr transformUserRequirementDetailToDetailStr(UserRequirementDetail userRequirementDetail)
    {
        UserRequirementDetailStr userRequirementDetailStr = new UserRequirementDetailStr();
        userRequirementDetailStr.setRequirementId(userRequirementDetail.getRequirementId());
        if(userRequirementDetail.getIsSensitive().equals(1))
            userRequirementDetailStr.setIsSensitive("是");
        else
            userRequirementDetailStr.setIsSensitive("否");
        userRequirementDetailStr.setRequirementName(userRequirementDetail.getRequirementName());
        userRequirementDetailStr.setRequirementStatus(urmRequirementStatusInfoMapper.selectDescriptionByCode(userRequirementDetail.getRequirementStatus()));
        userRequirementDetailStr.setPriority(urmPriorityInfoMapper.selectDescriptionByCode(userRequirementDetail.getPriority()));
        userRequirementDetailStr.setRequirementType(urmRequirementTypeInfoMapper.selectDescriptionByCode(userRequirementDetail.getRequirementType()));
        userRequirementDetailStr.setImageGeometry(userRequirementDetail.getImageGeometry());
        userRequirementDetailStr.setImagingFrequencyRequest(urmImagingFrequencyInfoMapper.selectDescriptionByCode(userRequirementDetail.getImagingFrequencyRequest()));
        userRequirementDetailStr.setImagingTimes(userRequirementDetail.getImagingTimes().toString());

        if(userRequirementDetail.getImagingInternal().equals(0))
            userRequirementDetailStr.setImagingInternal("逢过必拍");
        else
            userRequirementDetailStr.setImagingInternal(userRequirementDetail.getImagingInternal().toString());
        userRequirementDetailStr.setSubmitterId(urmUserInfoMapper.selectDisplayNameById(userRequirementDetail.getSubmitterId()));
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        userRequirementDetailStr.setGmt_created(timeFormat.format(userRequirementDetail.getGmt_created()));
        userRequirementDetailStr.setGmt_modified(timeFormat.format(userRequirementDetail.getGmt_modified()));
        userRequirementDetailStr.setRequirementStartTime(timeFormat.format(userRequirementDetail.getRequirementStartTime()));
        userRequirementDetailStr.setRequirementEndTime(timeFormat.format(userRequirementDetail.getRequirementEndTime()));
        userRequirementDetailStr.setImageMode(userRequirementDetail.getImageMode());
        userRequirementDetailStr.setImageDuration(userRequirementDetail.getImageDuration().toString());
        if(userRequirementDetail.getIsMultiGrid().equals(1))
            userRequirementDetailStr.setIsMultiGrid("是");
        else
            userRequirementDetailStr.setIsMultiGrid("否");
        userRequirementDetailStr.setRequirementUser(userRequirementDetail.getRequirementUser());
        userRequirementDetailStr.setCloudPercent(userRequirementDetail.getCloudPercent().toString());
        userRequirementDetailStr.setResolution(userRequirementDetail.getResolution().toString());
        userRequirementDetailStr.setRollSatelliteAngle(userRequirementDetail.getRollSatelliteAngle().toString());
        userRequirementDetailStr.setDeliveryMethod(urmDeliveryModeInfoMapper.selectDescriptionByCode(userRequirementDetail.getDeliveryMethod()));
        userRequirementDetailStr.setDeliveryTime(urmDeliveryTimeInfoMapper.selectDescriptionByCode(userRequirementDetail.getDeliveryTime()));
        userRequirementDetailStr.setDataFormat(urmDataFormatInfoMapper.selectDescriptionByCode(userRequirementDetail.getDataFormat()));
        userRequirementDetailStr.setDataLevel(urmDataLevelInfoMapper.selectDescriptionByCode(userRequirementDetail.getDataLevel()));
        userRequirementDetailStr.setSpectralRequirement(urmSpectralRequirementInfoMapper.selectDescriptionByCode(userRequirementDetail.getSpectralRequirement()));
        userRequirementDetailStr.setGeometryRequirement(urmGeometryRequirementInfoMapper.selectDescriptionByCode(userRequirementDetail.getGeometryRequirement()));
        userRequirementDetailStr.setRadiationRequirement(urmRadiationRequirementInfoMapper.selectDescriptionByCode(userRequirementDetail.getRadiationRequirement()));
        List<UrmImagingRequirementStr> urmImagingRequirementStrList =new ArrayList<UrmImagingRequirementStr>();
        List<UrmImagingRequirement> urmImagingRequirement = userRequirementDetail.getImagingRequirement();

        for (UrmImagingRequirement imagingRequirement : urmImagingRequirement)
         {
             UrmImagingRequirementStr urmImagingRequirementStr =new UrmImagingRequirementStr();
             urmImagingRequirementStr.setImagingId(imagingRequirement.getImagingId());
             urmImagingRequirementStr.setImagingStatus(urmRequirementStatusInfoMapper.selectDescriptionByCode(imagingRequirement.getImagingStatus()));
             urmImagingRequirementStr.setRequirementId(imagingRequirement.getRequirementId());
             urmImagingRequirementStr.setImagingSatellite(imagingRequirement.getImagingSatellite());
             urmImagingRequirementStr.setSatelliteImagingTimes(imagingRequirement.getSatelliteImagingTimes().toString());
             urmImagingRequirementStr.setImagingStartTime(timeFormat.format(imagingRequirement.getImagingStartTime()));
             urmImagingRequirementStr.setImagingEndTime(timeFormat.format(imagingRequirement.getImagingEndTime()));

             if(imagingRequirement.getImagingMethod().equals(1))
                 urmImagingRequirementStr.setImagingMethod("单星拍摄");
             else
                 urmImagingRequirementStr.setImagingMethod("多星拍摄");
             urmImagingRequirementStrList.add(urmImagingRequirementStr);
         }
        userRequirementDetailStr.setImagingRequirement(urmImagingRequirementStrList);

        return userRequirementDetailStr;

    }

    @Override
    public List<UserRequirementStrList> transformUserRequirementListToStrList(List<UserRequirementList> userRequirementList,int count)
    {
        List<UserRequirementStrList> userRequirementStrList = new ArrayList<UserRequirementStrList>();

        for (UserRequirementList userRequirement : userRequirementList)
        {
            UserRequirementStrList userRequirementStr = new UserRequirementStrList();
            SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            userRequirementStr.setRequirementId(userRequirement.getRequirementId());
            userRequirementStr.setRequirementName(userRequirement.getRequirementName());
            userRequirementStr.setRequirementStatus(urmRequirementStatusInfoMapper.selectDescriptionByCode(userRequirement.getRequirementStatus()));
            userRequirementStr.setRequirementType(urmRequirementTypeInfoMapper.selectDescriptionByCode(userRequirement.getRequirementType()));
            userRequirementStr.setSubmitterId(urmUserInfoMapper.selectDisplayNameById(userRequirement.getSubmitterId()));
            userRequirementStr.setRequirementSubmitTime(timeFormat.format(userRequirement.getRequirementSubmitTime()));
            userRequirementStr.setResultCount(count);
            userRequirementStrList.add(userRequirementStr);
        }

        return userRequirementStrList;

    }
    @Override
    public String loginByPasswd(String account,String passwd){

        String result = urmUserInfoMapper.selectPasswdByAccount(account);
        String status = "true";
        if (!passwd.equals(result))
            status= "false";
        return  status;
    }

}
