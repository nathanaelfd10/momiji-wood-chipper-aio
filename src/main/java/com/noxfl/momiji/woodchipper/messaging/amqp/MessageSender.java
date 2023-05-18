package com.noxfl.momiji.woodchipper.messaging.amqp;

import com.noxfl.momiji.woodchipper.model.schema.message.MomijiMessage;
import org.checkerframework.checker.units.qual.A;
import org.json.JSONObject;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

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

    @Autowired
    private Environment env;

    private boolean isCurrentActiveWorker(String workerName) {
        return Arrays.stream(env.getActiveProfiles()).anyMatch(profile -> profile.equalsIgnoreCase(workerName));
    }

    public void send(MomijiMessage momijiMessage) {
        String outputQueueName;
        if(isCurrentActiveWorker("product-detail"))
            outputQueueName = "extractor";
        else
            outputQueueName = momijiMessage.getJob().isScrapeDetail() ? queueNameProduct : queueNameExtractor;

        this.send(new JSONObject(momijiMessage).toString(), outputQueueName);
    }

    public void send(String message, String queueName) {
        rabbitTemplate.convertAndSend(queueName, message);
        messageCount++;
        System.out.printf(" [%s] Sent message to '%s' %n", messageCount, queueName);
    }

}