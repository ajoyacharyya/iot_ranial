package com.ranial.core.email.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ranial.core.email.api.IEmail;
import com.ranial.core.email.model.EmailContract;

public class EmailImpl implements IEmail{
	private static final transient Log LOG = LogFactory.getLog(EmailImpl.class);
	@Override
	public void send(EmailContract contract) {
		LOG.info("sending email...");
		
	}
	
}
