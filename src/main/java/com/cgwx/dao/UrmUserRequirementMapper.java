package com.cgwx.dao;

import com.cgwx.data.dto.UserRequirementDetail;
import com.cgwx.data.dto.UserRequirementList;
import com.cgwx.data.entity.UrmUserRequirement;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface UrmUserRequirementMapper {
    String where = "\tWHERE\n\tid =1";
    String imaging_mode = "#{imagingMode}";
    String requirement_name = "#{requirementName}";
    String num = "r.image_mode=#{a}";
    String num2 = "${b}";
    String and_where_requirementName = "${and_requirementName}";
    String and_where_imagingSatellites = "${and_imagingSatellites}";
    String and_where_imagingMode = "${and_imagingMode}";
    String and_where_dateStart = "${and_dateStart}";
    String and_where_dateEnd = "${and_dateEnd}";
    String and_condition = "${condition}";
    String requirement_ID = "${requirementId}";

    int insert(UrmUserRequirement var1);

    List<UrmUserRequirement> selectAll();

    @Select({"UPDATE urm_user_requirement \n" +
            "SET image_geometry = st_geomfromgeojson(#{geo})\n" +
            "WHERE\n" +
            "requirement_id = #{userRequirementId}"
    })
    void updateImageGeometry(@Param("userRequirementId") String userRequirementId, @Param("geo") Object geo);

    @Select({"SELECT r.requirement_name,\n       r.requirement_type,\n       r.requirement_status,\n       r.gmt_created\nFROM urm_user_requirement r,urm_imaging_requirement i \nWHERE r.requirement_id=i.requirement_id AND r.image_mode=#{a}AND r.requirement_name like '%'  AND ${b}"})
    @Results({@Result(
            column = "requirement_name",
            property = "requirementName"
    ), @Result(
            column = "requirement_type",
            property = "requirementType"
    ), @Result(
            column = "requirement_status",
            property = "requirementStatus"
    ), @Result(
            column = "gmt_created",
            property = "requirementSubmitTime"
    )})
    List<UserRequirementList> selectUserRequirementList(@Param("a") int var1, @Param("b") String var2);

    @Select({"SELECT r.requirement_name,\n       r.requirement_type,\n       r.requirement_status,\n       r.gmt_created\nFROM urm_user_requirement r,urm_imaging_requirement i \nWHERE r.requirement_id=i.requirement_id${and_requirementName}${and_imagingSatellites}${and_imagingMode}${and_dateStart}${and_dateEnd}"})
    @Results({@Result(
            column = "requirement_name",
            property = "requirementName"
    ), @Result(
            column = "requirement_type",
            property = "requirementType"
    ), @Result(
            column = "requirement_status",
            property = "requirementStatus"
    ), @Result(
            column = "gmt_created",
            property = "requirementSubmitTime"
    )})
    List<UserRequirementList> selectUserRequirement(@Param("and_requirementName") String var1, @Param("and_imagingSatellites") String var2, @Param("and_imagingMode") String var3, @Param("and_dateStart") Date var4, @Param("and_dateEnd") Date var5);

    @Select({"SELECT DISTINCT r.requirement_name,\n     r.requirement_type,\n       r.requirement_status,\n    r.submitter_id,  r.requirement_id, r.gmt_created\nFROM urm_user_requirement r,urm_imaging_requirement i \nWHERE r.requirement_id=i.requirement_id ${condition}"})
    @Results({@Result(
            column = "requirement_name",
            property = "requirementName"
    ), @Result(
            column = "requirement_type",
            property = "requirementType"
    ), @Result(
            column = "requirement_status",
            property = "requirementStatus"
    ), @Result(
            column = "gmt_created",
            property = "requirementSubmitTime"
    ), @Result(
            column = "submitter_id",
            property = "submitterId"
    ), @Result(
            column = "requirement_id",
            property = "requirementId"
    )})
    List<UserRequirementList> selectUserRequirementByCondition(@Param("condition") String var1);




    @Select({"SELECT requirement_id, is_sensitive, requirement_name, requirement_status, priority, \n" +
            "              requirement_type, st_asgeojson(image_geometry) as geo, imaging_frequency_request, imaging_times, imaging_internal,\n" +
            "               submitter_id, requirement_start_time, requirement_end_time, image_mode, image_duration, \n" +
            "                is_multi_grid, requirement_user, cloud_percent, resolution, roll_satellite_angle, \n" +
            "             delivery_method, delivery_time, data_format, data_level, spectral_requirement, geometry_requirement,\n" +
            "              radiation_requirement,gmt_created,gmt_modified\n" +
            "            FROM urm_user_requirement\n" +
            "            WHERE requirement_id = #{requirementId}"
    })
    @Results({@Result(
            column = "requirement_id",
            property = "requirementId"
    ),@Result(
            column = "is_sensitive",
            property = "isSensitive"
    ), @Result(
            column = "requirement_name",
            property = "requirementName"
    ), @Result(
            column = "requirement_status",
            property = "requirementStatus"
    ), @Result(
            column = "priority",
            property = "priority"
    ), @Result(
            column = "requirement_type",
            property = "requirementType"
    ),@Result(
            column = "geo",
            property = "imageGeometry"
    ), @Result(
            column = "imaging_frequency_request",
            property = "imagingFrequencyRequest"
    ), @Result(
            column = "imaging_times",
            property = "imagingTimes"
    ),@Result(
            column = "imaging_internal",
            property = "imagingInternal"
    ),@Result(
            column = "gmt_created",
            property = "gmt_created"
    ),@Result(
            column = "submitter_id",
            property = "submitterId"
    ),@Result(
            column = "gmt_modified",
            property = "gmt_modified"
    ),@Result(
            column = "requirement_start_time",
            property = "requirementStartTime"
    ),@Result(
            column = "requirement_end_time",
            property = "requirementEndTime"
    ),@Result(
            column = "image_mode",
            property = "imageMode"
    ),@Result(
            column = "image_duration",
            property = "imageDuration"
    ),@Result(
            column = "is_multi_grid",
            property = "isMultiGrid"
    ),@Result(
            column = "requirement_user",
            property = "requirementUser"
    ),@Result(
            column = "cloud_percent",
            property = "cloudPercent"
    ),@Result(
            column = "resolution",
            property = "resolution"
    ),@Result(
            column = "roll_satellite_angle",
            property = "rollSatelliteAngle"
    ),@Result(
            column = "delivery_method",
            property = "deliveryMethod"
    ),@Result(
            column = "delivery_time",
            property = "deliveryTime"
    ),@Result(
            column = "data_format",
            property = "dataFormat"
    ),@Result(
            column = "data_level",
            property = "dataLevel"
    ),@Result(
            column = "spectral_requirement",
            property = "spectralRequirement"
    ),@Result(
            column = "geometry_requirement",
            property = "geometryRequirement"
    ),@Result(
            column = "radiation_requirement",
            property = "radiationRequirement"
    )})
    UserRequirementDetail selectUserRequirementDetailByRequirementId(@Param("requirementId") String requirementId);



    String count_condition="${currentDate}";
    @Select("SELECT count(r.requirement_name) as requirementCount\n" +
            "                \n" +
            "            FROM urm_user_requirement r \n" +
            "            WHERE  " +
            count_condition
    )


    int selectUserRequirementCountByDate(@Param("currentDate") String currentDate);



    @Select("SELECT count(DISTINCT r.requirement_id) as requirementCount\n" +
            "                \n" +
            "            FROM urm_user_requirement r,urm_imaging_requirement i  \n" +
            "            WHERE r.requirement_id=i.requirement_id  ${countCondition}"
    )
    int selectUserRequirementCountByCondition(@Param("countCondition") String countCondition);
}