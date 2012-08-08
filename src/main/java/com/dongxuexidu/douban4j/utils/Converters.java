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
    DoubanUserObj user = new DoubanUserObj();
    user.setContent(jObj.getJSONObject("content").getString("$t") == null ? "" : jObj.getJSONObject("content").getString("$t"));
    user.setIdStr(jObj.getJSONObject("db:uid").getString("$t") == null ? "" : jObj.getJSONObject("db:uid").getString("$t"));
    user.setUriAndIdNum(jObj.getJSONObject("uri").getString("$t"));
    user.setLocationName(jObj.getJSONObject("db:location").getString("$t") == null ? "" : jObj.getJSONObject("db:location").getString("$t"));
    user.setLocationId(jObj.getJSONObject("db:location").getString("@id") == null ? "" : jObj.getJSONObject("db:location").getString("@id"));
    user.setScreenName(jObj.getJSONObject("title").getString("$t") == null ? "" : jObj.getJSONObject("title").getString("$t"));
    user.setSignature(jObj.getJSONObject("db:signature").getString("$t") == null ? "" : jObj.getJSONObject("db:signature").getString("$t"));
    JSONArray jArr = jObj.getJSONArray("link");
    for (int i = 0 ; i < jArr.size() ; i ++) {
      JSONObject linkObj = jArr.getJSONObject(i);
      user.addLink(linkObj.getString("@rel"), linkObj.getString("@href"));
    }
    return user;
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
