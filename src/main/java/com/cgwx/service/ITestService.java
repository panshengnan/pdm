package com.cgwx.service;

import com.cgwx.data.entity.UrmDataLevelInfo;

import java.util.List;

/**
 * Created by Guws on 2018/5/11.
 */
public interface ITestService {

    List<UrmDataLevelInfo> getAllRocords(String args);
    List<UrmDataLevelInfo> getSimpleRocords(String args);
}
