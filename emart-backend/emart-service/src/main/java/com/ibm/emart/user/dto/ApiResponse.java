package com.ibm.emart.user.dto;

import lombok.Data;

@Data
public class ApiResponse {

  public static final String SUCCESS = "200";
  public static final String ERROR = "404";
  private String responseCode;
  private String responseMessage;
  private String token;

  public String getResponseCode() {
    return responseCode;
  }

  public void setResponseCode(String responseCode) {
    this.responseCode = responseCode;
  }

  public String getResponseMessage() {
    return responseMessage;
  }

  public void setResponseMessage(String responseMessage) {
    this.responseMessage = responseMessage;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

}
