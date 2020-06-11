package com.ibm.emart.zuul.feign;

import com.ibm.emart.zuul.dto.UserInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class AuthFeignFallback implements AuthFeign {

  @Override
  public ResponseEntity<UserInfo> checkToken(String token) {
    return null;
  }
}
