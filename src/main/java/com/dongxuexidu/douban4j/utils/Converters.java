package com.dongxuexidu.douban4j.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import com.dongxuexidu.douban4j.constants.DefaultConfigs;
import com.dongxuexidu.douban4j.model.app.AccessToken;
import com.dongxuexidu.douban4j.model.app.DoubanException;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.http.xml.XmlHttpContent;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.client.util.DateTime;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class Converters {

  public static AccessToken stringToAccessToken(String responseStr) throws DoubanException {
    if (responseStr == null) {
      throw ErrorHandler.cannotGetAccessToken();
    }
    System.out.println("got result !");
    System.out.println(responseStr);
    JSONObject jObj = Converters.toJsonObj(responseStr);
    AccessToken token = new AccessToken();
    if (jObj.containsKey("access_token")) {
      String accessToken = jObj.getString("access_token");
      token.setAccessToken(accessToken);
    } else {
      throw ErrorHandler.cannotGetAccessToken();
    }
    if (jObj.containsKey("expires_in")) {
      int expiresIn = jObj.getInt("expires_in");
      token.setExpiresIn(expiresIn);
    } else {
      throw ErrorHandler.cannotGetAccessToken();
    }
    if (jObj.containsKey("refresh_token")) {
      String refreshToken = jObj.getString("refresh_token");
      token.setRefreshToken(refreshToken);
    }
    if (jObj.containsKey("douban_user_id")) {
      String doubanUserId = jObj.getString("douban_user_id");
      token.setDoubanUserId(doubanUserId);
    }
    return token;
  }

  public static Date convertStringToDateTimeInRFC3339(String dateStr) {
    DateTime dt = DateTime.parseRfc3339(dateStr);
    return new Date(dt.getValue());
  }

  public static String convertDateToStringInRFC3339(Date date) {
    DateTime dt = new DateTime(date.getTime(), 480);
    String wholeFormat = dt.toString();
    //Do a little hack here for converting the date into the proper string
    String result = wholeFormat.substring(0, wholeFormat.indexOf(".")) + wholeFormat.substring(wholeFormat.indexOf(".") + 4);
    return result;
  }

  public static JSONObject toJsonObj(String jsonStr) throws DoubanException {
    try {
      JSONObject result = JSONObject.fromObject(jsonStr);
      return result;
    } catch (JSONException ex) {
      throw ErrorHandler.wrongJsonFormat(jsonStr);
    }
  }

  public static <T> String parseDoubanObjToJSONStr(T obj) throws IOException {
    JsonHttpContent content = new JsonHttpContent(new JacksonFactory(), obj);
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    content.writeTo(os);
    String result = new String(os.toByteArray());
    return result;
  }
  
  public static <T> String parseDoubanObjToXMLStr(T obj) throws IOException {
    XmlHttpContent content = new XmlHttpContent(DefaultConfigs.DOUBAN_XML_NAMESPACE, "entry", obj);
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    content.writeTo(os);
    String result = new String(os.toByteArray());
    return result;
  }

  public static void main(String[] args) {
    System.out.println(convertStringToDateTimeInRFC3339("2006-03-29T10:36:19+08:00"));
    System.out.println(convertDateToStringInRFC3339(new Date()));
  }
}
