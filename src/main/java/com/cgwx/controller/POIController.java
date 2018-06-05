package com.cgwx.controller;

import com.cgwx.service.IPOIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created by Blaze on 2018/5/11.
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/POI")


public class POIController {

    @Autowired
    IPOIService poiService;

    @GetMapping("/search={name}")
    @CrossOrigin(methods = RequestMethod.GET)

    public String getPOIList(@PathVariable String name) throws IOException {

        String poiDtoList =   poiService.getPOIListByKeyword(name);
        return poiDtoList;

    }

}
