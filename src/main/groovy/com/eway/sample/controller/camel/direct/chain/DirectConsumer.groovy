package com.eway.sample.controller.camel.direct.chain

import org.apache.camel.builder.RouteBuilder
import org.springframework.stereotype.Component

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 10/13/18.*/
@Component
class DirectConsumer extends RouteBuilder {
    @Override
    void configure() throws Exception {
        from("direct:chain")
                .log("DirectConsumer Camel body: " + body())
                .to("direct:chain2")
    }
}
