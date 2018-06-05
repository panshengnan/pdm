package com.cgwx.dao;

import com.cgwx.data.entity.UrmRadiationRequirementInfoIdSeq;
import java.util.List;

public interface UrmRadiationRequirementInfoIdSeqMapper {
    int insert(UrmRadiationRequirementInfoIdSeq record);

    List<UrmRadiationRequirementInfoIdSeq> selectAll();
}