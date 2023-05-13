package com.noxfl.momiji.woodchipper.messaging.amqp;

import com.noxfl.momiji.woodchipper.model.schema.message.MomijiMessage;
import org.json.JSONObject;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Fernando Nathanael
 *
 */
@Component
public class MessageSender {

    @Value("${spring.rabbitmq.queue.product.name}")
    private String queueNameProduct;

    @Value("${spring.rabbitmq.queue.extractor.name}")
    private String queueNameExtractor;

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    private int messageCount = 0;

    public void send(MomijiMessage momijiMessage) {
        String queueName = momijiMessage.getJob().isScrapeDetail()
                ? queueNameProduct
                : queueNameExtractor;

        System.out.println("Preparing to send: " + momijiMessage.getJob().getContent().getOutput().getProductUrl());

        this.send(new JSONObject(momijiMessage).toString(), queueName);
    }

    public void send(String message, String queueName) {
        rabbitTemplate.convertAndSend(queueName, message);
        messageCount++;
        System.out.printf(" [%s] Sent message to '%s' %n", messageCount, queueName);
    }

}