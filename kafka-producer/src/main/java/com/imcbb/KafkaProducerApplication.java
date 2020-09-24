package com.imcbb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @author kevin
 */
@SpringBootApplication
public class KafkaProducerApplication implements CommandLineRunner {

	private static Logger logger = LoggerFactory.getLogger(KafkaProducerApplication.class);


	@Autowired
	private KafkaTemplate template;

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		for (int i = 0; i < 50; i++) {

			this.template.send("myTopic", "data:" + i );

		}
		logger.info("All msg added!");





	}
}
