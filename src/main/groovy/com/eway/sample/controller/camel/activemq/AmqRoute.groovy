package com.eway.sample.controller.camel.activemq

import org.apache.camel.builder.RouteBuilder
import org.springframework.stereotype.Component

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 10/29/18.*/
@Component
class AmqRoute extends RouteBuilder {
    @Override
    void configure() throws Exception {
//        from("jms:foo").to("log:sample")
//        from("timer:bar").setBody(constant("Hello from Camel")).to("activemq:foo")
    }
}
