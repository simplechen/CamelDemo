package me.laochen.camel;

import me.laochen.camel.processor.MyBookService;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * website:http://marcelojabali.blogspot.hk/2011/10/using-http-based-endpoints-with-apache.html
 * @author laochen
 *
 */
public class JettyHttpMain extends Main {
	static Logger LOG = LoggerFactory.getLogger(JettyHttpMain.class);
//http://localhost:8888/myBookService?bookid=91942
	public static void main(String[] args) throws Exception {
		System.err.println("you can call:http://localhost:8888/myBookService?bookid=91942");
		JettyHttpMain main = new JettyHttpMain();
		main.enableHangupSupport();
		main.bind("myBookService", new MyBookService());
		main.addRouteBuilder(createRouteBuilder());
		main.run(args);
	}

	static RouteBuilder createRouteBuilder() {
		return new RouteBuilder() {
			public void configure() {
				from("jetty:http://localhost:8888/myBookService")
				.to("bean:myBookService");
			}
		};
	}
}
