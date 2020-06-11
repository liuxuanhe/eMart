package com.ibm.emart.zuul;

import com.ibm.emart.zuul.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@EnableFeignClients
@EnableZuulProxy
@SpringBootApplication
public class ZuulServerApplication {

  @Bean
  public TokenFilter tokenFilter() {
    return new TokenFilter();
  }

  public static void main(String[] args) {
    SpringApplication.run(ZuulServerApplication.class, args);
  }

}
