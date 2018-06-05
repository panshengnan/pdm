package com.cgwx.dao;

import com.cgwx.data.entity.UrmGeometryRequirementInfoIdSeq;
import java.util.List;

public interface UrmGeometryRequirementInfoIdSeqMapper {
    int insert(UrmGeometryRequirementInfoIdSeq record);

    List<UrmGeometryRequirementInfoIdSeq> selectAll();
}