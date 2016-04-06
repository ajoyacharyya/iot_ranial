package com.ranial.core.email.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.ranial.core.email.api.IEmail;

public class Activator implements BundleActivator {
	private ServiceRegistration serviceRegistration;

	public void start(final BundleContext context) throws Exception {
		serviceRegistration = context.registerService(IEmail.class.getName(), new EmailImpl(), null);
	}

	public void stop(final BundleContext context) throws Exception {
		serviceRegistration.unregister();
	}
}