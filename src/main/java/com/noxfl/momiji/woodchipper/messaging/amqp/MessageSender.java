package com.noxfl.momiji.woodchipper.messaging.amqp;

import com.noxfl.momiji.woodchipper.model.schema.message.MomijiMessage;
import org.json.JSONObject;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Fernando Nathanael
 *
 */
@Component
public class MessageSender {

    public static final String QUEUE_NAME_OUTPUT_PRODUCT_DETAIL = "leaf-rake";
    public static final String QUEUE_NAME_OUTPUT_EXTRACT = "wood-chipper";

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    private int messageCount = 0;

    public void send(MomijiMessage momijiMessage) {
        String queueName = momijiMessage.getJob().isScrapeDetail()
                ? QUEUE_NAME_OUTPUT_PRODUCT_DETAIL
                : QUEUE_NAME_OUTPUT_EXTRACT;

        this.send(new JSONObject(momijiMessage).toString(), queueName);
    }

    public void send(String message, String queueName) {
        rabbitTemplate.convertAndSend(queueName, message);
        messageCount++;
        System.out.printf(" [%s] Sent message to '%s' %n", messageCount, queueName);
    }

}