package com.in28minutes.course.master.spring.cloud.currencyconversionservice.configuration;

import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocalRibbonClientConfiguration {
    @Bean
    public ServerList<Server> ribbonServerServerList() {
        return new StaticServerList<>(
                new Server("localhost", 8000),
                new Server("localhost", 8001));
    }
}
