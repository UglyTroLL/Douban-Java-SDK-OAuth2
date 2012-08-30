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
import net.sf.json.JSONObject;
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
  
  public static enum DoubanShuoRelation {
    
    FollowingOnly,
    BeFollowedOnly,
    Stranger,
    Friend;
    
  }
  
  final static Logger logger = Logger.getLogger(DoubanShuoService.class.getName());

  public DoubanShuoService(String accessToken) {
    super(accessToken);
  }
  
  public DoubanShuoService() {
    super();
  }
  
  public DoubanShuoStatusObj[] getHomeTimelineForLoggedInUser (String accessToken) throws DoubanException, IOException {
    return getHomeTimelineForLoggedInUser(accessToken, null, null, null, null);
  }
  
  public DoubanShuoStatusObj[] getHomeTimelineForLoggedInUser (String accessToken, Long sinceId, Long untilId, Integer count, DoubanShuoCategory category) throws DoubanException, IOException {
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
  
  public boolean postNewStatus (String content, DoubanShuoAttachementObj att, String appKey, String accessToken) throws DoubanException, IOException {
    setAccessToken(accessToken);
    if (content == null || content.isEmpty()) {
      throw ErrorHandler.missingRequiredParam();
    }
    Map<String, String> params = new HashMap<String, String>();
    params.put("source", appKey);
    params.put("text", content);
    if (att != null) {
//      DoubanShuoStatusObj stau = new DoubanShuoStatusObj();
//      List<DoubanShuoAttachementObj> atts = new ArrayList<DoubanShuoAttachementObj>();
//      atts.add(att);
//      stau.setAttachements(atts);
      DoubanShuoAttachementObj[] atts = {att};
      String attStr = Converters.parseDoubanObjToJSONStr(atts);
      System.out.println("attstr : " + attStr);
      params.put("attachments", attStr);
    }
    try {
      String result = this.client.postEncodedEntry(RequestUrls.DOUBAN_SHUO_STATUS_PREFIX + "/", params, true);
      logger.info("new post : " + result);
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
  
  public boolean followUser (String targetId, String appKey, String accessToken) throws DoubanException, IOException {
    setAccessToken(accessToken);
    if (targetId == null || targetId.isEmpty()) {
      throw ErrorHandler.missingRequiredParam();
    }
    Map<String, String> params = new HashMap<String, String>();
    params.put("source", appKey);
    params.put("user_id", targetId);
    String url = RequestUrls.DOUBAN_SHUO_FRIENDSHIP_PREFIX + "/create";
    try {
      String result = this.client.postEncodedEntry(url, params, true);
      logger.info("new following user : " + result);
      return true;
    } catch (UnsupportedEncodingException ex) {
      logger.warning(ex.getMessage());
      return false;
    }
  }
  
  public DoubanShuoRelation getRelationship (String sourceId, String targetId, String appKey) throws DoubanException, IOException {
    String url = RequestUrls.DOUBAN_SHUO_FRIENDSHIP_PREFIX + "/show";
    Map<String, String> params = new HashMap<String, String>();
    params.put("source", appKey);
    params.put("source_id", sourceId);
    params.put("target_id", targetId);
    try {
      String result = this.client.postEncodedEntry(url, params, false);
      DoubanShuoRelation relation = determineRelation(result);
      return relation;
    } catch (UnsupportedEncodingException ex) {
      logger.warning(ex.getMessage());
      return null;
    }
  }
  
  private DoubanShuoRelation determineRelation (String result) {
    JSONObject obj = JSONObject.fromObject(result.trim());
    if (obj.containsKey("source") && obj.containsKey("target")) {
      JSONObject source = obj.getJSONObject("source");
      boolean following = source.getBoolean("following");
      boolean followedBy = source.getBoolean("followed_by");
      if (following && (!followedBy)) {
        return DoubanShuoRelation.FollowingOnly;
      } else if ((!following) && followedBy) {
        return DoubanShuoRelation.BeFollowedOnly;
      } else if (following && followedBy) {
        return DoubanShuoRelation.Friend;
      } else {
        return DoubanShuoRelation.Stranger;
      }
    } else {
      return null;
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
