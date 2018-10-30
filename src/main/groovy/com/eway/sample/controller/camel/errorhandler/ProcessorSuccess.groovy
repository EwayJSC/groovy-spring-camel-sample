package com.eway.sample.controller.camel.errorhandler

import groovy.util.logging.Slf4j
import org.apache.camel.Exchange
import org.apache.camel.Processor

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 10/23/18.*/
@Slf4j
class ProcessorSuccess implements Processor{
    @Override
    void process(Exchange exchange) throws Exception {
        String payload = exchange.getIn().getBody(String.class)
        log.info("ProcessorSuccess exchange payload" + payload)
        payload = "I'm new"
        exchange.getIn().setBody(payload.toString())
    }
}
