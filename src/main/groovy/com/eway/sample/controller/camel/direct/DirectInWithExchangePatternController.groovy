package com.eway.sample.controller.camel.direct

import com.eway.common.util.ExceptionUtil
import groovy.util.logging.Slf4j
import org.apache.camel.ExchangePattern

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 10/13/18.*/

import org.apache.camel.ProducerTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/camel/direct_with_exchange_pattern_controller")
@Slf4j
class DirectInWithExchangePatternController {
    @Autowired
    ProducerTemplate producerTemplate

    @RequestMapping(value = "/")
    void get() {
        log.info("DirectInOnlyController get")

        try {
            producerTemplate.sendBody("direct:with_exchange_pattern", ExchangePattern.InOnly, "Calling via Spring Boot Rest Controller")
        } catch (Exception e) {
            ExceptionUtil.toString(e)
        }
    }
}
