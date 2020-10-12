package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "controller")
public class ShareFileApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShareFileApplication.class, args);
	}

}
