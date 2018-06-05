package com.cgwx.dao;

import com.cgwx.data.entity.UrmDataLevelInfoIdSeq;
import java.util.List;

public interface UrmDataLevelInfoIdSeqMapper {
    int insert(UrmDataLevelInfoIdSeq record);

    List<UrmDataLevelInfoIdSeq> selectAll();
}