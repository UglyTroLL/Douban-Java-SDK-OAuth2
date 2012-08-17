package com.dongxuexidu.douban4j.utils;

import com.dongxuexidu.douban4j.model.app.AccessToken;
import com.dongxuexidu.douban4j.model.app.DoubanException;
import com.google.api.client.util.DateTime;
import java.util.Date;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class Converters {
  
  public static AccessToken stringToAccessToken (String responseStr) throws DoubanException {
    if (responseStr == null) {
      throw ErrorHandler.cannotGetAccessToken();
    }
    JSONObject jObj = Converters.toJsonObj(responseStr);
    if (jObj == null) {
      throw ErrorHandler.wrongJsonFormat(responseStr);
    }
    DoubanException exp = ErrorHandler.handleError(responseStr);
    if (exp != null) {
      throw exp;
    }
    String accessToken = jObj.getString("access_token");
    int expiresIn = jObj.getInt("expires_in");
    String refreshToken = jObj.getString("refresh_token");
    String doubanUserId = jObj.getString("douban_user_id");
    return new AccessToken(accessToken, expiresIn, refreshToken, doubanUserId);
  }
  
  public static Date convertStringToDateTimeInRFC3339 (String dateStr) {
    DateTime dt = DateTime.parseRfc3339(dateStr);
    return new Date(dt.getValue());
  }
  
  public static String convertDateToStringInRFC3339 (Date date) {
    DateTime dt = new DateTime(date.getTime(), 480);
    String wholeFormat = dt.toString();
    //Do a little hack here for converting the date into the proper string
    String result = wholeFormat.substring(0, wholeFormat.indexOf(".")) + wholeFormat.substring(wholeFormat.indexOf(".") + 4);
    return result;
  }
  
  public static JSONObject toJsonObj (String jsonStr) throws DoubanException {
    try {
      JSONObject result = JSONObject.fromObject(jsonStr);
      return result;
    } catch (JSONException ex) {
      throw ErrorHandler.wrongJsonFormat(jsonStr);
    }
  }
  
  public static void main(String[] args) {
    System.out.println(convertStringToDateTimeInRFC3339("2006-03-29T10:36:19+08:00"));
    System.out.println(convertDateToStringInRFC3339(new Date()));
  }
  
}
