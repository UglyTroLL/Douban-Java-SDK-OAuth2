package com.dongxuexidu.douban4j.utils;

import com.dongxuexidu.douban4j.model.AccessToken;
import com.dongxuexidu.douban4j.model.DoubanException;
import com.dongxuexidu.douban4j.model.DoubanUserObj;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class Converters {
  
  public static DoubanUserObj jsonToDoubanUser (JSONObject jObj) {
    return null;
  }
  
  public static AccessToken stringToAccessToken (String responseStr) throws DoubanException {
    if (responseStr == null) {
      throw ErrorHandler.cannotGetAccessToken();
    }
    JSONObject jObj = Converters.toJsonObj(responseStr);
    if (jObj == null) {
      throw ErrorHandler.wrongJsonFormat();
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
  
  public static JSONObject toJsonObj (String jsonStr) {
    return JSONObject.fromObject(jsonStr);
  }
  
  public static JSONArray toJsonArr (String jsonStr) {
    return JSONArray.fromObject(jsonStr);
  }
  
}
