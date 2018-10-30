package com.eway.sample.controller.spring.jms

import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 10/30/18.*/
@Component
class JmsTextReceiver {
    @JmsListener(destination = "Jms_Text", containerFactory = "jmsListenerContainerFactory")
    void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }
}
