package com.ibm.emart.zuul.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

  @Bean
  public CorsFilter corsFilter() {
    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    final CorsConfiguration config = new CorsConfiguration();
    config.setAllowCredentials(true); // Allow cookies to cross domain
    config.addAllowedOrigin(
        "*");// The URI,* that allows the request to be submitted to the server indicates that all requests are allowed. In SpringMVC, if set to *, it will be automatically transferred to the Origin in the current request header.
    config.addAllowedHeader("*");// Header information of allowed access, * indicates all
    config.setMaxAge(
        7200L);// The cache time of the pre-check request (in seconds), that is, during this period, there will be no more pre-check for the same cross-domain request.
    config.addAllowedMethod(
        "*");// The method that allows the request to be submitted, * indicates that all are allowed
    source.registerCorsConfiguration("/**", config);
    return new CorsFilter(source);
  }
}
