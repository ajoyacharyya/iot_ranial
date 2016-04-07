package com.ranial.webservice.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.ranial.webservice.api.TemperatureSensor;

public class Activator implements BundleActivator {
	private ServiceRegistration serviceRegistration;

	public void start(final BundleContext context) throws Exception {
		serviceRegistration = context.registerService(TemperatureSensor.class.getName(), new TemperatureSensorImpl(), null);
	}

	public void stop(final BundleContext context) throws Exception {
		serviceRegistration.unregister();
	}
}