package com.cgwx.dao;

import com.cgwx.data.entity.UrmUserAction;
import java.util.List;

public interface UrmUserActionMapper {
    int insert(UrmUserAction record);

    List<UrmUserAction> selectAll();
}