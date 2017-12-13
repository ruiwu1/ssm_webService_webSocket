package com.webservice.cxf_webService.serviceAndClinet;

import com.commen.utils.JaxbUtil;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class TestServers {

    public String CallInterface(String msgHeader, String msgBody){
        System.out.println(msgHeader+"zxws"+msgBody);
        String result = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<root>\n" +
                "   <tokenCode>令牌</tokenCode>   \n" +
                "<systemCode>业务系统代码</systemCode>\n" +
                "<computerName>计算机名称</computerName>\n" +
                "<userName>登录用户名</userName>\n" +
                "<loginSystemCode>登录系统代码</loginSystemCode>\n" +
                "<roleCode>角色代码</roleCode>\n" +
                "<deptCode>科室代码</deptCode>\n" +
                "</root>";
        return result;
    }

    /**
     * 服务端手动发布，测试用
     * @param args
     */
    public static void main(String[] args) {
        //发布一个服务端，供调用
        Endpoint.publish("http://localhost:7002/card/services/HelloWorld?wsdl",new TestServers());
        System.out.println("发布成功");
    }
}
