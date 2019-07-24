package com.his.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This is EmailAvailableException class which throws when user trying to insert
 * email which is already available .
 * 
 * @author laksh
 *
 */
public class EmailAvailableException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6729798683806693784L;
	/**
	 * Logger variable to use logger .
	 */
	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Constructor which shows exception with user given email which is already
	 * available .
	 * 
	 * @param email
	 */
	public EmailAvailableException(final String email) {
		super("Email :" + email + " is available already ! We can not add Duplicate Email .");
		LOGGER.error("Email :" + email + " is available already ! We can not add Duplicate Email .");
	}
}
