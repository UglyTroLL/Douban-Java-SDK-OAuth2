package com.dongxuexidu.douban4j.utils;

import com.dongxuexidu.douban4j.model.app.AccessToken;
import com.dongxuexidu.douban4j.model.app.DoubanException;
import com.dongxuexidu.douban4j.model.user.DoubanUserObj;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.json.JSONArray;
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
  
  //The timezone format provided by Douban is not a standard one support in Java, so a little trick needs to be done here in order to properly parse it.
  public static Date jsonTimeStampToDate (String timeStamp) {
    if (timeStamp == null || timeStamp.isEmpty()) {
      return null;
    }
    try {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
      int commaIndex = timeStamp.lastIndexOf(":");
      timeStamp = timeStamp.substring(0, commaIndex) + timeStamp.substring(commaIndex + 1);
      return sdf.parse(timeStamp);
    } catch (ParseException ex) {
      Logger.getLogger(Converters.class.getName()).log(Level.SEVERE, null, ex);
      return null;
    }
  }
  
  public static String dateToJsonTimeStamp (Date d) {
    if (d == null) {
      return null;
    }
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
    String needPolishing = sdf.format(d);
    return needPolishing.substring(0, needPolishing.length() - 2) + ":" + needPolishing.substring(needPolishing.length() - 2);
  }
  
  public static JSONObject toJsonObj (String jsonStr) throws DoubanException {
    try {
      JSONObject result = JSONObject.fromObject(jsonStr);
      return result;
    } catch (JSONException ex) {
      throw ErrorHandler.wrongJsonFormat(jsonStr);
    }
  }
  
  public static JSONArray toJsonArr (String jsonStr) throws DoubanException {
    try {
      JSONArray result = JSONArray.fromObject(jsonStr);
      return result;
    } catch (JSONException ex) {
      throw ErrorHandler.wrongJsonFormat(jsonStr);
    }
  }
  
  public static void main(String[] args) {
    System.out.println(jsonTimeStampToDate("2006-03-29T10:36:19+08:00"));
    System.out.println(dateToJsonTimeStamp(new Date()));
  }
  
}
