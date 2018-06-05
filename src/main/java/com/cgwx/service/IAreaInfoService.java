package com.cgwx.service;

import com.cgwx.data.dto.AreaInfoDto;

import java.io.IOException;
import java.util.List;

/**
 * Created by Blaze on 2018/5/11.
 */

public interface IAreaInfoService {

    List<AreaInfoDto> getAreaListByParentId(Integer parentId) throws IOException;

}
