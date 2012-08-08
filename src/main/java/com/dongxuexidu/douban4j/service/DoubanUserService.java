package com.dongxuexidu.douban4j.service;

import com.dongxuexidu.douban4j.constants.RequestUrls;
import com.dongxuexidu.douban4j.model.DoubanException;
import com.dongxuexidu.douban4j.model.DoubanUserObj;
import com.dongxuexidu.douban4j.utils.Converters;
import com.dongxuexidu.douban4j.utils.ErrorHandler;
import com.dongxuexidu.douban4j.utils.HttpManager;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.sf.json.JSONObject;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanUserService implements DoubanService {
  
  private static final Integer REQUEST_TYPE_OTHER = 1;
  private static final Integer REQUEST_TYPE_SELF = 2;
  
  private HttpManager client = null;
  
  public DoubanUserService () {
    this.client = new HttpManager();
  }
  
  public DoubanUserService (String accessToken) {
    this.client = new HttpManager(accessToken);
  }
  
  public void setAccessToken (String accessToken) {
    this.client.setAccessToken(accessToken);
  }
  
  private String getUserProfileInRaw (int type, String uid) throws DoubanException {
    String url = "";
    if (type == REQUEST_TYPE_OTHER) {
      url = RequestUrls.GET_USER_PROFILE_URL + uid;
      return this.client.getResponse(url, null, false);
    } else {
      url = RequestUrls.GET_CURRENT_USER_PROFILE_URL;
      return this.client.getResponse(url, null, true);
    }
  }
  
  public JSONObject getUserProfileInJSONObj (String uid) throws DoubanException {
    String response = getUserProfileInRaw(REQUEST_TYPE_OTHER, uid);
    DoubanException exp = ErrorHandler.handleError(response);
    if (exp != null) {
      throw exp;
    }
    JSONObject jObj = Converters.toJsonObj(response);
    return jObj;
  }
  
  public DoubanUserObj getUserProfile (String uid) throws DoubanException {
    JSONObject jObj = getUserProfileInJSONObj(uid);
    return Converters.jsonToDoubanUser(jObj);
  }
  
  public JSONObject getCurrentUserProfileInJSONObj () throws DoubanException {
    String response = getUserProfileInRaw(REQUEST_TYPE_SELF, "");
    DoubanException exp = ErrorHandler.handleError(response);
    if (exp != null) {
      throw exp;
    }
    JSONObject jObj = Converters.toJsonObj(response);
    return jObj;
  }
  
  public DoubanUserObj getCurrentUserProfile () throws DoubanException {
    JSONObject jObj = getCurrentUserProfileInJSONObj();
    return Converters.jsonToDoubanUser(jObj);
  }
  
  public static void main(String[] args) {
    try {
      DoubanUserService test = new DoubanUserService();
      System.out.println(test.getUserProfileInJSONObj("uglytroll").toString());
    } catch (DoubanException ex) {
      Logger.getLogger(DoubanUserService.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
}
