package com.cgwx.dao;

import com.cgwx.data.entity.UrmSpectralRequirementInfoIdSeq;
import java.util.List;

public interface UrmSpectralRequirementInfoIdSeqMapper {
    int insert(UrmSpectralRequirementInfoIdSeq record);

    List<UrmSpectralRequirementInfoIdSeq> selectAll();
}