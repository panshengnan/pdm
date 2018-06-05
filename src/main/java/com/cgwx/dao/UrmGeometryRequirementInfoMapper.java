package com.cgwx.dao;

import com.cgwx.data.entity.UrmGeometryRequirementInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UrmGeometryRequirementInfoMapper {
    int insert(UrmGeometryRequirementInfo record);

    List<UrmGeometryRequirementInfo> selectAll();

    @Select("SELECT  geometry_requirement_description\n" +
            "FROM urm_geometry_requirement_info\n" +
            "WHERE   geometry_requirement =  #{code}"
    )
    String selectDescriptionByCode(@Param("code") int code);
}