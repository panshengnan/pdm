package com.cgwx.dao;

import com.cgwx.data.entity.UrmDataFormatInfoIdSeq;
import java.util.List;

public interface UrmDataFormatInfoIdSeqMapper {
    int insert(UrmDataFormatInfoIdSeq record);

    List<UrmDataFormatInfoIdSeq> selectAll();
}