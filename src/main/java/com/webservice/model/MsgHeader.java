package com.webservice.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author ruiwu
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "root")
@XmlType(propOrder={"serverName","format","callOperator","certificate","msgNo","sendTime","sendCount"})
public class MsgHeader implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "serverName")
	private String serverName; //服务名
	
	@XmlElement(name = "format")
	private String format; //格式，这里填xml 
	
	@XmlElement(name = "callOperator")
	private String callOperator; //调用操作者
	
	@XmlElement(name = "certificate")
	private String certificate; //凭证号

	@XmlElement(name = "msgNo")
	private String msgNo; //消息唯一标识：GUID

	@XmlElement(name = "sendTime")
	private String sendTime; //消息发送时间：YYYY-MM-DD HH:MM:SS

	@XmlElement(name = "sendCount")
	private String sendCount; //消息发送次数：（0，1，2…..）0--首次发送，1--第一次重发

	public MsgHeader() {
		super();
	}

	public MsgHeader(String serverName, String format, String callOperator, String certificate, String msgNo, String sendTime, String sendCount) {
		this.serverName = serverName;
		this.format = format;
		this.callOperator = callOperator;
		this.certificate = certificate;
		this.msgNo = msgNo;
		this.sendTime = sendTime;
		this.sendCount = sendCount;
	}



	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getCallOperator() {
		return callOperator;
	}

	public void setCallOperator(String callOperator) {
		this.callOperator = callOperator;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public String getMsgNo() {
		return msgNo;
	}

	public void setMsgNo(String msgNo) {
		this.msgNo = msgNo;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getSendCount() {
		return sendCount;
	}

	public void setSendCount(String sendCount) {
		this.sendCount = sendCount;
	}

	@Override
	public String toString() {
		return "MsgHeader{" +
				"serverName='" + serverName + '\'' +
				", format='" + format + '\'' +
				", callOperator='" + callOperator + '\'' +
				", certificate='" + certificate + '\'' +
				", msgNo='" + msgNo + '\'' +
				", sendTime='" + sendTime + '\'' +
				", sendCount='" + sendCount + '\'' +
				'}';
	}
}
