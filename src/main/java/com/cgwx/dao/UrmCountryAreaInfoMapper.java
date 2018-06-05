package com.cgwx.dao;

import com.cgwx.data.entity.UrmCountryAreaInfo;
import java.util.List;

public interface UrmCountryAreaInfoMapper {
    int insert(UrmCountryAreaInfo record);

    List<UrmCountryAreaInfo> selectAll();
}