package com.cgwx.service.impl;

import com.cgwx.dao.UrmUserInfoMapper;
import com.cgwx.data.entity.UrmUserInfo;
import com.cgwx.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    public UrmUserInfoMapper urmUserInfoMapper;


    public int insertPost(UrmUserInfo urmUserInfo){

        return urmUserInfoMapper.insertEntity(urmUserInfo);
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
