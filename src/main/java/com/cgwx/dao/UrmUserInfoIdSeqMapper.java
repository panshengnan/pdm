package com.cgwx.dao;

import com.cgwx.data.entity.UrmUserInfoIdSeq;
import java.util.List;

public interface UrmUserInfoIdSeqMapper {
    int insert(UrmUserInfoIdSeq record);

    List<UrmUserInfoIdSeq> selectAll();
}