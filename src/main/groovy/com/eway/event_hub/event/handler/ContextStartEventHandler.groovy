package com.eway.event_hub.event.handler

import groovy.util.logging.Slf4j

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 9/4/18.*/
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

@Slf4j
class ContextStartEventHandler implements ApplicationListener<ContextStartedEvent> {
    @Override
    void onApplicationEvent(ContextStartedEvent event) {
        log.info("ContextStartedEvent received");
    }
}
