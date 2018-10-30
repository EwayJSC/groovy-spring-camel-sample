package com.eway.sample.controller.spring.jms

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 10/30/18.*/
@Component
class JmsPOJOReceiver {
    @JmsListener(destination = "Jms_POJO", containerFactory = "jmsListenerContainerFactory")
    void receiveMessage(Email email) {
        System.out.println("Received <" + email + ">");
    }
}
