package com.cgwx.dao;

import com.cgwx.data.entity.UrmImagingRequirementIdSeq;
import java.util.List;

public interface UrmImagingRequirementIdSeqMapper {
    int insert(UrmImagingRequirementIdSeq record);

    List<UrmImagingRequirementIdSeq> selectAll();
}