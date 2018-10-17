package com.eway.event_hub.controller.camel.file

import groovy.util.logging.Slf4j
import org.apache.camel.builder.RouteBuilder
import org.springframework.stereotype.Component

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 10/13/18.*/

@Component
class FileToFile extends RouteBuilder {
    @Override
    void configure() throws Exception {
        log.info("FileToFileController configure()")
        from("file:data/inbox?noop=true")
                .to("file:data/outbox")
    }
}