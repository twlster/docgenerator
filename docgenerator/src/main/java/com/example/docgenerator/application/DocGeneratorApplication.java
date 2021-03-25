package com.example.docgenerator.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.docgenerator")
public class DocGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocGeneratorApplication.class, args);
	}

}
