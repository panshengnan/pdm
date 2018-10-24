package com.cgwx.service.impl;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public interface IProductDownloadService {

    String getEntityFilePath(String productId);
    String downloadFile(HttpServletRequest request, HttpServletResponse response, String fileName, String filePath);

}
