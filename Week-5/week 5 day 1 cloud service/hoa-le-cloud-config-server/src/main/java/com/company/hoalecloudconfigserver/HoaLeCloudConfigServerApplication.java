package com.company.hoalecloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class HoaLeCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HoaLeCloudConfigServerApplication.class, args);
	}

}
