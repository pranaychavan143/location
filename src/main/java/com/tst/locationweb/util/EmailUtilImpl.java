package com.tst.locationweb.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
@Component
public class EmailUtilImpl implements EmailUtil {

	@Autowired
	private JavaMailSender sender;
	
	@Override
	public void sendEmail(String toAddress, String subject, String body) {
           MimeMessage createMimeMessage = sender.createMimeMessage();
		//MultiPurpase Internate Mail Access
		MimeMessageHelper messageHelper =new MimeMessageHelper(createMimeMessage);
		try {
			messageHelper.setTo(toAddress);
			messageHelper.setSubject(subject);
			messageHelper.setText(body);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		sender.send(createMimeMessage);
	}

}
