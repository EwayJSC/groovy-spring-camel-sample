package com.eway.sample.config

import org.apache.activemq.camel.component.ActiveMQComponent
import org.apache.camel.CamelContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 10/31/18.*/
class ActivemqConfig {
    @Autowired
    CamelContext camelContext

    @Bean
    void jmsComponent(){
        camelContext.addComponent("activemq", ActiveMQComponent.activeMQComponent("tcp://localhost:61616"))Ư
    }
}
