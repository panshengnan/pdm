package com.cgwx.controller;

import com.alibaba.fastjson.JSON;
import com.cgwx.aop.result.Result;
import com.cgwx.aop.result.ResultUtil;
import com.cgwx.data.dto.UploadFileReturn;
import com.cgwx.service.impl.IProductArchiveService;
import com.cgwx.service.impl.IProductDownloadService;
import com.cgwx.service.impl.LayerPublishService;



import org.opengis.referencing.FactoryException;
import org.opengis.referencing.operation.TransformException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;


@CrossOrigin
@Controller
public class ProductArchiveController {


    @Autowired
    IProductArchiveService iProductArchiveService;

    @Autowired
    IProductDownloadService iProductDownloadService;

    @Autowired
    LayerPublishService layerPublishService;

    @RequestMapping(value = "/test")
    @CrossOrigin(methods = RequestMethod.GET)
    @ResponseBody
    public Result test() throws IOException, FactoryException, TransformException
    {
//       System.out.println(iProductArchiveService.getNextProductId(4));
//        System.out.println(iProductDownloadService.getEntityFilePath("123"));
  //      layerPublishService.publishTif("D:\\Program Files (x86)\\GeoServer 2.13.2\\data_dir\\data\\长春热岛201607.tif","re","red");
        //File file = new File("D:\\Program Files (x86)\\GeoServer 2.13.2\\data_dir\\data\\长春热岛201607.tif");
        //System.out.println(file.toURL());

//       return ResultUtil.success(iProductArchiveService.getSecondaryFileStructure("C:\\Users\\37753\\Desktop\\tmpPic\\哈哈"));
        iProductArchiveService.copyFolder("C:\\Users\\37753\\Desktop\\产品管理后台\\pdm\\专题产品","C:\\Users\\37753\\Desktop\\产品管理后台\\pdm\\高级产品");
        return ResultUtil.success("");
    }

    @RequestMapping("/downloadFile")
    @CrossOrigin(methods = RequestMethod.GET)
    @ResponseBody
    public void downloadFile(HttpServletRequest request, HttpServletResponse response, String productId, String fileName) {

        System.out.println("收到文件下载请求！");
        String filePath = iProductDownloadService.getEntityFilePath(productId);
        iProductDownloadService.downloadFile(request,response,fileName,filePath);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{filename:.+}")
    @ResponseBody
    public ResponseEntity<?> getFile(@PathVariable String filename) {

        try {
//            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(ROOT, filename).toString()));
      System.out.println(filename);
            File file = new File("C:\\Users\\37753\\Desktop\\临时图片\\师姐老公.jpg");
            System.out.println(file.toURL().toString());
//            resourceLoader.getClass().getResource(file.toURL().toString());
            System.out.println("haha");

//            return ResponseEntity.ok(classLoader.getResource(file.toURL().toString()));

           return ResponseEntity.ok("gjhj");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


    @RequestMapping(value = "/uploadThemeticProduct")
    @CrossOrigin(methods = RequestMethod.POST)
    @ResponseBody
    public Result uploadThemeticProduct(@RequestParam(value = "file", required = true) MultipartFile file) throws Exception {

        System.out.print("收到专题产品上传请求！");
        UploadFileReturn uploadFileReturn = iProductArchiveService.uploadFile(file);
        System.out.println(uploadFileReturn.getFileName());
        System.out.println(uploadFileReturn.getFilePath());
        String path = iProductArchiveService.unZip(uploadFileReturn.getFileName(), uploadFileReturn.getFilePath());
        System.out.println("输入是："+path);
        return ResultUtil.success(iProductArchiveService.getSecondaryFileStructure(path));

    }


}
