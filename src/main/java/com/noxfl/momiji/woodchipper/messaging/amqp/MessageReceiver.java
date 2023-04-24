/**
 * 
 */
package com.noxfl.momiji.woodchipper.messaging.amqp;

import org.checkerframework.checker.units.qual.A;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author Fernando Nathanael
 *
 */

@Component
public class MessageReceiver {

	private MessageHandler messageHandler;

	@Autowired
	public void setMessageHandler(MessageHandler messageHandler) {
		this.messageHandler = messageHandler;
	}

	@RabbitHandler
	@RabbitListener(queues = "${spring.rabbitmq.queue.input.name}")
	public void receive(String message) throws IOException, URISyntaxException, NoSuchFieldException, ExecutionException, InterruptedException, ParseException {
		System.out.println("[*] Received new message");
		messageHandler.handle(message);
	}

}