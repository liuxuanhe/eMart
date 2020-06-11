package com.ibm.emart.zuul.dto;

public class UserInfo {

  private int id;
  private String userName;
  private String password;
  private String emailId;
  private String mobileNumber;
  private String createdDatetime;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmailId() {
    return emailId;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public String getCreatedDatetime() {
    return createdDatetime;
  }

  public void setCreatedDatetime(String createdDatetime) {
    this.createdDatetime = createdDatetime;
  }
}
