package com.mohsin.learn_spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

interface NotificationSender {
	String send(String message);
	String name();
}

@Service
@ConditionalOnProperty(name = "notification.service", havingValue = "email", matchIfMissing = true)
class EmailNotification implements NotificationSender {

	@Override
	public String send(String message) {
		return "Email Notification: " + message;
	}

	@Override
	public String name() {
		return this.getClass().getSimpleName();
	}
}

@Service
@ConditionalOnProperty(name = "notification.service", havingValue = "sms")
class SmsNotification implements NotificationSender {

	@Override
	public String send(String message) {
		return "SMS Notification: " + message;
	}

	@Override
	public String name() {
		return this.getClass().getSimpleName();
	}
}

@SpringBootApplication
@EnableConfigurationProperties(CurrencyServiceConfiguration.class)
public class LearnSpringBootApplication {

	@Autowired
	private NotificationSender notificationSender;

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringBootApplication.class, args);
	}

	@Bean
	public CommandLineRunner startup() {
		return args -> {
			System.out.println(notificationSender.name());
			System.out.println(notificationSender.send("Hello World!"));
		};
	}
}
