package com.noxfl.momiji.woodchipper.configuration;

import com.noxfl.momiji.woodchipper.messaging.amqp.MessageHandler;
import com.noxfl.momiji.woodchipper.messaging.amqp.MessageHandlerProductList;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("product-list")
@Configuration
public class WoodchipperProductList {

    @Bean
    public Queue queue() {
        return new Queue("product-list");
    }

    @Bean
    public MessageHandler messageHandlerProductList() {
        return new MessageHandlerProductList();
    }

}
