package com.desafio.itau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class ItauApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(ItauApplication.class, args);
	}

}
