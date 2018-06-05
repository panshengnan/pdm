package com.cgwx.service.impl;

import com.cgwx.dao.UrmDataLevelInfoMapper;
import com.cgwx.data.entity.UrmDataLevelInfo;
import com.cgwx.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Guws on 2018/5/11.
 */
@Service
public class TestServiceImpl implements ITestService{

    @Autowired
    UrmDataLevelInfoMapper urmDataLevelInfoMapper;

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

}
