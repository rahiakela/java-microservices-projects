package com.user.service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component(value="config")
@ConfigurationProperties(prefix="app.greet")
public class Configuration {
	private String message;
}
