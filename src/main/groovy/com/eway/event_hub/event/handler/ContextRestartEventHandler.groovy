package com.eway.event_hub.event.handler

import groovy.util.logging.Slf4j
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 9/4/18.*/
@Slf4j
class ContextRestartEventHandler implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("ContextRefreshedEvent received");
    }
}
