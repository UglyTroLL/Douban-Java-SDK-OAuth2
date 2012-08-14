package com.dongxuexidu.douban4j.service;

import com.dongxuexidu.douban4j.constants.RequestUrls;
import com.dongxuexidu.douban4j.model.app.DoubanException;
import com.dongxuexidu.douban4j.model.user.DoubanUserObj;
import com.dongxuexidu.douban4j.utils.Converters;
import com.dongxuexidu.douban4j.utils.ErrorHandler;
import com.dongxuexidu.douban4j.utils.HttpManager;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanUserService extends DoubanService {
  
  private static final Integer REQUEST_TYPE_OTHER = 1;
  private static final Integer REQUEST_TYPE_SELF = 2;
  
  private static final Integer REQUEST_TYPE_USERS_FRIENDS = 3;
  private static final Integer REQUEST_TYPE_USERS_CONTACTS = 4;
  
  public DoubanUserService () {
    super();
  }
  
  public DoubanUserService (String accessToken) {
    super(accessToken);
  }
  
  public void setAccessToken (String accessToken) {
    this.client.setAccessToken(accessToken);
  }
  
//  private String getUserProfileInRaw (int type, String uid) throws DoubanException {
//    String url;
//    if (type == REQUEST_TYPE_OTHER) {
//      url = RequestUrls.GET_USER_PROFILE_URL + uid;
//      return this.client.getResponse(url, null, false);
//    } else {
//      url = RequestUrls.GET_CURRENT_USER_PROFILE_URL;
//      return this.client.getResponse(url, null, true);
//    }
//  }
//  
//  private String getUserFriendsOrContactsInRaw (int type, String uid, List<NameValuePair> params) throws DoubanException {
//    String url;
//    if (type == REQUEST_TYPE_USERS_FRIENDS) {
//      url = RequestUrls.GET_USER_PROFILE_URL + uid + "/friends";
//    } else {
//      url = RequestUrls.GET_USER_PROFILE_URL + uid + "/contacts";
//    }
//    return this.client.getResponse(url, params, true);
//  }
//  
//  //----------Search--------------
//  
//  public JSONArray searchUserProfileInJSONObj (String keyword) throws DoubanException {
//    return searchUserProfileInJSONObj(keyword, 0, 10);
//  }
//  
//  public List<DoubanUserObj> searchUserProfile (String keyword) throws DoubanException {
//    return searchUserProfile(keyword, 0, 10);
//  }
//  
//  public JSONArray searchUserProfileInJSONObj (String keyword, int startIndex, int maxResultCount) throws DoubanException {
//    List<NameValuePair> params = new ArrayList<NameValuePair>();
//    params.add(new NameValuePair("q", keyword));
//    params.add(new NameValuePair("start-index", "" + startIndex));
//    params.add(new NameValuePair("max-results", "" + maxResultCount));
//    String returnStr = this.client.getResponse(RequestUrls.SEARCH_USER_URL, params, false);
//    DoubanException exp = ErrorHandler.handleError(returnStr);
//    if (exp != null) {
//      throw exp;
//    }
//    JSONObject jObj = Converters.toJsonObj(returnStr);
//    JSONArray allResult = jObj.getJSONArray("entry");
//    return allResult;
//  }
//  
//  public List<DoubanUserObj> searchUserProfile (String keyword, int startIndex, int maxResultCount) throws DoubanException {
//    JSONArray resultArr = searchUserProfileInJSONObj(keyword, startIndex, maxResultCount);
//    List<DoubanUserObj> result = new ArrayList<DoubanUserObj>();
//    for (int i = 0 ; i < resultArr.size() ; i ++) {
//      JSONObject resultObj = resultArr.getJSONObject(i);
//      result.add((DoubanUserObj)new DoubanUserObj().ConvertFrom(resultObj));
//    }
//    return result;
//  }
//  
//  //-----------------User profile------------------------
//  
//  public JSONObject getUserProfileInJSONObj (String uid) throws DoubanException {
//    String response = getUserProfileInRaw(REQUEST_TYPE_OTHER, uid);
//    DoubanException exp = ErrorHandler.handleError(response);
//    if (exp != null) {
//      throw exp;
//    }
//    JSONObject jObj = Converters.toJsonObj(response);
//    return jObj;
//  }
//  
//  public DoubanUserObj getUserProfile (String uid) throws DoubanException {
//    JSONObject jObj = getUserProfileInJSONObj(uid);
//    return (DoubanUserObj)new DoubanUserObj().ConvertFrom(jObj);
//  }
//  
//  public JSONObject getCurrentUserProfileInJSONObj () throws DoubanException {
//    String response = getUserProfileInRaw(REQUEST_TYPE_SELF, "");
//    DoubanException exp = ErrorHandler.handleError(response);
//    if (exp != null) {
//      throw exp;
//    }
//    JSONObject jObj = Converters.toJsonObj(response);
//    return jObj;
//  }
//  
//  public DoubanUserObj getCurrentUserProfile () throws DoubanException {
//    JSONObject jObj = getCurrentUserProfileInJSONObj();
//    return (DoubanUserObj)new DoubanUserObj().ConvertFrom(jObj);
//  }
//  
//  //-------------------User's friends profile--------------------------
//  
//  public JSONArray getUsersFriendsListInJSONArray(String uid) throws DoubanException {
//    return getUsersFriendsListInJSONArray(uid, 0, 10);
//  }
//  
//  public List<DoubanUserObj> getUsersFriendsList(String uid) throws DoubanException {
//    return getUsersFriendsList(uid, 0, 10);
//  }
//  
//  public JSONArray getUsersFriendsListInJSONArray (String uid, int startIndex, int maxResultCount) throws DoubanException {
//    List<NameValuePair> params = new ArrayList<NameValuePair>();
//    params.add(new NameValuePair("start-index", "" + startIndex));
//    params.add(new NameValuePair("max-results", "" + maxResultCount));
//    String resultStr = getUserFriendsOrContactsInRaw(REQUEST_TYPE_USERS_FRIENDS, uid, params);
//    DoubanException exp = ErrorHandler.handleError(resultStr);
//    if (exp != null) {
//      throw exp;
//    }
//    JSONObject jObj = Converters.toJsonObj(resultStr);
//    JSONArray allResult = jObj.getJSONArray("entry");
//    return allResult;
//  }
//  
//  public List<DoubanUserObj> getUsersFriendsList (String uid, int startIndex, int maxResultCount) throws DoubanException {
//    JSONArray resultArr = getUsersFriendsListInJSONArray(uid, startIndex, maxResultCount);
//    List<DoubanUserObj> result = new ArrayList<DoubanUserObj>();
//    for (int i = 0 ; i < resultArr.size() ; i ++) {
//      JSONObject resultObj = resultArr.getJSONObject(i);
//      result.add((DoubanUserObj)new DoubanUserObj().ConvertFrom(resultObj));
//    }
//    return result;
//  }
//  
//  //-------------------User's contacts profile--------------------------
//  
//  public JSONArray getUsersContactsListInJSONArray(String uid) throws DoubanException {
//    return getUsersFriendsListInJSONArray(uid, 0, 10);
//  }
//  
//  public List<DoubanUserObj> getUsersContactsList(String uid) throws DoubanException {
//    return getUsersFriendsList(uid, 0, 10);
//  }
//  
//  public JSONArray getUsersContactsListInJSONArray (String uid, int startIndex, int maxResultCount) throws DoubanException {
//    List<NameValuePair> params = new ArrayList<NameValuePair>();
//    params.add(new NameValuePair("start-index", "" + startIndex));
//    params.add(new NameValuePair("max-results", "" + maxResultCount));
//    String resultStr = getUserFriendsOrContactsInRaw(REQUEST_TYPE_USERS_CONTACTS, uid, params);
//    DoubanException exp = ErrorHandler.handleError(resultStr);
//    if (exp != null) {
//      throw exp;
//    }
//    JSONObject jObj = Converters.toJsonObj(resultStr);
//    JSONArray allResult = jObj.getJSONArray("entry");
//    return allResult;
//  }
//  
//  public List<DoubanUserObj> getUsersContactsList (String uid, int startIndex, int maxResultCount) throws DoubanException {
//    JSONArray resultArr = getUsersFriendsListInJSONArray(uid, startIndex, maxResultCount);
//    List<DoubanUserObj> result = new ArrayList<DoubanUserObj>();
//    for (int i = 0 ; i < resultArr.size() ; i ++) {
//      JSONObject resultObj = resultArr.getJSONObject(i);
//      result.add((DoubanUserObj)new DoubanUserObj().ConvertFrom(resultObj));
//    }
//    return result;
//  }
//  
//  public static void main(String[] args) {
//    try {
//      DoubanUserService test = new DoubanUserService();
//      System.out.println(test.searchUserProfile("uglytroll").toString());
//    } catch (DoubanException ex) {
//      Logger.getLogger(DoubanUserService.class.getName()).log(Level.SEVERE, null, ex);
//    }
//  }
  
}
