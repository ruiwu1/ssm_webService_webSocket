package com.commen.utils;

import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;


/**
 * 使用cxf 调用webservice 接口工具类
 */
public class CxfInvokeUtil {

    static Logger logger = Logger.getLogger(CxfInvokeUtil.class);

    /**
     *
     * 调用webservice 接口
     * @return
     *
     */
    public static synchronized Object[] invoke(String wsdlUrl,String msgHeader,String msgBody){
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        org.apache.cxf.endpoint.Client client = dcf.createClient(wsdlUrl);
        Object[] objects = null;
        String serverName = "CallInterface";
        if(StringUtils.isEmpty(wsdlUrl)){
            logger.error("cxf 调用webservice 参数缺失：wsdl url 未传入");
            return objects;
        }
        try {
            objects=client.invoke(serverName,msgHeader,msgBody);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("cxf 调用webservice 执行错误：",e);
        }
        return objects;
    }
}
