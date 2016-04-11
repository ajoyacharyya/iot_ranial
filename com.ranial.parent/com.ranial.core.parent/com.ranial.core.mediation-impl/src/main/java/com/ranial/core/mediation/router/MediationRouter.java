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
		.to("bean:convertXMLToMap?method=convert(${body})")
		.log(LoggingLevel.INFO, ":::: After MAP ${body}! :::: " )
		.to("bean:ruleExecutor?method=execute(${body})")
		.log(LoggingLevel.INFO, ":::: After Rule exec ${body}! :::: " )
		.choice()
		  	.when().simple("${body[router1]} == true")
				.log(LoggingLevel.INFO, "Temp is greater than 200 calling phone").to("bean:phoneService?method=call(temp>200)")
			.when().simple("${body[router2]} == true")
				.log(LoggingLevel.INFO, "Temp Great than 100 and less than 200 calling email").to("bean:emailService?method=send(temp < 200)")
			.otherwise()
			.log(LoggingLevel.INFO, "Temp is less than or equal to 100")
			.end();
		
		

	}
}
