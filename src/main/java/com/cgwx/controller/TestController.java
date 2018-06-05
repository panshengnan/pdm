package com.cgwx.controller;

import com.cgwx.aop.result.ResultUtil;
import com.cgwx.data.entity.UrmDataLevelInfo;
import com.cgwx.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.cgwx.aop.result.Result;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Guws on 2018/5/11.
 */
@CrossOrigin
@Controller
public class TestController {

    @Autowired
    ITestService testService;

    @RequestMapping(value = "/datalevel")
    @CrossOrigin(methods = RequestMethod.GET)
    @ResponseBody
    public Result getDataLevel(@RequestParam(value = "file", required = true) String args){
        List<UrmDataLevelInfo> urmDataLevelInfoList = testService.getAllRocords(args);
        List<UrmDataLevelInfo> urmDataLevelInfoList2 = testService.getSimpleRocords(args);
        System.out.println("级别"+urmDataLevelInfoList.get(0).getDataLevel());
        return ResultUtil.success(urmDataLevelInfoList);
    }

}
