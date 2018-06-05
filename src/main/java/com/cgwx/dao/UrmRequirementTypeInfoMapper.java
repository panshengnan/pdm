package com.cgwx.dao;

import com.cgwx.data.entity.UrmRequirementTypeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UrmRequirementTypeInfoMapper {
    int insert(UrmRequirementTypeInfo record);

    List<UrmRequirementTypeInfo> selectAll();

    @Select("SELECT  requirement_type_description\n" +
            "FROM urm_requirement_type_info\n" +
            "WHERE   requirement_type =  #{code}"
    )
    String selectDescriptionByCode(@Param("code") int code);

}