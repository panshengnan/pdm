package com.cgwx.service.impl;

import com.cgwx.data.dto.SecondaryFileStructure;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by PanSN on 2018/9/5.
 */

@Service
public interface IProductArchiveService {

////    UploadFileReturn uploadFile(MultipartFile file);
//    String unZip(String fileName, String filePath);
//    void zip(String srcFile, String dest, String passwd);


////    void updateXml(Document document, PdmThematicProductInfo pdmThematicProductInfo);
//    void update(Document document, String fileName);
//    String changeTiftoJpg(String fileName);
//    String ZoomImg(String fileName);
//    String getUUId();
//    String getProductId();
    String getNextProductId(int productType);
    List<String> getFileNameList(String productId);
    SecondaryFileStructure getSecondaryFileStructure(String path);
    void copyFolder(String oldPath, String newPath);
    void copyFile(String oldPath, String newPath);

}
