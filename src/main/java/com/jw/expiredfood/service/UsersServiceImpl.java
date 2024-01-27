package com.jw.expiredfood.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jw.expiredfood.bean.Users;
import com.jw.expiredfood.dao.UsersDAO;


@Component
public class UsersServiceImpl implements UsersService {

	@Autowired
	UsersDAO usersDao;
	
	@Override
	public String register(Users user) {
		Users userInfo = usersDao.qryUser(user.getAccount());
		if (userInfo != null) {
			return "2";//該帳號已被註冊!
		}
		if (!user.getPassword().equals(user.getConfirm_password())) {
			return "3";//請確認密碼!
		} 
		if (usersDao.updateUser(user) == 1) {
			return "0";//恭喜你註冊成功!
		} else {
			return "1"; //註冊失敗!
		}
	}

	@Override
	public String verify(Users user) {
		if (usersDao.addUser(user) == 1) {
			Users userInfo = usersDao.qryUser(user.getAccount());
			// 加密
			// user_id|email
			String param = userInfo.getUser_id()+"|"+userInfo.getEmail();
			sendMail(userInfo.getEmail(), userInfo.getFirst_name()+userInfo.getLast_name(), param);
		}
		return "0"; // 已發送至您的Email
	}

	@Override
	public boolean checkAccountDuplicate(String account) {
		Users userInfo = usersDao.qryUser(account);
		if (userInfo != null) {
			return true; // 帳號重覆
		} else {
			return false;
		}
	}
	
	
	public void sendMail(String to, String user_name, String param) {

		try {
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
			
			final String myGmail = "wen821107@gmail.com";
			final String myGmail_password = "qeiy tamq qazn leqp";

			Session session = Session.getInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(myGmail, myGmail_password);
				}
			});

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myGmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			String subject = "Expired Food 驗證";
			String messageText = "親愛的"+user_name+"您好：<br>請點擊該網址做驗證："+"http://localhost:8080/user_confirm?p="+param;
			message.setSubject(subject);
			message.setText(messageText);

			Transport.send(message);

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}
	
}
