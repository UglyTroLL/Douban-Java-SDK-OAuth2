package com.dongxuexidu.douban4j.model;

import java.io.Serializable;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class AccessToken implements Serializable {
  
  private String accessToken = null;
  private Integer expiresIn = null;
  private String refreshToken = null;
  private String doubanUserId = null;

  /**
   * @return the accessToken
   */
  public String getAccessToken() {
    return accessToken;
  }

  /**
   * @param accessToken the accessToken to set
   */
  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  /**
   * @return the expiresIn
   */
  public Integer getExpiresIn() {
    return expiresIn;
  }

  /**
   * @param expiresIn the expiresIn to set
   */
  public void setExpiresIn(Integer expiresIn) {
    this.expiresIn = expiresIn;
  }

  /**
   * @return the refreshToken
   */
  public String getRefreshToken() {
    return refreshToken;
  }

  /**
   * @param refreshToken the refreshToken to set
   */
  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }

  /**
   * @return the doubanUserId
   */
  public String getDoubanUserId() {
    return doubanUserId;
  }

  /**
   * @param doubanUserId the doubanUserId to set
   */
  public void setDoubanUserId(String doubanUserId) {
    this.doubanUserId = doubanUserId;
  }
  
  public AccessToken (String accessToken) {
    this.accessToken = accessToken;
  }
  
  public AccessToken (String accessToken, int expiresIn, String refreshToken, String doubanUserId) {
    this.accessToken = accessToken;
    this.doubanUserId = doubanUserId;
    this.expiresIn = expiresIn;
    this.refreshToken = refreshToken;
  }
  
}
