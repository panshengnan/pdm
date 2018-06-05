package com.cgwx.dao;

import com.cgwx.data.entity.UrmDeliveryModeInfoIdSeq;
import java.util.List;

public interface UrmDeliveryModeInfoIdSeqMapper {
    int insert(UrmDeliveryModeInfoIdSeq record);

    List<UrmDeliveryModeInfoIdSeq> selectAll();
}