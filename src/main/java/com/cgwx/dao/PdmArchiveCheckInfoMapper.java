package com.cgwx.dao;

import com.cgwx.data.entity.PdmArchiveCheckInfo;
import java.util.List;

public interface PdmArchiveCheckInfoMapper {
    int insert(PdmArchiveCheckInfo record);

    List<PdmArchiveCheckInfo> selectAll();
}