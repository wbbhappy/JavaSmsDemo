package com.jsmsxx.demo.test;

import com.jsmsxx.demo.ws.Web_ServiceService;
import com.jsmsxx.demo.ws.Web_ServiceServiceLocator;
import com.jsmsxx.demo.ws.Web_ServiceServiceSoapBindingStub;
import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.net.URL;
/**
 * WebService Demo for Java
 * 参考文档《短信综合信息管理系统_WebService接口文档.doc》
 *
 */
public class WebServiceDemo {
	static String wsdlUrl = "http://112.74.76.186:8030/service/webService/Web_Service";
	//帐号
	static String account = "JSM42755";
	//密码
	static String password = "0zv1u1og";
	//校验码
	static String checkCode = "4wjykdxz17uh";
	
	public static Web_ServiceServiceSoapBindingStub getSmsService(){
		Web_ServiceServiceSoapBindingStub stub  = null;
		try {
			Web_ServiceService service  = new Web_ServiceServiceLocator();
			stub = (Web_ServiceServiceSoapBindingStub)service.getWeb_ServicePort( new URL(wsdlUrl));
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch(MalformedURLException e){
			e.printStackTrace();
		}
		return stub;
	}
	/**
	 * 创建获取余额的xml参数
	 * @return
	 */
	public static String createGetBalanceXml(){
		StringBuilder xmlParams = new StringBuilder();
		xmlParams.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		xmlParams.append("<root>");
		xmlParams.append("<username>").append(account).append("</username>");
		xmlParams.append("<password>").append(password).append("</password>");
		xmlParams.append("<veryCode>").append(checkCode).append("</veryCode>");
		xmlParams.append("</root>");
		
		return xmlParams.toString();
	}
	/**
	 * 创建发送模版短信(短信模版的创建参考客户端操作手册)的xml参数
	 * 
	 *   模版：@1@会员，动态验证码@2@(五分钟内有效)。请注意保密，勿将验证码告知他人。
	 *   参数值:@1@=member,@2@=4293
	 *   手机接收内容：【短信签名】member会员，动态验证码4293(五分钟内有效)。请注意保密，勿将验证码告知他人。
	 * 
	 * @param mobile 手机号码
	 * @param tempId 模版编号，对应客户端模版编号
	 * @param content 各参数值，以英文逗号隔开，如：@1@=member,@2@=4293
	 * @return
	 */
	public static String createTemplateSmsXml(String mobile,String tempId,String content){
		StringBuilder xmlParams = new StringBuilder();
		xmlParams.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		xmlParams.append("<root>");
		xmlParams.append("<username>").append(account).append("</username>");
		xmlParams.append("<password>").append(password).append("</password>");
		xmlParams.append("<veryCode>").append(checkCode).append("</veryCode>");
		xmlParams.append("<mobile>").append(mobile).append("</mobile>");
		xmlParams.append("<content>").append(content).append("</content>");
		xmlParams.append("<extcode></extcode>");
		xmlParams.append("<sendtime></sendtime>");
		xmlParams.append("<msgtype>2</msgtype>");
		xmlParams.append("<signtext></signtext>");
		xmlParams.append("<tempid>").append(tempId).append("</tempid>");
		xmlParams.append("</root>");
				
		return xmlParams.toString();
	}
	/**
	 * 创建发送普通短信的xml参数
	 * @param mobile 手机号码
	 * @param content 短信内容
	 * @return
	 */
	public static String createTextSmsXml(String mobile,String content){
		StringBuilder xmlParams = new StringBuilder();
		xmlParams.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		xmlParams.append("<root>");
		xmlParams.append("<username>").append(account).append("</username>");
		xmlParams.append("<password>").append(password).append("</password>");
		xmlParams.append("<veryCode>").append(checkCode).append("</veryCode>");
		xmlParams.append("<mobile>").append(mobile).append("</mobile>");
		xmlParams.append("<content>").append(content).append("</content>");
		xmlParams.append("<extcode></extcode>");
		xmlParams.append("<signtext></signtext>");
		xmlParams.append("<sendtime></sendtime>");
		xmlParams.append("<msgtype>1</msgtype>");
		xmlParams.append("</root>");
		return xmlParams.toString();
	}
	/**
	 * 创建获取短信状态报告的xml参数
	 * @return
	 */
	public static String createQueryReportXml(){
		StringBuilder xmlParams = new StringBuilder();
		xmlParams.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		xmlParams.append("<root>");
		xmlParams.append("<username>").append(account).append("</username>");
		xmlParams.append("<password>").append(password).append("</password>");
		xmlParams.append("<veryCode>").append(checkCode).append("</veryCode>");
		xmlParams.append("</root>");
		return xmlParams.toString();
	}
	/**
	 * 创建获取上行短信的xml参数
	 * @return
	 */
	public static String createQueryMoXml(){
		StringBuilder xmlParams = new StringBuilder();
		xmlParams.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		xmlParams.append("<root>");
		xmlParams.append("<username>").append(account).append("</username>");
		xmlParams.append("<password>").append(password).append("</password>");
		xmlParams.append("<veryCode>").append(checkCode).append("</veryCode>");
		xmlParams.append("</root>");
		return xmlParams.toString();
	}
	public static void main(String[] args) throws Exception {
		//查询账号余额
		//System.out.println(getSmsService().getAmount(createGetBalanceXml()));
		//发送普通短信，修改接收短信的手机号码及短信内容,多个号码以英文逗号隔开，最多支持100个号码
		//System.out.println(getSmsService().sendMsg(createTextSmsXml("159********","您的验证码是8888,请注意保密，勿将验证码告知他人。")));
		//发送模板短信，修改接收短信的手机号码及调用的模板编号
		System.out.println(getSmsService().sendMsg(createTemplateSmsXml("15100317880","JSM42755-0001","@1@=331,@2@=asdd")));
		//查询下发短信的状态报告
		System.out.println(getSmsService().queryReport(createQueryReportXml()));
		//查询上行回复短信
		//System.out.println(getSmsService().queryMo(createQueryMoXml()));
	}
}
