package com.cgwx.dao;

import com.cgwx.data.entity.PdmThemeticProductInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PdmThemeticProductInfoMapper {
    int insert(PdmThemeticProductInfo record);

    List<PdmThemeticProductInfo> selectAll();

    @Select("SELECT count(DISTINCT theme.product_id) as count\n" +
            "                \n" +
            "            FROM pdm_themetic_product_info theme  \n" +
            "            WHERE theme.gmt_created >=  \'${currentDate}\'"
    )
    int selectThemeticProductCountByDate(@Param("currentDate") String currentDate);


    @Select("SELECT single_period_product_directory\n" +
            "FROM pdm_themetic_product_detail_info \n" +
            "WHERE  product_id = #{productId}"
    )
    String selectFilePathByProductId(@Param("productId") String productId);
}