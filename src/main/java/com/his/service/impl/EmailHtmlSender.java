package com.his.service.impl;

import javax.mail.MessagingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.his.model.AccountEntity;

import lombok.NoArgsConstructor;

/**
 * This is an HtmlEmail sender class here we set html related data into email .
 * 
 * @author laksh
 *
 */
@Component
@NoArgsConstructor
public class EmailHtmlSender {
	/**
	 * Logger reference variable .
	 */
	private static final Logger LOGGER = LogManager.getLogger();
	/**
	 * this is an email sender class object to send email .
	 */
	@Autowired
	private EmailSender emailSender;

	/**
	 * Thymeleaf template engine to thymeleaf rekated stuff .
	 */
	@Autowired
	private TemplateEngine templateEngine;

	/**
	 * It returns the status of email is it sent or not .
	 */
	private  String sendStatus = null;

	/**
	 * 
	 * @param accountEntity
	 * @return
	 */
	public String sendHtml(final AccountEntity accountEntity) {
		final String sendTo = accountEntity.getEmail();
		final String subject = "Account Creation Details";
		final String templateName = "emailTemplate.html";

		final Context context = new Context();
		context.setVariable("FNAME", accountEntity.getFirstName());
		context.setVariable("LNAME", accountEntity.getLastName());
		context.setVariable("EMAIL", accountEntity.getEmail());
		context.setVariable("URL", "Localhost:8080/his/login");
		context.setVariable("PWD", accountEntity.getPassword());
		context.setVariable("ROLE", accountEntity.getRole());
		context.setVariable("PHNO", "+91-9172969709");

		final String body = templateEngine.process(templateName, context);
		try {
			sendStatus = "SUCCESS";
			emailSender.sendHtml(sendTo, subject, body);
		} catch (MessagingException e) {
			sendStatus = "FAILURE";
			LOGGER.error(e.getStackTrace());
		}

		return sendStatus;

	}
	
	

}