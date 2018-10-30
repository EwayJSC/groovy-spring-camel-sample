package com.eway.sample.business

import groovy.util.logging.Slf4j
import org.springframework.stereotype.Component

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 9/18/18.*/

@Component
@Slf4j
class SampleBusiness {
    boolean post(Map<String, Object> payload) {
        log.info("CollectorBusiness receive payload :" + payload)

        def serviceName = payload.get("service")
        log.info("serviceName: " + serviceName)

        def eventName = payload.get("event")
        log.info("eventName: " + eventName)

        return true
    }
}
