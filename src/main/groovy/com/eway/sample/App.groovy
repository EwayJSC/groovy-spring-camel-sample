package com.eway.sample

import org.apache.camel.CamelContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ApplicationContext
import org.springframework.jms.annotation.EnableJms

@SpringBootApplication
@EnableJms
class App {
    @Autowired
    private ApplicationContext appContext

    @Autowired
    private CamelContext camelContext

    static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(App, args)
    }
}