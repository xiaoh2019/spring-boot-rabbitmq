package com.cyzs.springboot;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit //开启注解Rabbitmq模式
@SpringBootApplication
public class SpringBootRabbitmqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRabbitmqApplication.class, args);
	}

}
