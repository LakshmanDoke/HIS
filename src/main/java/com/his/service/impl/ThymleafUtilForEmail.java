package com.his.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.his.model.AccountEntity;

@Component
public class ThymleafUtilForEmail {

	/**
	 * Thymeleaf template engine to thymeleaf rekated stuff .
	 */
	@Autowired
	private TemplateEngine templateEngine;
	/**
	 * this is an email sender class object to send email .
	 */
	@Autowired
	private EmailSender emailSender;
	/**
	 * Logger reference variable .
	 */
	private static final Logger LOGGER = LogManager.getLogger();

	public String getToSubBodyAccountCreation(AccountEntity accountEntity) {

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
			emailSender.sendHtml(sendTo, subject, body);
			return "SUCCESS";
		} catch (MessagingException e) {
			LOGGER.error(e.getStackTrace());
			return "FAILURE";
		}
	}
}
