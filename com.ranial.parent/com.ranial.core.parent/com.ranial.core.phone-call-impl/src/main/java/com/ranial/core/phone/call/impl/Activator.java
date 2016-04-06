package com.ranial.core.phone.call.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.ranial.core.phone.call.api.IPhoneCall;

public class Activator implements BundleActivator {
	private ServiceRegistration serviceRegistration;

	public void start(final BundleContext context) throws Exception {
		serviceRegistration = context.registerService(IPhoneCall.class.getName(), new CallPhoneImpl(), null);
	}

	public void stop(final BundleContext context) throws Exception {
		serviceRegistration.unregister();
	}
}