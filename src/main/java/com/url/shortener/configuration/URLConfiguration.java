package com.url.shortener.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("com.url.shortener")
@EnableJpaRepositories("com.url.shortener.repositories")
@EntityScan("com.url.shortener.models")
public class URLConfiguration {
}
