package com.ranial.webservice.impl;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBElement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ranial.core.mediation.api.Mediator;
import com.ranial.webservice.api.TemperatureSensor;
import com.ranial.webservice.model.TempSensorInput;

public class TemperatureSensorImpl implements TemperatureSensor{
	public static final String COMPONENT_NAME = "MediationService";
	private static final transient Log LOG = LogFactory.getLog(TemperatureSensorImpl.class);
	
	private Mediator mediator;
	
	
	public void sense(JAXBElement<TempSensorInput> input) {
		LOG.info("Sensing Temperature "+input.toString());
		LOG.info("Mediator instance in sense "+mediator);
		String xml=null;
		try {
			xml = jaxbObjectToXML(input);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			LOG.error(e.getMessage());
		}
		mediator.mediate("TEMP_SENSOR", xml);
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
	
	private static String jaxbObjectToXML(Object obj) throws UnsupportedEncodingException {

		// Write to File
		OutputStream os = new ByteArrayOutputStream();
		JAXB.marshal(obj, os);
		// m.marshal(obj, os);
		String out = new String(((ByteArrayOutputStream) os).toByteArray(), "UTF-8");
		return out;
	}
}
