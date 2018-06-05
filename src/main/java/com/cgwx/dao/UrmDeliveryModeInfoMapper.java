package com.cgwx.dao;

import com.cgwx.data.entity.UrmDeliveryModeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UrmDeliveryModeInfoMapper {
    int insert(UrmDeliveryModeInfo record);

    List<UrmDeliveryModeInfo> selectAll();

    @Select("SELECT  delivery_mode_description\n" +
            "FROM urm_delivery_mode_info\n" +
            "WHERE   delivery_mode =  #{code}"
    )
    String selectDescriptionByCode(@Param("code") int code);
}