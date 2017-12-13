package com.webservice.cxf_webService;

import javax.jws.WebService;

/**
 * 此处定义一个demo
 *  接口只提供一个WebService 方法（方法名）作为所有数据交互接口，数据的收发采用XML字符串格式。
 *      例:string CallInterface(string msgHeader,string msgBody)
 * 例:msgHeader
 *<?xml version="1.0" encoding="utf-8"?>
 *<root>
 *  <serverName>服务名 </serverName>
 *  <format>xml</format>
 *  <callOperator>调用操作者</callOperator>
 *  <certificate>凭证号</certificate>
 *</root>
 * 例:msgBody
 *  同msgHeader，传入msgHeader中服务名对应的xml格式数据
*/
@WebService
public interface DemoWebService {
     String CallInterface(String msgHeader,String msgBody);
}
