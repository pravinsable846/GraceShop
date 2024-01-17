package com.graceshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
public class GraceShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraceShopApplication.class, args);
	}

}
