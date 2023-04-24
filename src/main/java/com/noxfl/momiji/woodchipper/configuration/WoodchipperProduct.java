package com.noxfl.momiji.woodchipper.configuration;

import com.noxfl.momiji.woodchipper.messaging.amqp.MessageHandler;
import com.noxfl.momiji.woodchipper.messaging.amqp.MessageHandlerProduct;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("product")
@Configuration
public class WoodchipperProduct {

    @Bean
    public Queue queue() {
        return new Queue("product");
    }

    @Bean
    public MessageHandler messageHandlerProduct() {
        return new MessageHandlerProduct();
    }

}
