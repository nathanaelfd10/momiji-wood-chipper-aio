package com.noxfl.momiji.woodchipper.configuration;

import com.noxfl.momiji.woodchipper.messaging.amqp.MessageHandler;
import com.noxfl.momiji.woodchipper.messaging.amqp.MessageHandlerExtractor;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("extractor")
@Configuration
public class WoodchipperExtractor {

    @Bean
    public Queue queue() {
        return new Queue("extractor");
    }

    @Bean
    public MessageHandler messageHandlerExtractor() {
        return new MessageHandlerExtractor();
    }

}
