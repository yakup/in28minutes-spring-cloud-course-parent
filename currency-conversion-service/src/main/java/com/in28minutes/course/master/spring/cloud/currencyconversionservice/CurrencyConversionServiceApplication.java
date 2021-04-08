package com.in28minutes.course.master.spring.cloud.currencyconversionservice;

import com.in28minutes.course.master.spring.cloud.currencyconversionservice.configuration.LocalRibbonClientConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.in28minutes.course.master.spring.cloud.currencyconversionservice")
@RibbonClient(name = "currency-conversion-service", configuration = LocalRibbonClientConfiguration.class)
@EnableDiscoveryClient
public class CurrencyConversionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyConversionServiceApplication.class, args);
    }

}
