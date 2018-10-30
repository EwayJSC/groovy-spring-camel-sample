package com.eway.sample.controller.camel.errorhandler

import groovy.util.logging.Slf4j
import org.apache.camel.builder.RouteBuilder
import org.springframework.stereotype.Component

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 10/23/18.*/

@Component
class ErrorHandlerRoute extends RouteBuilder {
    @Override
    void configure() throws Exception {
        from("direct:exception_handler")
            .doTry()
                .process(new ProcessorFail())
                .to("log:LogCategoryHere?level=WARN&showAll=true&multiline=true")
            .doCatch(Exception.class)
                .to("log:LogCategoryHere?level=WARN&showAll=true&multiline=true")
                .to("mock:error")
            .doFinally()
                .to("mock:end")
    }
}
