package com.ranial.core.mediation.router;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MediationRouter extends RouteBuilder {
	private static final transient Log LOG = LogFactory.getLog(MediationRouter.class);
	
	static final String KAFKA = "kafka:{{mediation.kafkaCluster}}?topic={{mediation.kafkaTopic}}"
			+ "&groupId={{mediation.kafkaGroup}}&zookeeperHost={{mediation.zookeeperHost}}"
			+ "&zookeeperPort={{mediation.zookeeperPort}}";
	
	
	@Override
	public void configure() throws Exception {
		LOG.info("Inside routerbuilder -----");
		from(KAFKA).log(LoggingLevel.INFO, ":::: Mediation ${body}! :::: " )
		//.setBody(simple("Mediation ${body}! \\n"))
		.choice()
			.when(xpath("/tempSensorInput/temperature > 200"))
				.log(LoggingLevel.INFO, "Temp is greater than 200 calling phone").to("bean:phoneService?method=call(${body})")
			.when(xpath("/tempSensorInput/temperature > '100'"))
				.log(LoggingLevel.INFO, "Temp Great than 100 calling email").to("bean:emailService?method=send(${body})")
			.otherwise()
			.log(LoggingLevel.INFO, "Temp is less than or equal to 100").end();

	}
}
