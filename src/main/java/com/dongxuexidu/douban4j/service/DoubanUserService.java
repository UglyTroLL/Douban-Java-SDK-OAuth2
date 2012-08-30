package com.dongxuexidu.douban4j.service;

import com.dongxuexidu.douban4j.constants.RequestUrls;
import com.dongxuexidu.douban4j.model.app.DoubanException;
import com.dongxuexidu.douban4j.model.user.DoubanUserFeedObj;
import com.dongxuexidu.douban4j.model.user.DoubanUserObj;
import com.dongxuexidu.douban4j.utils.ErrorHandler;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */

public class DoubanUserService extends DoubanService {
  
  public DoubanUserService () {
    super();
  }
  
  public DoubanUserService (String accessToken) {
    super(accessToken);
  }
  
  public DoubanUserObj getUserProfileByUid (String uid) throws DoubanException, IOException {
    String url = RequestUrls.DOUBAN_USER_PREFIX + "/" + uid;
    DoubanUserObj result = this.client.getResponse(url, null, DoubanUserObj.class, false);
    return result;
  }
  
  public DoubanUserObj getLoggedInUserProfile (String accessToken) throws DoubanException, IOException {
    setAccessToken(accessToken);
    DoubanUserObj result = this.client.getResponse(RequestUrls.DOUBAN_USER_PREFIX + URLEncoder.encode("/@me", "utf-8"), null, DoubanUserObj.class, true);
    return result;
  }
  
  public DoubanUserFeedObj searchUserProfile (String keyword) throws DoubanException, IOException {
    return searchUserProfile(keyword, null, null);
  }

  public DoubanUserFeedObj searchUserProfile (String keyword, Integer startIndex, Integer maxResultCount) throws DoubanException, IOException {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    if (keyword != null && keyword.length() > 0) {
      params.add(new BasicNameValuePair("q", keyword));
    } else {
      throw ErrorHandler.missingRequiredParam();
    }
    if (startIndex != null) {
      params.add(new BasicNameValuePair("start-index", startIndex.toString()));
    }
    if (maxResultCount != null) {
      params.add(new BasicNameValuePair("max-results", maxResultCount.toString()));
    }
    DoubanUserFeedObj result = this.client.getResponse(RequestUrls.DOUBAN_USER_PREFIX, params, DoubanUserFeedObj.class, false);
    return result;
  }
  
  public DoubanUserFeedObj getUsersFriendsList (String uid, String accessToken) throws DoubanException, IOException {
    return getUsersFriendsList(uid, null, null, accessToken);
  }
  
  public DoubanUserFeedObj getUsersFriendsList (String uid, Integer startIndex, Integer maxResultCount, String accessToken) throws DoubanException, IOException {
    setAccessToken(accessToken);
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    if (uid == null || uid.isEmpty()) {
      throw ErrorHandler.getCustomDoubanException(100, "We cannot get the friend list from a ghost, please specify a user id");
    }
    if (startIndex != null) {
      params.add(new BasicNameValuePair("start-index", startIndex.toString()));
    }
    if (maxResultCount != null) {
      params.add(new BasicNameValuePair("max-results", maxResultCount.toString()));
    }
    String url = RequestUrls.DOUBAN_USER_PREFIX + "/" + uid + "/friends";
    DoubanUserFeedObj result = this.client.getResponse(url, params, DoubanUserFeedObj.class, true);
    return result;
  }
  
  public DoubanUserFeedObj getUsersContactsList (String uid) throws DoubanException, IOException {
    return getUsersContactsList(uid, null, null);
  }
  
  public DoubanUserFeedObj getUsersContactsList (String uid, Integer startIndex, Integer maxResultCount) throws DoubanException, IOException {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    if (uid == null || uid.isEmpty()) {
      throw ErrorHandler.getCustomDoubanException(100, "We cannot get the contact list from a ghost, please specify a user id");
    }
    if (startIndex != null) {
      params.add(new BasicNameValuePair("start-index", startIndex.toString()));
    }
    if (maxResultCount != null) {
      params.add(new BasicNameValuePair("max-results", maxResultCount.toString()));
    }
    String url = RequestUrls.DOUBAN_USER_PREFIX + "/" + uid + "/contacts";
    DoubanUserFeedObj result = this.client.getResponse(url, params, DoubanUserFeedObj.class, false);
    return result;
  }

  
}
