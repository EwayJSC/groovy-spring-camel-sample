package com.eway.event_hub

import com.eway.common.util.ExceptionUtil
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext
import org.springframework.integration.channel.QueueChannel
import org.springframework.integration.support.MessageBuilder
import org.springframework.messaging.Message
import org.springframework.messaging.MessageChannel

@SpringBootApplication
@Slf4j
class App {
    private MessageChannel inChannel;

    @Autowired
    private ApplicationContext appContext

    static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        try {
            App springIntegration = (App) context.getBean("springIntegration");
            springIntegration.post("Eway");

            QueueChannel outChannel = (QueueChannel) context.getBean("outputChannel");
            log.info("outChannel.receive() " + outChannel.receive());
        } catch (Exception e) {
            log.warn(ExceptionUtil.toString(e))
        }

        SpringApplication.run(App, args)
    }

    void post(String payload) {
        Message<String> message = MessageBuilder.withPayload(payload).build();
        inChannel.send(message)
    }

    void setInputChannel(MessageChannel messageChannel) {
        this.inChannel = messageChannel
    }
}
