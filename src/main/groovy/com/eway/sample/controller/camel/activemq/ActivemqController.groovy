package com.eway.sample.controller.camel.activemq

import com.eway.common.util.ExceptionUtil
import groovy.util.logging.Slf4j
import org.apache.camel.ExchangePattern
import org.apache.camel.ProducerTemplate

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 10/13/18.*/

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/camel/activemq_controller")
@Slf4j
class ActivemqController {
    @Autowired
    ProducerTemplate producerTemplate

    @RequestMapping(value = "/")
    void get() {
        log.info("ActivemqController get")

        try {
            producerTemplate.sendBody("direct:testWriteQueue", ExchangePattern.InOnly, "testWriteQueue Message")
        } catch (Exception e) {
            ExceptionUtil.toString(e)
        }
    }
}
