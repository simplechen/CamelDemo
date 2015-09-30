package me.laochen.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyBookService implements Processor {
	static Logger LOG = LoggerFactory.getLogger(MyBookService.class);
	public void process(Exchange exchange) throws Exception {
		LOG.error("start parse html");
		// Grab the booked header value
		String bookId = (String) exchange.getIn().getHeader("bookid");
		// send a html response
		exchange.getOut().setBody(
				"<html><body><font color=red>Book " + bookId
						+ "</font> is Camel in Action.</body></html>");
	}
}