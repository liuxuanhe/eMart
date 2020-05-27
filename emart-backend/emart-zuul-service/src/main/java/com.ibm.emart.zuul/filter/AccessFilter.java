package com.ibm.emart.zuul.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.client.RestTemplate;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class AccessFilter extends ZuulFilter {

  private static Logger logger = LoggerFactory.getLogger(AccessFilter.class);

  @Autowired
  private RestTemplate restTempate;

  @Override
  public boolean shouldFilter() {
    RequestContext requestContext = RequestContext.getCurrentContext();
    HttpServletRequest request = requestContext.getRequest();
    return true;
  }

  @Override
  public String filterType() {
    return "pre";
  }

  @Override
  public int filterOrder() {
    return 0;
  }

  @Override
  public Object run() {
    RequestContext requestContext = RequestContext.getCurrentContext();
    HttpServletRequest request = requestContext.getRequest();

    logger.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());
    String url = request.getRequestURL().toString();
    if ("/auth/oauth/token".equals(url)) {
      return null;
    }

    Object accessToken = request.getHeader("Authorization");
    if (accessToken == null) {
      logger.warn("Authorization token is empty.");
      requestContext.setSendZuulResponse(false);
      requestContext.setResponseStatusCode(401);
      requestContext.setResponseBody("Authorization token is empty.");
      return null;
    } else {
      try {
        User user = restTempate.getForObject("http://cloud-auth-service/auth/user", User.class);
        if (user == null) {
          logger.info("The user is null...");
          requestContext.setSendZuulResponse(false);
          requestContext.setResponseStatusCode(401);
          requestContext.setResponseBody("Cannot get the user.");
        } else {
          logger.info("Login user: " + user);
        }
      } catch (Exception e) {
        e.printStackTrace();
      }

    }
    logger.info("Authorization token is ok");
    return null;
  }
}
