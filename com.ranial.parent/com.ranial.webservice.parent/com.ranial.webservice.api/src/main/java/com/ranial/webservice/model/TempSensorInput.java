package com.ranial.webservice.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TempSensorInput {
	
	private String deviceId;
	private String temperature;
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	
	@Override
	public String toString() {
		return "deviceId - "+deviceId+" temperature - "+temperature;
	}
	

}
