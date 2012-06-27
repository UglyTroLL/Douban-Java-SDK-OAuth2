package com.dongxuexidu.douban4j.utils;

import com.dongxuexidu.douban4j.model.DoubanException;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class ErrorHandler {
  
  //A lot of work needs to be done here
  
  public static final int HTTP_STATUS_OK = 200;
  
  public static DoubanException accessTokenNotSet () {
    return new DoubanException(100, "This method needs access token to gain accessability");
  }
  
  public static DoubanException cannotGetAccessToken () {
    return new DoubanException(100, "Cannot get access token, IO exception");
  }
  
  public static DoubanException wrongJsonFormat () {
    return new DoubanException(100, "Illegal JSON format");
  }
  
  public static DoubanException handleError (String response) {
    if (true) {
      return null;
    } else {
      return new DoubanException(100, "TODO");
    }
  }
  
  public static DoubanException handleError (int code, String responseStr) {
    return null;
  }
  
}
