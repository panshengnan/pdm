package com.cgwx.dao;

import com.cgwx.data.entity.UrmPriorityInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UrmPriorityInfoMapper {
    int insert(UrmPriorityInfo record);

    List<UrmPriorityInfo> selectAll();

    @Select("SELECT  priority_description\n" +
            "FROM urm_priority_info\n" +
            "WHERE   priority =  #{code}"
    )
    String selectDescriptionByCode(@Param("code") int code);
}