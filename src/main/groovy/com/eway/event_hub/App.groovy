package com.eway.event_hub

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ApplicationContext

@SpringBootApplication
@Slf4j
class App {
    @Autowired
    private ApplicationContext appContext

    static void main(String[] args) {
        SpringApplication.run(App, args)
    }
}
