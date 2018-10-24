package com.cgwx.dao;

import com.cgwx.data.entity.PdmInlayProductInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PdmInlayProductInfoMapper {
    int insert(PdmInlayProductInfo record);

    List<PdmInlayProductInfo> selectAll();

    @Select("SELECT count(DISTINCT inlay.product_id) as count\n" +
            "                \n" +
            "            FROM pdm_inlay_product_info inlay  \n" +
            "            WHERE inlay.gmt_created >=  \'${currentDate}\'"
    )
    int selectInlayProductCountByDate(@Param("currentDate") String currentDate);


    @Select("SELECT inlay_product_directory\n" +
            "FROM pdm_inlay_product_info \n" +
            "WHERE  product_id = #{productId}"
    )
    String selectFilePathByProductId(@Param("productId") String productId);
}