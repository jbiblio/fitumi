package com.acme.fitumi.config;

import org.springframework.cloud.app.ApplicationInstanceInfo;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.cloud.config.java.ServiceScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ServiceScan
// @Profile("cloud")
public class CloudConfig extends AbstractCloudConfig {
	@Bean
	public ApplicationInstanceInfo applicationInfo() {
		return cloud().getApplicationInstanceInfo();
	}
}