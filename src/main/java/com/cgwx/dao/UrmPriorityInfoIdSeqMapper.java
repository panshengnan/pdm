package com.cgwx.dao;

import com.cgwx.data.entity.UrmPriorityInfoIdSeq;
import java.util.List;

public interface UrmPriorityInfoIdSeqMapper {
    int insert(UrmPriorityInfoIdSeq record);

    List<UrmPriorityInfoIdSeq> selectAll();
}