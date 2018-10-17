package com.eway.event_hub.controller.camel.direct

import org.apache.camel.builder.RouteBuilder
import org.springframework.stereotype.Component

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 10/13/18.*/
@Component
class DirectConsumer2 extends RouteBuilder {
    @Override
    void configure() throws Exception {
        from("direct:secondRoute").log("JmsConsumer2 Camel body: " + body())
    }
}
