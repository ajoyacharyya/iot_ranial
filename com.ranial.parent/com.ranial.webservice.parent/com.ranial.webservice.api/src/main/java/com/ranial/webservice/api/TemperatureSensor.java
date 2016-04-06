package com.ranial.webservice.api;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
public interface TemperatureSensor {
	
	@PUT
    @Path("/{temp}")
	public void sense(@PathParam("temp") String temp);
	
	@GET
    @Path("/{deviceId}")
    public String getCurrentTemp(@PathParam("deviceId") String deviceId);
}
