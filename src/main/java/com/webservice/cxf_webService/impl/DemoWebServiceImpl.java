package com.webservice.cxf_webService.impl;

import com.commen.utils.JaxbUtil;
import com.webservice.cxf_webService.DemoWebService;
import com.webservice.model.MsgBody;
import com.webservice.model.MsgHeader;
import com.websocket.WebSocketHander;
import org.apache.ibatis.annotations.Case;
import org.slf4j.Logger;

import javax.jws.WebService;
import javax.xml.bind.JAXBException;

/**
 * targetNamespace 命名空间，一般是文件夹路径的倒叙
 * serviceName 服务名，
 *
 */
@WebService(serviceName = "SingleSignOnService",
        targetNamespace ="http://impl.webservice.CXF.com",
        endpointInterface = "com.webservice.cxf_webService.DemoWebService")
public class DemoWebServiceImpl implements DemoWebService {
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(DemoWebServiceImpl.class);
    private static String Result = "";
    /**
     * 统一入口
     * @param mHeader
     * @param mBody
     * @return
     */
    @Override
    public String CallInterface(String mHeader, String mBody) {
        //解析xml格式数据转换成对象
        try {
            MsgHeader msgHeader = JaxbUtil.converyToJavaBean(mHeader, MsgHeader.class);
            MsgBody msgBody = JaxbUtil.converyToJavaBean(mBody, MsgBody.class);
            //获取服务名，传入对应的参数
            String serverName = msgHeader.getServerName();
            switch (serverName){
                case "name1":
                    //调用对应的服务，传入参数msgBody，然后把结果序列化成你想要的
                    Result = "name1";
                    break;
                case "name2":
                    Result = "name1";
                    break;
                default:
                    logger.info("无对应的服务");
                    Result = "error:无对应的服务";
                    break;
            }
            return Result;
        } catch (JAXBException e) {
            e.printStackTrace();
            logger.error("xml格式数据转换成对象转换错误");
            return "error:xml格式有误";
        }
    }
}
