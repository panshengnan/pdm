package com.cgwx.dao;

import com.cgwx.data.entity.UrmUserRequirementIdSeq;
import java.util.List;

public interface UrmUserRequirementIdSeqMapper {
    int insert(UrmUserRequirementIdSeq record);

    List<UrmUserRequirementIdSeq> selectAll();
}