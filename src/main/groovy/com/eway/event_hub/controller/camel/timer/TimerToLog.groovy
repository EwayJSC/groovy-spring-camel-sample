package com.eway.event_hub.controller.camel.timer

import org.apache.camel.builder.RouteBuilder
import org.springframework.stereotype.Component

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 10/5/18.*/

//@Component
class TimerToLog extends RouteBuilder {
    private final String TIMER_ROUTE = "TIMER_ROUTE"

    @Override
    void configure() throws Exception {
        log.info("TimerToLogController configure()")
        from("timer:initial//start?period=10000")
                .routeId(TIMER_ROUTE)
                .to("log:executed")
                .log("timer:initial//start?period=10000 TIMER_ROUTE log:executed \n\n\n")
    }
}
