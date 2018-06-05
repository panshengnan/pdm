package com.cgwx.dao;

import com.cgwx.data.entity.UrmDataFormatInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UrmDataFormatInfoMapper {
    int insert(UrmDataFormatInfo record);

    List<UrmDataFormatInfo> selectAll();

    @Select("SELECT data_format_description\n" +
            "FROM urm_data_format_info\n" +
            "WHERE data_format =  #{code}"
    )
    String selectDescriptionByCode(@Param("code") int code);
}