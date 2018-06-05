package com.cgwx.dao;

import com.cgwx.data.entity.UrmRequirementStatusInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UrmRequirementStatusInfoMapper {
    int insert(UrmRequirementStatusInfo record);

    List<UrmRequirementStatusInfo> selectAll();

    @Select("SELECT  requirement_status_description\n" +
            "FROM urm_requirement_status_info\n" +
            "WHERE   requirement_status =  #{code}"
    )
    String selectDescriptionByCode(@Param("code") int code);
}