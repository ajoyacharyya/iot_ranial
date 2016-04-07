package com.ranial.webservice.impl;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ranial.core.mediation.api.Mediator;
import com.ranial.webservice.api.TemperatureSensor;

public class TemperatureSensorImpl implements TemperatureSensor{
	public static final String COMPONENT_NAME = "MediationService";
	private static final transient Log LOG = LogFactory.getLog(TemperatureSensorImpl.class);
	
	private Mediator mediator;
	
	
	public void sense(String temp) {
		LOG.info("Sensing Temperature "+temp);
		LOG.info("Mediator instance in sense "+mediator);
		mediator.mediate("TEMP_SENSOR", temp);
	}

	public String getCurrentTemp(String deviceId) {
		double current = Integer.parseInt(deviceId)*0.1;
		LOG.info("Current Temperature "+current);
		return ""+current;
	}
	
	
	public Mediator getMediator() {
		LOG.info("Getting mediator ");
		return mediator;
	}
	
	
	public void setMediator(Mediator mediator) {
		LOG.info("Setting mediator ");
		this.mediator = mediator;
	}
	
	public void startup(){
		LOG.info("Mediator instance "+mediator);
	}
	
	public void bindMediator(Mediator mediator, Map prop) {
		LOG.info("Bind mediator "+mediator);
		this.mediator=mediator;
	}
	
	
	public void unbindMediator(Mediator mediator, Map prop) {
		LOG.info("un Bind mediator ");
		this.mediator=null;
	}
}
