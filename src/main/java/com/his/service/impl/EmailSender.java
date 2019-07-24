package com.his.service.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;

/**
 * Email Sender class .
 * 
 * @author laksh
 *
 */
@Component
@NoArgsConstructor
public class EmailSender {

	/**
	 * reference of java mail sender .
	 */
	@Autowired
	private JavaMailSender javaMailSender;

	/**
	 * JavaMailSender method sends email .
	 * 
	 * @param sendTo
	 * @param subject
	 * @param htmlBody
	 * @throws MessagingException
	 */
	public void sendHtml(final String sendTo, final String subject, final String htmlBody) throws MessagingException {
		final MimeMessage mail = javaMailSender.createMimeMessage();
		final MimeMessageHelper helper = new MimeMessageHelper(mail, true);
		helper.setTo(sendTo);
		helper.setSubject(subject);
		helper.setText(htmlBody, true);
		javaMailSender.send(mail);
	}
}