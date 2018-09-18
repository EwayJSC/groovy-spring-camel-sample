package com.eway.event_hub.event.handler

import groovy.util.logging.Slf4j
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextStoppedEvent

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 9/4/18.*/
@Slf4j
class ContextStopEventHandler implements ApplicationListener<ContextStoppedEvent> {
    @Override
    void onApplicationEvent(ContextStoppedEvent event) {
        log.info("ContextStoppedEvent Received");
    }
}
