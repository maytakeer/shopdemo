package com.woniuxy.shop.tools;


import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.AddressException;

public class SendMail { 
	//发送的邮箱地址（该邮件由谁发送）
	public final static String sender ="15181325737@163.com";
	//钥匙，有了钥匙邮件系统才能知道你是有权限用该邮箱发送邮件的
	public final static String key="123456abcdef";
	public static void main(String[] args){       
		try {
			new SendMail().send("", "邮件测试", "你已经成功购买了GirlCloset中的商品！");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**
	 * 
	 * @param receiver 邮件接收方
	 * @param title 邮件标题
	 * @param content 邮件正文
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public void send(String receiver, String title, String content) throws AddressException,MessagingException {
		Properties properties = new Properties();

		properties.put("mail.transport.protocol", "smtp");// 连接协议        

		properties.put("mail.smtp.host", "smtp.163.com");// 主机名        

		properties.put("mail.smtp.port", 25);// 端口号        

		properties.put("mail.smtp.auth", "true");        

//		properties.put("mail.smtp.ssl.enable", "true");//设置是否使用ssl安全连接  ---一般都使用        

		properties.put("mail.debug", "true");//设置是否显示debug信息  true 会在控制台显示相关信息        

		//得到回话对象        

		Session session = Session.getInstance(properties);        

		// 获取邮件对象        

		Message message = new MimeMessage(session);        

		//设置发件人邮箱地址       

		message.setFrom(new InternetAddress(sender));       

		//设置收件人地址       
		message.setRecipients(RecipientType.TO,new InternetAddress[] { new InternetAddress(receiver) });       

		//设置邮件标题        

		message.setSubject(title);        

		//设置邮件内容        

		message.setText(content);       

		//得到邮差对象        

		Transport transport = session.getTransport();        

		//连接自己的邮箱账户        

		transport.connect(sender, key);//密码为刚才得到的授权码        

		//发送邮件        
		transport.sendMessage(message, message.getAllRecipients()); 
	}

}


