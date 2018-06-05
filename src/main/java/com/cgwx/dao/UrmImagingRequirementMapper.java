package com.cgwx.dao;

import com.cgwx.data.dto.ImagingRequirementList;
import com.cgwx.data.entity.UrmImagingRequirement;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UrmImagingRequirementMapper {

    int insert(UrmImagingRequirement var1);

    List<UrmImagingRequirement> selectAll();

    @Select("SELECT DISTINCT i.imaging_satellite,i.imaging_status\n" +
            "FROM urm_imaging_requirement i \n" +
            "WHERE i.requirement_id = #{requirementId}"

    )
    @Results({
            @Result(column = "imaging_satellite", property = "imagingSatellite"),
            @Result(column = "imaging_status", property = "imagingStatus")
    })
    List<ImagingRequirementList> selectImagingRequirementByUserRequirementId(@Param("requirementId") String requirementId);




    @Select("SELECT *\n" +
            "FROM urm_imaging_requirement i \n" +
            "WHERE i.requirement_id = #{requirementId}"

    )
    @Results({
            @Result(column = "imaging_id", property = "imagingId"),
            @Result(column = "requirement_id", property = "requirementId"),
            @Result(column = "imaging_satellite", property = "imagingSatellite"),
            @Result(column = "imaging_status", property = "imagingStatus"),
            @Result(column = "imaging_method", property = "imagingMethod"),
            @Result(column = "satellite_imaging_times", property = "satelliteImagingTimes"),
            @Result(column = "imaging_start_time", property = "imagingStartTime"),
            @Result(column = "imaging_end_time", property = "imagingEndTime")
    })
    List<UrmImagingRequirement> selectImagingRequirementDetailByUserRequirementId(@Param("requirementId") String requirementId);
}