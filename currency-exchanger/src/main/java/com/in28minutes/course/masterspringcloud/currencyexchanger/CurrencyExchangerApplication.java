package com.in28minutes.course.masterspringcloud.currencyexchanger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CurrencyExchangerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangerApplication.class, args);
	}

}
