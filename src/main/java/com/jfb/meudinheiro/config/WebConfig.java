package com.jfb.meudinheiro.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class WebConfig {

	@Bean
	public FilterRegistrationBean<CorsFilter> consFilterRegistrationBean() {
		List<String> all = Arrays.asList("*");
		 
		CorsConfiguration consConfiguration = new CorsConfiguration();
		consConfiguration.setAllowedOrigins(all);
		consConfiguration.setAllowedHeaders(all);
		consConfiguration.setAllowedMethods(all);		
		consConfiguration.setAllowCredentials(true);
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", consConfiguration);
		
		CorsFilter corsFilter = new CorsFilter(source);
		FilterRegistrationBean<CorsFilter>  filter = new FilterRegistrationBean<>(corsFilter);
		filter.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return filter;
	}
}
