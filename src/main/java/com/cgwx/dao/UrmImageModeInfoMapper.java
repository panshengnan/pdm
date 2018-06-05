package com.cgwx.dao;

import com.cgwx.data.entity.UrmImageModeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UrmImageModeInfoMapper {
    int insert(UrmImageModeInfo record);

    List<UrmImageModeInfo> selectAll();

    @Select("SELECT  image_mode_description\n" +
            "FROM urm_image_mode_info\n" +
            "WHERE   image_mode =  #{code}"
    )
    String selectDescriptionByCode(@Param("code") int code);
}