package com.boot.qzydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

// 服务端发现客户端
@EnableDiscoveryClient
@SpringBootApplication
class ServerProviderTwoStartApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServerProviderTwoStartApplication.class, args);
	}
}
