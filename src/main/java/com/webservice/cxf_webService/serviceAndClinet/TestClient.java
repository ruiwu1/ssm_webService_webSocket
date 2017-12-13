package com.webservice.cxf_webService.serviceAndClinet;


import com.commen.utils.CxfInvokeUtil;

import java.io.*;

public class TestClient {
    /**
     * 客户端连接，测试用
     * @param args
     */
    public static void main(String[] args) {
        /*
         * 调用方法已抽取成utils，动态动用
         * wsdlUrl为调用服务的地址
         * msgHeader和msgBody参考DemoWebServiceImpl中的内容
         */
        String Result = "";
        Object[] objects = CxfInvokeUtil.invoke("", "", "");
        if(objects != null && objects.length > 0){
            Result = (String)objects[0];
        }
        System.out.println(Result);
    }
}
