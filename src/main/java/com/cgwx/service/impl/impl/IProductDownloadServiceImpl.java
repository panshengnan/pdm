package com.cgwx.service.impl.impl;

import com.cgwx.dao.PdmInlayProductInfoMapper;
import com.cgwx.dao.PdmOrthoProductInfoMapper;
import com.cgwx.dao.PdmSubdivisionProductInfoMapper;
import com.cgwx.dao.PdmThemeticProductInfoMapper;
import com.cgwx.service.impl.IProductDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Service
public class IProductDownloadServiceImpl implements IProductDownloadService{

    @Autowired
    PdmThemeticProductInfoMapper pdmThemeticProductInfoMapper;

    @Autowired
    PdmOrthoProductInfoMapper pdmOrthoProductInfoMapper;

    @Autowired
    PdmInlayProductInfoMapper pdmInlayProductInfoMapper;

    @Autowired
    PdmSubdivisionProductInfoMapper pdmSubdivisionProductInfoMapper;


    @Override/*根据文件名和路径下载文件*/
    public String downloadFile(HttpServletRequest request, HttpServletResponse response, String fileName, String filePath) {

        if (fileName != null) {
            String realPath = filePath;
            File file = new File(realPath, fileName);
            if (file.exists()) {
                try {
                    response.setContentType("multipart/form-data;charset=UTF-8");
                    response.setHeader("Content-Disposition", "attachment; fileName=" + fileName + ";filename*=utf-8''" + URLEncoder.encode(fileName, "UTF-8"));
                } catch (Exception e) {
                }
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("文件下载完成！");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return "success";
    }

    @Override /*根据产品id获取产品完整父路径*/
    public String getEntityFilePath(String productId){

        String path = "";
        String productType = productId.substring(0,3);
        switch (productType) {
            case "THE":
                path = pdmThemeticProductInfoMapper.selectFilePathByProductId(productId);
                break;
            case "ORT":
                path = pdmOrthoProductInfoMapper.selectFilePathByProductId(productId);
                break;
            case "INL":
                path = pdmInlayProductInfoMapper.selectFilePathByProductId(productId);
                break;
            case "SUB":
                path = pdmSubdivisionProductInfoMapper.selectFilePathByProductId(productId);
                break;
            default:
                break;
        }
        return path;
    }

}
