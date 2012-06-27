package com.dongxuexidu.douban4j.service;

import com.dongxuexidu.douban4j.model.DoubanException;
import com.dongxuexidu.douban4j.model.DoubanUserObj;
import com.dongxuexidu.douban4j.utils.Converters;
import com.dongxuexidu.douban4j.utils.ErrorHandler;
import net.sf.json.JSONObject;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanServiceFacade {
  
  public static DoubanUserObj getDoubanUserProfileInObj (String accessToken) throws DoubanException {
    JSONObject jObj = getDoubanUserProfileInJSON(accessToken);
    return Converters.jsonToDoubanUser(jObj);
  }
  
  public static JSONObject getDoubanUserProfileInJSON (String accessToken) throws DoubanException {
    String response = DoubanUserService.getUserProfile(accessToken);
    JSONObject jObj = Converters.toJsonObj(response);
    DoubanException exp = ErrorHandler.handleError(response);
    if (exp != null) {
      throw exp;
    }
    return jObj;
  }
  
}
