package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages="com.example.demo")
public class SpringbootQuartzApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootQuartzApplication.class, args);
	}

}
