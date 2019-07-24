package com.his.service.impl;

import java.io.IOException;
import java.util.Optional;

import javax.mail.MessagingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.his.model.AccountEntity;
import com.his.model.ForgotPassModel;
import com.his.repository.AccountEntityRepository;
import com.his.service.EmailService;

import lombok.NoArgsConstructor;

/**
 * Email service implementation class .
 * 
 * @author laksh
 *
 */
@RestController
@NoArgsConstructor
public class EmailServiceImpl implements EmailService {

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
	private String sendStatus = null;

	/**
	 * 
	 * @param accountEntity
	 * @return
	 */

	@Autowired
	private AccountEntityRepository accountEntityRepository;

	@Override
	public String sendEmail(final AccountEntity accountEntity) throws IOException {

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

	public String sendEmailForForgotPass(ForgotPassModel forgotpass) {
		final String sendTo = forgotpass.getEmail();
		final String subject = "Password Recovery ";
		final String templateName = "PasswordRecoveryTemplate.html";

		Optional<AccountEntity> accountentityopt = accountEntityRepository.getAccountByEmail(forgotpass.getEmail());

		final Context context = new Context();
		if (accountentityopt.isPresent()) {
			context.setVariable("FNAME", accountentityopt.get().getFirstName());
			context.setVariable("LNAME", accountentityopt.get().getLastName());
			context.setVariable("EMAIL", accountentityopt.get().getEmail());
			context.setVariable("URL", "Localhost:8080/his/login");
			context.setVariable("PWD", accountentityopt.get().getPassword());
			context.setVariable("PHNO", "+91-9172969709");

			final String body = templateEngine.process(templateName, context);
			try {
				sendStatus = "SUCCESS";
				emailSender.sendHtml(sendTo, subject, body);
			} catch (MessagingException e) {
				sendStatus = "FAILURE";
				LOGGER.error(e.getStackTrace());
			}
		}else {
			sendStatus = "FAILURE";
		}
		return sendStatus;

	}

}
