package com.cgwx.dao;

import com.cgwx.data.entity.UrmUserActionIdSeq;
import java.util.List;

public interface UrmUserActionIdSeqMapper {
    int insert(UrmUserActionIdSeq record);

    List<UrmUserActionIdSeq> selectAll();
}