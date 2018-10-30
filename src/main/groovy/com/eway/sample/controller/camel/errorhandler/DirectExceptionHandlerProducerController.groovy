package com.eway.sample.controller.camel.errorhandler

import groovy.util.logging.Slf4j
import org.apache.camel.ProducerTemplate

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 10/13/18.*/

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/camel/direct_exception_handler_producer_controller")
@Slf4j
class DirectExceptionHandlerProducerController {
    @Autowired
    ProducerTemplate producerTemplate

    @RequestMapping(value = "/")
    void get() {
        log.info("DirectExceptionHandlerProducerController get")
        producerTemplate.sendBody("direct:exception_handler", "Calling via Spring Boot Rest Controller")
    }
}
