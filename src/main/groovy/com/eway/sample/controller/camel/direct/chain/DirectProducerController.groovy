package com.eway.sample.controller.camel.direct.chain

import groovy.util.logging.Slf4j

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 10/13/18.*/

import org.apache.camel.ProducerTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/camel/direct_producer_controller")
@Slf4j
class DirectProducerController {
    @Autowired
    ProducerTemplate producerTemplate

    @RequestMapping(value = "/")
    void get() {
        log.info("DirectProducerController get")
        producerTemplate.sendBody("direct:chain", "Calling via Spring Boot Rest Controller")
    }
}
