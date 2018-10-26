package com.cgwx.service.impl;

import com.cgwx.data.dto.SecondaryFileStructure;
import com.cgwx.data.dto.UploadFileReturn;
import com.cgwx.data.entity.PdmThemeticProductInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by PanSN on 2018/9/5.
 */

@Service
public interface IProductArchiveService {

    void updateXml(Document document, PdmThemeticProductInfo pdmThemeticProductInfo);
    void update(Document document, String fileName);
    String changeTiftoJpg(String fileName);
    String ZoomImg(String fileName);
    String getUUId();
    String getNextProductId(int productType);
    List<String> getFileNameList(String productId);
    SecondaryFileStructure getSecondaryFileStructure(String path);
    void copyFolder(String oldPath, String newPath);
    void copyFile(String oldPath, String newPath);
    UploadFileReturn uploadFile(MultipartFile file);
    String unZip(String fileName, String filePath);
    void zip(String srcFile, String dest, String passwd);

}
