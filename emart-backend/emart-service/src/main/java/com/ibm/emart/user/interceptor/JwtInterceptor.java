package com.ibm.emart.user.interceptor;

import com.ibm.emart.user.entity.EncryptBaseSecert;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.ibm.emart.user.annotation.JwtIgnore;
import com.ibm.emart.user.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtInterceptor extends HandlerInterceptorAdapter {

  @Autowired
  private EncryptBaseSecert encryptBaseSecert;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {

    if (handler instanceof HandlerMethod) {
      HandlerMethod handlerMethod = (HandlerMethod) handler;
      JwtIgnore jwtIgnore = handlerMethod.getMethodAnnotation(JwtIgnore.class);
      if (jwtIgnore != null) {
        return true;
      }
    }

    if (HttpMethod.OPTIONS.equals(request.getMethod())) {
      response.setStatus(HttpServletResponse.SC_OK);
      return true;
    }

    final String authHeader = request.getHeader(JwtTokenUtil.AUTH_HEADER_KEY);

    if (StringUtils.isBlank(authHeader) || !authHeader.startsWith(JwtTokenUtil.TOKEN_PREFIX)) {
      throw new Exception();
    }

    final String token = authHeader.substring(7);

    if (encryptBaseSecert == null) {
      BeanFactory factory = WebApplicationContextUtils
          .getRequiredWebApplicationContext(request.getServletContext());
      encryptBaseSecert = (EncryptBaseSecert) factory.getBean("encryptBaseSecert");
    }

    JwtTokenUtil.parseJWT(token, encryptBaseSecert.getBase64Secret());
    return true;
  }

}
