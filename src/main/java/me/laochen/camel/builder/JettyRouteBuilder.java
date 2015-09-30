package me.laochen.camel.builder;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JettyRouteBuilder extends RouteBuilder {
	static Logger LOG = LoggerFactory.getLogger(JettyRouteBuilder.class);

	public void configure() {
		from("jetty:http://localhost:8888/myBookService");
	}
}