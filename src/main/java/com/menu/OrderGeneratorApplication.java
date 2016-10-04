package com.menu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@PropertySource(value="classpath:menu.properties")
@EnableScheduling
public class OrderGeneratorApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(OrderGeneratorApplication.class, args);
	}
}
