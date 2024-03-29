package com.microservice.reports;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Clase principal del microservicio Reports.
 * */
@EnableDiscoveryClient
@SpringBootApplication
@EnableScheduling
public class ReportsApplication {

  public static void main(String[] args) {
    SpringApplication.run(ReportsApplication.class, args);
  }

}
