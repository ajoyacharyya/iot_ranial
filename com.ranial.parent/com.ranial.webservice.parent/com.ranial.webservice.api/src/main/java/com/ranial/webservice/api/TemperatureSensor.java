package com.ranial.webservice.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import com.ranial.webservice.model.TempSensorInput;


public interface TemperatureSensor {
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public void sense(JAXBElement<TempSensorInput> input);
	
	@GET
    @Path("/{deviceId}")
	@Produces(MediaType.APPLICATION_JSON)
    public String getCurrentTemp(@PathParam("deviceId") String deviceId);
}
