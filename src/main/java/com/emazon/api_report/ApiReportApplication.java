package com.emazon.api_report;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiReportApplication.class, args);
	}

}
