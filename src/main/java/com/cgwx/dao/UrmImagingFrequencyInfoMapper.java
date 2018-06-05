package com.cgwx.dao;

import com.cgwx.data.entity.UrmImagingFrequencyInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UrmImagingFrequencyInfoMapper {
    int insert(UrmImagingFrequencyInfo record);

    List<UrmImagingFrequencyInfo> selectAll();

    @Select("SELECT  imaging_frequency_description\n" +
            "FROM urm_imaging_frequency_info\n" +
            "WHERE   imaging_frequency =  #{code}"
    )
    String selectDescriptionByCode(@Param("code") int code);
}