package com.cgwx.dao;

import com.cgwx.data.entity.UrmRequirementTypeInfoIdSeq;
import java.util.List;

public interface UrmRequirementTypeInfoIdSeqMapper {
    int insert(UrmRequirementTypeInfoIdSeq record);

    List<UrmRequirementTypeInfoIdSeq> selectAll();
}