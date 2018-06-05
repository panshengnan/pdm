package com.cgwx.service;

import com.cgwx.data.entity.UrmUserInfo;

public interface IUserService {


    int insertPost(UrmUserInfo urmUserInfo);
    String loginByPasswd(String account, String passwd);
}
