package com.noxfl.momiji.woodchipper;

import com.noxfl.momiji.woodchipper.messaging.amqp.MessageHandler;
import com.noxfl.momiji.woodchipper.messaging.amqp.MessageHandlerExtractor;
import com.noxfl.momiji.woodchipper.messaging.amqp.MessageHandlerProduct;
import com.noxfl.momiji.woodchipper.messaging.amqp.MessageHandlerProductList;
import com.noxfl.momiji.woodchipper.messaging.cloudpubsub.MessagePublisher;
import com.noxfl.momiji.woodchipper.messaging.cloudpubsub.impl.MessagePublisherImpl;
import com.noxfl.momiji.woodchipper.runner.WoodChipperRunner;
import com.rabbitmq.client.Command;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class WoodchipperApplication {

//	@Bean
//	@Profile("!product-list & !product & !extractor")
//	public CommandLineRunner usage() {
//		return args -> {
//			System.out.println("This app uses Spring Profiles to control its behavior.\n");
//			System.out.println("Available profiles: product-list, product, extractor");
//		};
//	}
	@Bean
	public MessagePublisher messagePublisher() {
		final String projectId = System.getProperty("projectId");
		final String topicId = System.getProperty("topicId");
		return new MessagePublisherImpl(projectId, topicId);
	}

	public static void main(String[] args) {
		SpringApplication.run(WoodchipperApplication.class, args);
	}

}
