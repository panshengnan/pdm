package com.cgwx.controller;

import com.cgwx.aop.result.Result;
import com.cgwx.aop.result.ResultUtil;
import com.cgwx.data.entity.UrmUserInfo;
import com.cgwx.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@Controller
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping("/insert")
    @CrossOrigin(methods = RequestMethod.POST)
    @ResponseBody
    public Result insertPost(@RequestParam(value = "departmentName", required = true) int departmentName,
                             @RequestParam(value = "phone_number", required = true) String phoneNumber,
                             @RequestParam(value = "password", required = true) String password,
                             @RequestParam(value = "userName", required = true) String userName,
                             @RequestParam(value = "role", required = true) int role){

        UrmUserInfo urmUserInfo = new UrmUserInfo();
        urmUserInfo.setDepartmentName(departmentName);
        urmUserInfo.setPhoneNumber(phoneNumber);
        urmUserInfo.setPassword(password);
        urmUserInfo.setUserName(userName);
        urmUserInfo.setRole(role);
        userService.insertPost(urmUserInfo);
        return ResultUtil.success(urmUserInfo);

    }

    @RequestMapping(value = "/login")
    @CrossOrigin(methods = RequestMethod.GET)
    @ResponseBody
    public Result login(@RequestParam(value = "account", required = true) String account,
                        @RequestParam(value = "passwd", required = true) String passwd){

        String status=userService.loginByPasswd(account,passwd);
        return ResultUtil.success(status);
    }

}