package com.cgwx.dao;

import com.cgwx.data.entity.UrmDataLevelInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UrmDataLevelInfoMapper {
    int insert(UrmDataLevelInfo var1);

    @Select({"SELECT\n\tdata_level,\n\tdata_level_description\nFROM\n\turm_data_level_info"})
    @Results({@Result(
            column = "data_level",
            property = "dataLevel"
    ), @Result(
            column = "data_level_description",
            property = "dataLevelDescription"
    )})
    List<UrmDataLevelInfo> selectAll();

    @Select({"SELECT\n\tdata_level,\n\tdata_level_description\nFROM\n\turm_data_level_info"})
    @Results({@Result(
            column = "data_level",
            property = "dataLevel"
    ), @Result(
            column = "data_level_description",
            property = "dataLevelDescription"
    )})
    List<UrmDataLevelInfo> selectData_level();

    @Select("SELECT  data_level_description\n" +
            "FROM urm_data_level_info\n" +
            "WHERE  data_level =  #{code}"
    )
    String selectDescriptionByCode(@Param("code") int code);
}