package com.cgwx.dao;

import com.cgwx.data.entity.UrmRequirementStatusInfoIdSeq;
import java.util.List;

public interface UrmRequirementStatusInfoIdSeqMapper {
    int insert(UrmRequirementStatusInfoIdSeq record);

    List<UrmRequirementStatusInfoIdSeq> selectAll();
}