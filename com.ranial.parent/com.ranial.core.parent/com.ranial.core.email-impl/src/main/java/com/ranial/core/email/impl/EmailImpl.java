package com.ranial.core.email.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ranial.core.email.api.IEmail;

public class EmailImpl implements IEmail{
	private static final transient Log LOG = LogFactory.getLog(EmailImpl.class);
	public void send(String contract) {
		LOG.info("sending email..."+contract);
		
	}
	
}
