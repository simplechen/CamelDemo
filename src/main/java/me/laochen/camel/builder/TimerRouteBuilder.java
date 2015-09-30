package me.laochen.camel.builder;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimerRouteBuilder extends RouteBuilder {
	static Logger LOG = LoggerFactory.getLogger(TimerRouteBuilder.class);

	public void configure() {
		from("timer://timer3?period=2000").process(new Processor() {
			public void process(Exchange msg) {
				LOG.info("Processing {}", msg);
			}
		});
	}
}