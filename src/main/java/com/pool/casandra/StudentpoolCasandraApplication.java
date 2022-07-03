package com.pool.casandra;

import java.nio.file.Path;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.context.annotation.Bean;

import com.pool.casandra.config.DataStaxAstraProperties;

@SpringBootApplication
public class StudentpoolCasandraApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentpoolCasandraApplication.class, args);
	}
	@Bean
	public CqlSessionBuilderCustomizer sessionBuilderCustomizer(DataStaxAstraProperties astraProperties) {
		Path bundle = astraProperties.getSecureConnectBundle().toPath();
		return builder -> builder.withCloudSecureConnectBundle(bundle);
	}
}
