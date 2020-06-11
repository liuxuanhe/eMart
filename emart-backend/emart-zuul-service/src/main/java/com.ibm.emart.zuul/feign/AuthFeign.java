package com.ibm.emart.zuul.feign;

import com.ibm.emart.zuul.dto.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "emart-security", fallback = AuthFeignFallback.class)
public interface AuthFeign {

  @RequestMapping(value = "/api/auth/checkToken", method = RequestMethod.POST)
  ResponseEntity<UserInfo> checkToken(@RequestParam("token") String token);
}
