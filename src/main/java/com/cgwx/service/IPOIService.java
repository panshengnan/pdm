package com.cgwx.service;

import java.io.IOException;

/**
 * Created by Blaze on 2018/5/11.
 */

public interface IPOIService {

    //List<POIDto> getPOIListByKeyword(String keyword) throws IOException;
    String getPOIListByKeyword(String keyword) throws IOException;

}
