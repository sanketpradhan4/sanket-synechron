package com.synechron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages="com.synechron")
//@ComponentScan("com.synechron")
public class WordCounterApplication {

	public static void main(String[] args) {
		SpringApplication.run(WordCounterApplication.class, args);
	}

}
