package com.eway.event_hub.business.invoker

import groovy.util.logging.Slf4j
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 9/18/18.*/

@Component
@Slf4j
class CollectorBusinessInvoker {
    boolean receive(Map<String, Object> payload) {
        log.info("CollectorBusiness receive payload :" + payload)

        def serviceName = payload.get("service")
        log.info("serviceName: " + serviceName)

        def eventName = payload.get("event")
        log.info("eventName: " + eventName)

        return true
    }
}
