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
	
	//static final String KAFKA = "kafka:localhost:9092?topic=test&groupId=testing&autoOffsetReset=earliest&consumersCount=1";
	
	@Override
	public void configure() throws Exception {
		LOG.info("Inside routerbuilder -----");
		
		/*String zkhost = "&zookeeperHost=localhost";
	    String zkport = "&zookeeperPort=" + ZOOKEEPER_PORT;
	    String partitioner = "&partitionerClass=" + SimpleKafkaPartitioner.class.getName();
	    final String epuri = "kafka:localhost:" + KAFKA_PORT + "?topic=" + TEST_TOPIC_NAME + "&groupId=group1" + zkhost + zkport + partitioner;*/
		
		//from("direct:kaiotep").to("kafka:kaiot?zkConnect=localhost:2181&metadataBrokerList=localhost:9092&producerType=async&groupId="+ uid + KafkaConstants.DEFAULT_GROUP.value);

	    
		from(KAFKA).log(LoggingLevel.INFO, ":::: Mediation ${body}! ::::")
		.setBody(simple("Mediation ${body}! \\n"))
	.end();
			/*	.process(new Processor() {
					@Override
					public void process(Exchange exchange) throws Exception {
						String messageKey = "";
						LOG.info("Inside routerbuilder -  process -----");
						if (exchange.getIn() != null) {
							LOG.info("Inside routerbuilder -  process ---exchange.getIn() != null--");
							Message message = exchange.getIn();
							Integer partitionId = (Integer) message.getHeader(KafkaConstants.PARTITION);
							String topicName = (String) message.getHeader(KafkaConstants.TOPIC);
							if (message.getHeader(KafkaConstants.KEY) != null)
								messageKey = (String) message.getHeader(KafkaConstants.KEY);
							Object data = message.getBody();
							LOG.info("Inside routerbuilder -  process data"+data);
							LOG.info("Inside routerbuilder ------ topicName :: " + topicName + " partitionId :: " + partitionId
									+ " messageKey :: " + messageKey + " message :: " + data + "\n");
						}
					}
				}).to("log:input");*/

	}

}
