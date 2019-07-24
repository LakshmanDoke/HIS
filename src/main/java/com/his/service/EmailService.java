package com.his.service;

import java.io.IOException;

import com.his.model.AccountEntity;

/**
 * Email service . For sending mails .
 * 
 * @author laksh
 *
 */
public interface EmailService {
	/**
	 * sends email .
	 * 
	 * @param accountEntity
	 * @return
	 * @throws IOException
	 */
	String sendEmail(AccountEntity accountEntity) throws IOException;

}
