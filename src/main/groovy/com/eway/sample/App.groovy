package com.eway.sample

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ApplicationContext
import org.springframework.jms.core.JmsTemplate

//CHECKSTYLE:OFF
@SpringBootApplication
class App {
    @Autowired
    private ApplicationContext appContext

    static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(App, args)
    }
}
//CHECKSTYLE:ON