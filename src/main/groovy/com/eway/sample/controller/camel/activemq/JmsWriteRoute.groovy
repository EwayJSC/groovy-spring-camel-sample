package com.eway.sample.controller.camel.activemq

import org.apache.camel.builder.RouteBuilder
import org.springframework.stereotype.Component;

import static org.apache.activemq.camel.component.ActiveMQComponent.activeMQComponent;

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 10/31/18.*/
@Component
class JmsWriteRoute extends RouteBuilder {
    void configure() throws Exception {
        from("direct:testWriteQueue")
                .to("log:?level=INFO&showBody=true")
                .to("activemq:queue:testWriteQueue")
    }
}
