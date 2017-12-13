package com.commen.utils;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * JaxB工具类 xml和对象相互转换工具类
 * @author ruiwu
 *
 */
public class JaxbUtil {
	
	public static String convertToXml(Object obj) {
        return convertToXml(obj, "UTF-8");
    }
	
	public static String convertToXml(Object obj, String encoding) {
        String result = null;
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);// 是否省略xml头信息 

            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            result = writer.toString().replace(" standalone=\"yes\"", "");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
	
	@SuppressWarnings("unchecked")
    public static <T> T converyToJavaBean(String xml, Class<T> c)
            throws JAXBException {
        T t = null;
        JAXBContext context = JAXBContext.newInstance(c);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        t = (T) unmarshaller.unmarshal(new StringReader(xml));
        return t;
    }
}
