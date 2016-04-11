package com.ranial.core.mediation.drools;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class RuleExecutor {
	private static KieSession ksession;
	private static final transient Log LOG = LogFactory.getLog(RuleExecutor.class);

	public Map<String, String> execute(Map<String, String> body) {
		if (ksession == null) {
			KieServices ks = KieServices.Factory.get();
			KieContainer kcont = ks.newKieClasspathContainer(getClass().getClassLoader());
			KieBase kbase = kcont.getKieBase("sampleKBase");
			ksession = kbase.newKieSession();
			LOG.info("KieSession created. " + ksession);
		}

		
		ksession.insert(body);
		ksession.fireAllRules();
		LOG.info("After rule execution body. " + body);
		return body;
	}

}
