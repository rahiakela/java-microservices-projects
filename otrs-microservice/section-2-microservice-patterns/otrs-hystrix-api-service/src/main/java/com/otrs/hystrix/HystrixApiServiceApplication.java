package com.otrs.hystrix;

import javax.net.ssl.HttpsURLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.rabbitmq.client.ConnectionFactory;

@EnableEurekaClient
@EnableCircuitBreaker
@SpringBootApplication
public class HystrixApiServiceApplication {

	private static final Logger LOG = LoggerFactory.getLogger(HystrixApiServiceApplication.class);
	
	@Value("${app.rabbitmq.host:localhost}")
	private String rabbitMqHost;
	
	static {
		// for localhost testing only
		LOG.warn("Will now disable hostname check in SSL, only to be used during development");
		HttpsURLConnection.setDefaultHostnameVerifier((hostname, sslSession) -> true);
	}
	
	@Bean
	public ConnectionFactory connectionFactory() {
		LOG.info("Create RabbitMqCF for host: {}", rabbitMqHost);
		
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory(rabbitMqHost);
		
		return connectionFactory.getRabbitConnectionFactory();
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
	public static void main(String[] args) {
		LOG.info("Register MDCHystrixConcurrencyStrategy");
		SpringApplication.run(HystrixApiServiceApplication.class, args);
	}

}
