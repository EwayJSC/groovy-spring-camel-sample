package com.eway.sample.config

import org.apache.activemq.spring.ActiveMQConnectionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jms.config.DefaultJmsListenerContainerFactory
import org.springframework.jms.core.JmsTemplate

/**
 * Created by Tu Pham Phuong - phamptu@gmail.com on 10/30/18.*/
@Configuration
class JmsConfig {

    String BROKER_URL = "tcp://localhost:61616"
    String BROKER_USERNAME = "admin"
    String BROKER_PASSWORD = "admin"

    @Bean
    ActiveMQConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory()
        connectionFactory.setBrokerURL(BROKER_URL)
        connectionFactory.setPassword(BROKER_USERNAME)
        connectionFactory.setUserName(BROKER_PASSWORD)
        return connectionFactory;
    }

    @Bean
    JmsTemplate jmsTemplate(){
        JmsTemplate template = new JmsTemplate()
        template.setConnectionFactory(connectionFactory())
        return template;
    }

    @Bean
    DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory()
        factory.setConnectionFactory(connectionFactory());
        factory.setConcurrency("1-1")
        return factory
    }

}
