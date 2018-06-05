package com.cgwx.service.impl;


import com.cgwx.service.IPOIService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class POIServiceImpl implements IPOIService {


//    @Override
//    public  List<POIDto> getPOIListByKeyword(String keyword) throws IOException {
//        HttpClient httpClient = new DefaultHttpClient();
//        String url="http://api.map.baidu.com/place/v2/suggestion?query="+keyword+"&region=全国&output=json&ak=jg2gSnFrSrwUDmoMMq1soahORmZcX1aY";
//        HttpPost httpPost = new HttpPost(url);
//
//        String response="";
//
//        HttpResponse httpResponse = null;
//        httpResponse = httpClient.execute(httpPost);
//
//        if(httpResponse.getStatusLine().getStatusCode() == 200){
//            System.out.println("请求和响应成功");
//            HttpEntity httpEntity = httpResponse.getEntity();
//            response = EntityUtils.toString(httpEntity);
//            System.out.println(httpEntity);
//            System.out.println(response);
//        }
//
//        JSONObject jsonObject=null;
//        jsonObject= JSON.parseObject(response);
//        List<POIDto> resultList = new ArrayList<POIDto>();
//        resultList = JSONObject.parseArray(jsonObject.getString("results"),POIDto.class);
//        return resultList;
//    }

    @Override
    public  String getPOIListByKeyword(String keyword) throws IOException {
        HttpClient httpClient = new DefaultHttpClient();
        String url="http://api.map.baidu.com/place/v2/suggestion?query="+keyword+"&region=全国&output=json&ak=jg2gSnFrSrwUDmoMMq1soahORmZcX1aY";
        HttpPost httpPost = new HttpPost(url);

        String response="";

        HttpResponse httpResponse = null;
        httpResponse = httpClient.execute(httpPost);

        if(httpResponse.getStatusLine().getStatusCode() == 200){
            System.out.println("请求和响应成功");
            HttpEntity httpEntity = httpResponse.getEntity();
            response = EntityUtils.toString(httpEntity);
            System.out.println(httpEntity);
            System.out.println(response);
            return response;
        }
        return response;

    }

}
