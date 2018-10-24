package com.cgwx.dao;

import com.cgwx.data.entity.PdmOrthoProductInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PdmOrthoProductInfoMapper {
    int insert(PdmOrthoProductInfo record);

    List<PdmOrthoProductInfo> selectAll();

    @Select("SELECT count(DISTINCT ortho.product_id) as count\n" +
            "                \n" +
            "            FROM pdm_ortho_product_info ortho  \n" +
            "            WHERE ortho.gmt_created >=  \'${currentDate}\'"
    )
    int selectOrthoProductCountByDate(@Param("currentDate") String currentDate);


    @Select("SELECT ortho_product_directory\n" +
            "FROM pdm_ortho_product_info \n" +
            "WHERE  product_id = #{productId}"
    )
    String selectFilePathByProductId(@Param("productId") String productId);
}