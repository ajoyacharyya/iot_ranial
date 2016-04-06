package com.ranial.core.phone.call.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ranial.core.phone.call.api.IPhoneCall;

public class CallPhoneImpl implements IPhoneCall{
	private static final transient Log LOG = LogFactory.getLog(CallPhoneImpl.class);
	@Override
	public void call(String to) {
		LOG.info("Calling phone ...");
		
	}

}
