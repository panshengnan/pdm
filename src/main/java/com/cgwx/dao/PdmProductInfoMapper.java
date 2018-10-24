package com.cgwx.dao;

import com.cgwx.data.entity.PdmProductInfo;
import java.util.List;

public interface PdmProductInfoMapper {
    int insert(PdmProductInfo record);

    List<PdmProductInfo> selectAll();
}