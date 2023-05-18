package com.noxfl.momiji.woodchipper.configuration;

import com.noxfl.momiji.woodchipper.messaging.amqp.MessageHandler;
import com.noxfl.momiji.woodchipper.messaging.amqp.MessageHandlerProductDetail;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("product-detail")
@Configuration
public class WoodchipperProductDetail {

    @Bean
    public Queue queue() {
        return new Queue("product-detail");
    }

    @Bean
    public MessageHandler messageHandlerProduct() {
        return new MessageHandlerProductDetail();
    }

}
