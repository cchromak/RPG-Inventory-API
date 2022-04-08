package com.chromak.RPGInventoryAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.chromak.*")
@EntityScan("com.chromak.entity")
@EnableJpaRepositories("com.chromak.repository")
public class RpgInventoryApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RpgInventoryApiApplication.class, args);
	}

}
