package com.ax.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author macro
 * @date 2020/5/19
 */
public class SimpleSender {

	private static final Logger LOGGER = LoggerFactory.getLogger(SimpleSender.class);

	@Autowired
	private RabbitTemplate template;

	private static final String queueName="simple.hello";

	public void send() {
		String message = "Hello World!";
		this.template.convertAndSend(queueName, message);
		LOGGER.info(" [x] Sent '{}'", message);
	}

}