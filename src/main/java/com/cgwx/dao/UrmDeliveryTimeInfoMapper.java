package com.cgwx.dao;

import com.cgwx.data.entity.UrmDeliveryModeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UrmDeliveryTimeInfoMapper {


    @Select("SELECT  delivery_time_description\n" +
            "FROM urm_delivery_time_info\n" +
            "WHERE   delivery_time =  #{code}"
    )
    String selectDescriptionByCode(@Param("code") int code);
}