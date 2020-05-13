package com.ibm.emart.user.controller;

import com.ibm.emart.user.entity.EncryptBaseSecert;
import com.ibm.emart.user.entity.Buyer;
import com.ibm.emart.user.entity.Seller;
import com.ibm.emart.user.service.UserService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ibm.emart.user.dto.ApiResponse;
import com.ibm.emart.user.util.JwtTokenUtil;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("/api/user")
public class UserController {

  @Autowired
  private EncryptBaseSecert encryptBaseSecert;

  @Autowired
  private UserService userService;

  @PostMapping("buyerSignin")
  public ApiResponse authenticateOfBuyer(@RequestBody Buyer buyer) {

    ApiResponse response = new ApiResponse();

    try {
      userService.findBuyer(buyer.getUserName(), buyer.getPassword());
      String userId = UUID.randomUUID().toString();
      String role = "admin";
      String token = JwtTokenUtil.createJWT(userId, buyer.getUserName(), role, encryptBaseSecert);
      response.setToken(token);
      response.setResponseCode(ApiResponse.SUCCESS);
      response.setResponseMessage("ok");
    } catch (Exception e) {
      response.setResponseCode(ApiResponse.ERROR);
      response.setResponseMessage("error");
    }
    return response;
  }

  @PostMapping("sellerSignin")
  public ApiResponse authenticateOfSeller(@RequestBody Buyer buyer) {

    ApiResponse response = new ApiResponse();

    try {
      userService.findSeller(buyer.getUserName(), buyer.getPassword());
      String userId = UUID.randomUUID().toString();
      String role = "admin";
      String token = JwtTokenUtil.createJWT(userId, buyer.getUserName(), role, encryptBaseSecert);
      response.setToken(token);
      response.setResponseCode(ApiResponse.SUCCESS);
      response.setResponseMessage("ok");
    } catch (Exception e) {
      response.setResponseCode(ApiResponse.ERROR);
      response.setResponseMessage("error");
    }
    return response;
  }

  @PostMapping("buyerSignup")
  public ApiResponse buyerSignUp(@RequestBody Buyer buyer) {
    ApiResponse response = new ApiResponse();
    try {
      userService.saveBuyer(buyer);
      response.setResponseCode(ApiResponse.SUCCESS);
      response.setResponseMessage("ok");
    } catch (Exception e) {
      response.setResponseCode(ApiResponse.ERROR);
      response.setResponseMessage("error");
    }
    return response;
  }

  @PostMapping("sellerSignup")
  public ApiResponse sellerSignUp(@RequestBody Seller seller) {
    ApiResponse response = new ApiResponse();
    try {
      userService.saveSeller(seller);
      response.setResponseCode(ApiResponse.SUCCESS);
      response.setResponseMessage("ok");
    } catch (Exception e) {
      response.setResponseCode(ApiResponse.ERROR);
      response.setResponseMessage("error");
    }
    return response;
  }

}
