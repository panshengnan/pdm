package com.cgwx.dao;

import com.cgwx.data.entity.UrmSpectralRequirementInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UrmSpectralRequirementInfoMapper {
    int insert(UrmSpectralRequirementInfo record);

    List<UrmSpectralRequirementInfo> selectAll();


    @Select("SELECT  spectral_requirement_description\n" +
            "FROM urm_spectral_requirement_info \n" +
            "WHERE  spectral_requirement = #{code}"
    )
    String selectDescriptionByCode(@Param("code") int code);
}