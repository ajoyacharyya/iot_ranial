package com.ranial.core.mediation.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	private ServiceRegistration serviceRegistration;

	public void start(final BundleContext context) throws Exception {
		//serviceRegistration = context.registerService(Mediator.class.getName(), new MediationImpl(), null);
	}

	public void stop(final BundleContext context) throws Exception {
		//serviceRegistration.unregister();
	}
}