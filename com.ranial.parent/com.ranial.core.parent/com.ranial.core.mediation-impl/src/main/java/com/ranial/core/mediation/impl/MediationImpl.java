package com.ranial.core.mediation.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ranial.core.mediation.api.Mediator;
import com.ranial.core.mediation.camel.MediationProducer;

public class MediationImpl implements Mediator{
	//public static final String COMPONENT_NAME = "MediationService";
	private static final transient Log LOG = LogFactory.getLog(MediationImpl.class);
	public void mediate(String soureceType, Object input) {
		LOG.info("In the mediation component" +soureceType+" "+input);
		new MediationProducer().publishMessage(soureceType, input.toString());
	}
	public void startup(){
		LOG.info("Mediator server started");
	}

}
