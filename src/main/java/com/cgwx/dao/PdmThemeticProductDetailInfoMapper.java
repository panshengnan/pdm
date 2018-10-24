package com.cgwx.dao;

import com.cgwx.data.entity.PdmThemeticProductDetailInfo;
import java.util.List;

public interface PdmThemeticProductDetailInfoMapper {
    int insert(PdmThemeticProductDetailInfo record);

    List<PdmThemeticProductDetailInfo> selectAll();
}