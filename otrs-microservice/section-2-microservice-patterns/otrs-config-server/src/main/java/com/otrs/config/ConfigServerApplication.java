package com.otrs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void insertDataAfterStartup() {
		Resource resource =new ClassPathResource("data-config.sql");
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
		databasePopulator.execute(jdbcTemplate.getDataSource());
	}
}
