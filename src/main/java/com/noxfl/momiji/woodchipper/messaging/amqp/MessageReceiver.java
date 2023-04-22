/**
 * 
 */
package com.noxfl.momiji.woodchipper.messaging.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author Fernando Nathanael
 *
 */

public class MessageReceiver {

	public static final String INPUT_QUEUE_NAME = "tree-house";

	public static final int HEARTBEAT_INTERVAL_MS = 1000;

	private MessageHandler messageHandler;

	@Autowired
	public void setMessageHandler(MessageHandler messageHandler) {
		this.messageHandler = messageHandler;
	}

	@RabbitHandler
	@RabbitListener(queues = INPUT_QUEUE_NAME)
	public void receive(String message) throws IOException, URISyntaxException {
		System.out.println("[*] Received new message");
		messageHandler.handle(message);
	}

}