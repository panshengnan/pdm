package com.cgwx.controller;

import com.cgwx.aop.result.Result;
import com.cgwx.aop.result.ResultUtil;
import com.cgwx.data.cri.UserRequirementCri;
import com.cgwx.data.dto.ImagingRequirementStrList;
import com.cgwx.data.dto.UserRequirementDetailStr;
import com.cgwx.data.dto.UserRequirementStrList;
import com.cgwx.data.entity.UrmDataLevelInfo;
import com.cgwx.service.ITestService;
import com.cgwx.service.IUserRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by PanSN on 2018/5/14.
 */
@CrossOrigin
@Controller
public class UserRequirementController {

    @Autowired
    ITestService testService;

    @Autowired
    IUserRequirementService userRequirementService;

    @RequestMapping(value = "/userRequirementList")
    @CrossOrigin(methods = RequestMethod.GET)
    @ResponseBody
    public Result getUserRequirementList(@RequestParam(value = "curPageNum", required = true) int curPageNum,
                                     @RequestParam(value = "totalPageNum", required = true) int totalPageNum,
                                     @RequestParam(value = "maxResult", required = true) int maxResult,
                                     @RequestParam(value = "resultCount", required = true) int resultCount,
                                     @RequestParam(value = "requirementSatellite", required = true) String requirementSatellite,
                                     @RequestParam(value = "imagingMode", required = false) String imagingMode,
                                     @RequestParam(value = "dateStart", required = true) String dateStart,
                                     @RequestParam(value = "dateEnd", required = true) String dateEnd,
                                     @RequestParam(value = "requestName", required = true) String requestName,
                                     @RequestParam(value = "orderby", required = true) String orderby,
                                     @RequestParam(value = "onlyme", required = true) boolean onlyme){

        UserRequirementCri cri = new UserRequirementCri();
        cri.setCurPageNum(curPageNum);
        cri.setTotalPageNum(totalPageNum);
        cri.setMaxResult(maxResult);
        cri.setResultCount(resultCount);
        cri.setRequirementSatellite(requirementSatellite);
        cri.setImagingMode(imagingMode);
        dateStart=dateStart.replace("T"," ");
        dateEnd=dateEnd.replace("T"," ");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{ cri.setDateStart(dateFormat.parse(dateStart));
            cri.setDateEnd(dateFormat.parse(dateEnd));
        }catch(ParseException pe){ System.out.println(pe.getMessage()); }
        cri.setRequestName(requestName);
        cri.setOrderby(orderby);
        cri.setOnlyme(onlyme);

        List<UserRequirementStrList> userRequirementStrList = userRequirementService.getUserRequirementList(cri);
        return ResultUtil.success(userRequirementStrList);
    }


    @RequestMapping(value = "/imagingRequirementList")
    @CrossOrigin(methods = RequestMethod.GET)
    @ResponseBody
    public Result getImagingRequirementList(@RequestParam(value = "userRequirementId", required = true) String userRequirementId)
    {

        List<ImagingRequirementStrList> imagingRequirementStrList = userRequirementService.getImagingRequirementStrList(userRequirementId);
        return ResultUtil.success(imagingRequirementStrList);
    }


    @RequestMapping(value = "/userRequirementDetail")
    @CrossOrigin(methods = RequestMethod.GET)
    @ResponseBody
    public Result getUserRequirementDetail(@RequestParam(value = "requirementId", required = true) String requirementId){


        UserRequirementDetailStr userRequirementDetailStr = userRequirementService.getUserRequirementDetailByRequirementId(requirementId);
        return ResultUtil.success(userRequirementDetailStr);
    }


    @RequestMapping(value = "/submitUserRequirement")
    @CrossOrigin(methods = RequestMethod.POST)
    @ResponseBody
    public Result submitUserRequirement(@RequestParam(value = "json", required = true) String userRequirementData){


        String status=userRequirementService.saveUserRequirementAndImagingRequirement(userRequirementData);
        return ResultUtil.success(status);
    }


    @RequestMapping(value = "/submitUserRequest")
    @CrossOrigin(methods = RequestMethod.POST)
    @ResponseBody
    public Result submitUserRequest(@RequestParam(value = "isSensitive", required = true) int isSensitive,
                                    @RequestParam(value = "requirementName", required = true) String requirementName,
                                    @RequestParam(value = "requirementStatus", required = true) String requirementStatus,
                                    @RequestParam(value = "priority", required = true) int priority,
                                    @RequestParam(value = "requirementType", required = true) int requirementType,
                                    @RequestParam(value = "imageGeometry", required = false) String imageGeometry,
                                    @RequestParam(value = "imagingFrequencyRequest", required = true) int imagingFrequencyRequest,
                                    @RequestParam(value = "imagingTimes", required = true) int imagingTimes,
                                    @RequestParam(value = "imagingInternal", required = true) int imagingInternal,
                                    @RequestParam(value = "submitterId", required = true) int submitterId,
                                    @RequestParam(value = "requirementStartTime", required = true) String requirementStartTime,
                                    @RequestParam(value = "requirementEndTime", required = true) String requirementEndTime,
                                    @RequestParam(value = "imageMode", required = true) String imageMode,
                                    @RequestParam(value = "imageDuration", required = true) int imageDuration,
                                    @RequestParam(value = "isMultiGrid", required = true) int isMultiGrid,
                                    @RequestParam(value = "requirementUser", required = true) String requirementUser,
                                    @RequestParam(value = "cloudPercent", required = true)BigDecimal cloudPercent,
                                    @RequestParam(value = "resolution", required = true)BigDecimal resolution,
                                    @RequestParam(value = "rollSatelliteAngle", required = true)BigDecimal rollSatelliteAngle,
                                    @RequestParam(value = "deliveryMethod", required = true)int deliveryMethod,
                                    @RequestParam(value = "deliveryTime", required = true)int deliveryTime,
                                    @RequestParam(value = "dataFormat", required = true)int dataFormat,
                                    @RequestParam(value = "dataLevel", required = true)int dataLevel,
                                    @RequestParam(value = "spectralRequirement", required = true)int spectralRequirement,
                                    @RequestParam(value = "geometryRequirement", required = true)int geometryRequirement,
                                    @RequestParam(value = "radiationRequirement", required = true)int radiationRequirement,
                                    @RequestParam(value = "imagingRequirement", required = true) String imagingRequirement)

    {


        //String status = userRequirementService.saveUserRequirement(userRequirementData);
        return ResultUtil.success("");

    }


}
