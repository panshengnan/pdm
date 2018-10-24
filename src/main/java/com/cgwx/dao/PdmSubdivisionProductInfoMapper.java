package com.cgwx.dao;

import com.cgwx.data.entity.PdmSubdivisionProductInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PdmSubdivisionProductInfoMapper {
    int insert(PdmSubdivisionProductInfo record);

    List<PdmSubdivisionProductInfo> selectAll();

    @Select("SELECT count(DISTINCT subdivision.product_id) as count\n" +
            "                \n" +
            "            FROM pdm_subdivision_product_info subdivision  \n" +
            "            WHERE subdivision.gmt_created >=  \'${currentDate}\'"
    )
    int selectSubdivisionProductCountByDate(@Param("currentDate") String currentDate);

    @Select("SELECT subdivision_product_directory\n" +
            "FROM pdm_subdivision_product_info \n" +
            "WHERE  product_id = #{productId}"
    )
    String selectFilePathByProductId(@Param("productId") String productId);
}