package com.cgwx.dao;

import com.cgwx.data.entity.UrmRadiationRequirementInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UrmRadiationRequirementInfoMapper {
    int insert(UrmRadiationRequirementInfo record);

    List<UrmRadiationRequirementInfo> selectAll();

    @Select("SELECT  radiation_requirement_description\n" +
            "FROM urm_radiation_requirement_info\n" +
            "WHERE   radiation_requirement =  #{code}"
    )
    String selectDescriptionByCode(@Param("code") int code);

}