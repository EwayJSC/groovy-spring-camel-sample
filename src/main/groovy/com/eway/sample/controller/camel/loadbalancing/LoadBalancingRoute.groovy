package com.eway.sample.controller.camel.loadbalancing

import org.apache.camel.builder.RouteBuilder
import org.springframework.stereotype.Component

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 10/29/18.*/

@Component
class LoadBalancingRoute extends RouteBuilder {
    @Override
    void configure() throws Exception {
        from("file:/data/groovy-spring-camel-sample/inbox?noop=true").split().tokenize("\n")
                .loadBalance().roundRobin()
                .to("direct:javainuse1")
                .to("direct:javainuse2")
                .to("direct:javainuse3")
    }
}
