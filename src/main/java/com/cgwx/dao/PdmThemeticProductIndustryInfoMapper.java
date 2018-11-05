package com.cgwx.dao;

import com.cgwx.data.entity.PdmThemeticProductIndustryInfo;
import java.util.List;

public interface PdmThemeticProductIndustryInfoMapper {
    int insert(PdmThemeticProductIndustryInfo record);

    List<PdmThemeticProductIndustryInfo> selectAll();
}