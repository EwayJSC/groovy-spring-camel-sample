package com.eway.sample.controller.camel.file


import org.apache.camel.builder.RouteBuilder
import org.springframework.stereotype.Component

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 10/13/18.*/

@Component
class FileToFileRoute extends RouteBuilder {
    @Override
    void configure() throws Exception {
        log.info("FileToFileController configure()")
        from("file:file/inbox?noop=true")
                .to("file:file/outbox")
    }
}