package com.eway.sample.controller.camel.jms

import com.eway.common.util.ExceptionUtil
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jms.core.JmsTemplate
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 10/30/18.*/


@RestController
@RequestMapping(value = "/camel/jms_producer_controller")
@Slf4j
class JmsProducerController {
    @Autowired
    JmsTemplate jmsTemplate

    @RequestMapping(value = "/")
    void get() {
        log.info("JmsProducerController get")

        try {
            jmsTemplate.convertAndSend("JmsProducerController", "My message");
        } catch (Exception e) {
            ExceptionUtil.toString(e)
        }
    }
}
