package com.eway.event_hub.controller.camel.direct

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 10/13/18.*/

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class DirectProducerController {
    @Autowired
    ProducerTemplate producerTemplate

    @RequestMapping(value = "/producer")
    void reveive() {
        producerTemplate.sendBody("direct:firstRoute", "Calling via Spring Boot Rest Controller");
    }
}
