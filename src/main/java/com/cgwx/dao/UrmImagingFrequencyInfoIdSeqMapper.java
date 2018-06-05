package com.cgwx.dao;

import com.cgwx.data.entity.UrmImagingFrequencyInfoIdSeq;
import java.util.List;

public interface UrmImagingFrequencyInfoIdSeqMapper {
    int insert(UrmImagingFrequencyInfoIdSeq record);

    List<UrmImagingFrequencyInfoIdSeq> selectAll();
}