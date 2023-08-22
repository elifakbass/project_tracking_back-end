package com.proje.takip_istemi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class TakipIstemiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TakipIstemiApplication.class, args);
	}

}
