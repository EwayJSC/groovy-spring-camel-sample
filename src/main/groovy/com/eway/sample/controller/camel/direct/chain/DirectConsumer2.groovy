package com.eway.sample.controller.camel.direct.chain

import org.apache.camel.builder.RouteBuilder
import org.springframework.stereotype.Component

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 10/13/18.*/
@Component
class DirectConsumer2 extends RouteBuilder {
    @Override
    void configure() throws Exception {
        from("direct:chain2").log("DirectConsumer2 Camel body: " + body())
    }
}
