package com.eway.sample.controller.camel.timer

import org.apache.camel.builder.RouteBuilder
import org.springframework.stereotype.Component

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 10/5/18.*/

//@Component
class TimerToLogRoute extends RouteBuilder {
    private final String TIMER_ROUTE = "TIMER_ROUTE"

    @Override
    void configure() throws Exception {
        log.info("TimerToLogController configure()")
        from("timer:initial//start?period=60000")
                .routeId(TIMER_ROUTE)
                .to("log:LogCategoryHere?level=WARN&showAll=true&multiline=true")
    }
}
