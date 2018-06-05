package com.cgwx.dao;

import com.cgwx.data.entity.UrmDepartmentNameInfoIdSeq;
import java.util.List;

public interface UrmDepartmentNameInfoIdSeqMapper {
    int insert(UrmDepartmentNameInfoIdSeq record);

    List<UrmDepartmentNameInfoIdSeq> selectAll();
}