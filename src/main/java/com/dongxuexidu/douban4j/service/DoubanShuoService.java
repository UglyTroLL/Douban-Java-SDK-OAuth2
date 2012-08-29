package com.dongxuexidu.douban4j.service;

import com.dongxuexidu.douban4j.constants.DefaultConfigs;
import com.dongxuexidu.douban4j.constants.RequestUrls;
import com.dongxuexidu.douban4j.model.app.DoubanException;
import com.dongxuexidu.douban4j.model.shuo.DoubanShuoAttachementObj;
import com.dongxuexidu.douban4j.model.shuo.DoubanShuoStatusObj;
import com.dongxuexidu.douban4j.model.shuo.DoubanShuoUserObj;
import com.dongxuexidu.douban4j.utils.Converters;
import com.dongxuexidu.douban4j.utils.ErrorHandler;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanShuoService extends DoubanService {
  
  public static enum DoubanShuoCategory {
    
    Article {
      @Override
      public String getValue() {
        return "article";
      }
    },
    Photo {
      @Override
      public String getValue() {
        return "photo";
      }
    },
    Culture {
      @Override
      public String getValue() {
        return "culture";
      }
    },
    Shopping {
      @Override
      public String getValue() {
        return "shopping";
      }
    };
    
    public abstract String getValue();
  }
  
  final static Logger logger = Logger.getLogger(DoubanShuoService.class.getName());

  public DoubanShuoService(String accessToken) {
    super(accessToken);
  }
  
  public DoubanShuoService() {
    super();
  }
  
  public DoubanShuoStatusObj[] getStatusesForLoggedInUser (String accessToken) throws DoubanException, IOException {
    return getStatusesForLoggedInUser(accessToken, null, null, null, null);
  }
  
  public DoubanShuoStatusObj[] getStatusesForLoggedInUser (String accessToken, Long sinceId, Long untilId, Integer count, DoubanShuoCategory category) throws DoubanException, IOException {
    setAccessToken(accessToken);
    String url = RequestUrls.DOUBAN_SHUO_STATUS_PREFIX + "/home_timeline";
    List<NameValuePair> params = generateParams(sinceId, untilId, count, category);
    DoubanShuoStatusObj[] result = this.client.getResponseInJsonArray(url, params, DoubanShuoStatusObj[].class, true);
    return result;
  }
  
  public DoubanShuoStatusObj[] getStatusesByUserId (String uid) throws DoubanException, IOException {
    return getStatusesByUserId(uid, null, null);
  }
  
  public DoubanShuoStatusObj[] getStatusesByUserId (String uid, Long sinceId, Long untilId) throws DoubanException, IOException {
    String url = RequestUrls.DOUBAN_SHUO_STATUS_PREFIX + "/user_timeline/" + uid;
    List<NameValuePair> params = generateParams(sinceId, untilId, null, null);
    DoubanShuoStatusObj[] result = this.client.getResponseInJsonArray(url, params, DoubanShuoStatusObj[].class, false);
    return result;
  }
  
  public boolean postNewStatus (String content, DoubanShuoAttachementObj att, String accessToken) throws DoubanException, IOException {
    setAccessToken(accessToken);
    if (content == null || content.isEmpty()) {
      throw ErrorHandler.missingRequiredParam();
    }
    Map<String, String> params = new HashMap<String, String>();
    params.put("source", DefaultConfigs.API_KEY);
    params.put("text", content);
    if (att != null) {
//      DoubanShuoStatusObj stau = new DoubanShuoStatusObj();
//      List<DoubanShuoAttachementObj> atts = new ArrayList<DoubanShuoAttachementObj>();
//      atts.add(att);
//      stau.setAttachements(atts);
      String attStr = Converters.parseDoubanObjToJSONStr(att);
      System.out.println("attstr : " + attStr);
      params.put("attachments", attStr);
    }
    try {
      String result = this.client.postEncodedEntry(RequestUrls.DOUBAN_SHUO_STATUS_PREFIX + "/", params, true);
      logger.info(result);
      return true;
    } catch (UnsupportedEncodingException ex) {
      logger.warning(ex.getMessage());
      return false;
    }
  }
  
  public DoubanShuoUserObj getUserInfoById (String userId) throws DoubanException, IOException {
    String url = RequestUrls.DOUBAN_SHUO_USER_PREFIX + "/" + userId;
    DoubanShuoUserObj result = this.client.getResponseInJson(url, null, DoubanShuoUserObj.class, false);
    return result;
  }
  
  public DoubanShuoUserObj[] getFollowingUserByUserId (String userId) throws DoubanException, IOException {
    String url = RequestUrls.DOUBAN_SHUO_USER_PREFIX + "/" + userId + "/following";
    DoubanShuoUserObj[] result = this.client.getResponseInJsonArray(url, null, DoubanShuoUserObj[].class, false);
    return result;
  }
  
  public DoubanShuoUserObj[] getFollowersByUserId (String userId) throws DoubanException, IOException {
    String url = RequestUrls.DOUBAN_SHUO_USER_PREFIX + "/" + userId + "/followers";
    DoubanShuoUserObj[] result = this.client.getResponseInJsonArray(url, null, DoubanShuoUserObj[].class, false);
    return result;
  }
  
  public boolean followUser (String targetId, String accessToken) throws DoubanException, IOException {
    setAccessToken(accessToken);
    if (targetId == null || targetId.isEmpty()) {
      throw ErrorHandler.missingRequiredParam();
    }
    Map<String, String> params = new HashMap<String, String>();
    params.put("source", DefaultConfigs.API_KEY);
    params.put("user_id", targetId);
    String url = RequestUrls.DOUBAN_SHUO_FRIENDSHIP_PREFIX + "/create";
    try {
      String result = this.client.postEncodedEntry(url, params, true);
      logger.info(result);
      return true;
    } catch (UnsupportedEncodingException ex) {
      logger.warning(ex.getMessage());
      return false;
    }
  }
  
  private List<NameValuePair> generateParams (Long sinceId, Long untilId, Integer count, DoubanShuoCategory category) {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    if (sinceId != null) {
      params.add(new BasicNameValuePair("since_id", "" + sinceId));
    }
    if (untilId != null) {
      params.add(new BasicNameValuePair("until_id", "" + untilId));
    }
    if (count != null) {
      params.add(new BasicNameValuePair("count", "" + count));
    }
    if (category != null) {
      params.add(new BasicNameValuePair("category", category.getValue()));
    }
    return params;
  }
  
}
