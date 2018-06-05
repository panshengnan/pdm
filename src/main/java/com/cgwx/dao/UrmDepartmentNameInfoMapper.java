package com.cgwx.dao;

import com.cgwx.data.entity.UrmDepartmentNameInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UrmDepartmentNameInfoMapper {
    int insert(UrmDepartmentNameInfo record);

    List<UrmDepartmentNameInfo> selectAll();
}