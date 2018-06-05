package com.cgwx.dao;

import com.cgwx.data.entity.UrmImageModeInfoIdSeq;
import java.util.List;

public interface UrmImageModeInfoIdSeqMapper {
    int insert(UrmImageModeInfoIdSeq record);

    List<UrmImageModeInfoIdSeq> selectAll();
}