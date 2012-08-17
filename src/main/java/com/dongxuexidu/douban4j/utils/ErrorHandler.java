package com.dongxuexidu.douban4j.utils;

import com.dongxuexidu.douban4j.model.app.DoubanException;
import com.google.api.client.http.HttpResponseException;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class ErrorHandler {
  
  public static final int HTTP_RESPONSE_ERROR_STATUS_CODE = 1015;
  
  public static DoubanException accessTokenNotSet () {
    return new DoubanException(100, "This method needs access token to gain accessability");
  }
  
  public static DoubanException cannotGetAccessToken () {
    return new DoubanException(100, "Cannot get access token, IO exception");
  }
  
  public static DoubanException getCustomDoubanException (int code, String msg) {
    return new DoubanException(code, msg);
  }
  
  public static DoubanException handleHttpResponseError (HttpResponseException ex) {
    return new DoubanException(HTTP_RESPONSE_ERROR_STATUS_CODE, "HttpResponseException : http status : " + ex.getStatusCode() + " message : " + ex.getStatusMessage());
  }
  
  public static DoubanException wrongJsonFormat (String rawString) {
    return new DoubanException(100, "Illegal JSON format : " + rawString);
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
