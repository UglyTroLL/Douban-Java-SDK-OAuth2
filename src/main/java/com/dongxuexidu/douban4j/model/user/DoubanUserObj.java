package com.dongxuexidu.douban4j.model.user;

import com.dongxuexidu.douban4j.model.IDoubanObject;
import java.util.HashMap;
import java.util.Map;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanUserObj implements IDoubanObject {

  private String idStr = "";
  private long idNum = 0;
  private Location location = null;
  private String signature = "";
  private String screenName = "";
  private String uri = "";
  private String content = "";
  private Map<String, String> links = new HashMap<String, String>();

  @Override
  public String getObjName() {
    return "user";
  }

  /**
   * @return the idStr
   */
  public String getIdStr() {
    return idStr;
  }

  /**
   * @param idStr the idStr to set
   */
  public void setIdStr(String idStr) {
    this.idStr = idStr;
  }

  /**
   * @return the idNum
   */
  public long getIdNum() {
    return idNum;
  }

  /**
   * @return the location
   */
  public String getLocationId() {
    return location == null ? null : location.getId();
  }
  
  public String getLocationName() {
    return location == null ? null : location.getScreenName();
  }

  /**
   * @param location the location to set
   */
  public void setLocationId(String locationId) {
    if (this.location == null) {
      this.location = new Location();
    }
    this.location.setId(locationId);
  }
  
  public void setLocationName(String locationId) {
    if (this.location == null) {
      this.location = new Location();
    }
    this.location.setId(locationId);
  }

  /**
   * @return the signature
   */
  public String getSignature() {
    return signature;
  }

  /**
   * @param signature the signature to set
   */
  public void setSignature(String signature) {
    this.signature = signature;
  }

  /**
   * @return the screenName
   */
  public String getScreenName() {
    return screenName;
  }

  /**
   * @param screenName the screenName to set
   */
  public void setScreenName(String screenName) {
    this.screenName = screenName;
  }

  /**
   * @return the uri
   */
  public String getUri() {
    return uri;
  }

  /**
   * @param uri the uri to set
   */
  public void setUriAndIdNum(String uri) {
    this.uri = uri;
    String idLongStr = uri.substring(uri.lastIndexOf("/"));
    try {
      Long id = Long.valueOf(idLongStr);
      this.idNum = id;
    } catch (NumberFormatException ex) {
      
    }
  }

  /**
   * @return the content
   */
  public String getContent() {
    return content;
  }

  /**
   * @param content the content to set
   */
  public void setContent(String content) {
    this.content = content;
  }
  
  public String getSelfLink () {
    if (links.containsKey("self")) {
      return links.get("self");
    } else {
      return null;
    }
  }
  
  public String getAlternateLink () {
    if (links.containsKey("alternate")) {
      return links.get("alternate");
    } else {
      return null;
    }
  }
  
  public String getIconUrl () {
    if (links.containsKey("icon")) {
      return links.get("icon");
    } else {
      return null;
    }
  }

  /**
   * @param links the links to set
   */
  public void addLink(String type, String value) {
    this.links.put(type, value);
  }

  @Override
  public IDoubanObject ConvertFrom(JSON json) {
    JSONObject jObj = (JSONObject)json;
    this.setContent(jObj.containsKey("content") ? jObj.getJSONObject("content").getString("$t") : "");
    this.setIdStr(jObj.containsKey("db:uid") ? jObj.getJSONObject("db:uid").getString("$t") : "");
    this.setUriAndIdNum(jObj.getJSONObject("uri").getString("$t"));
    this.setLocationName(jObj.containsKey("db:location") ? jObj.getJSONObject("db:location").getString("$t") : "");
    this.setLocationId(jObj.containsKey("db:location") ? jObj.getJSONObject("db:location").getString("@id") : "");
    this.setScreenName(jObj.containsKey("title") ? jObj.getJSONObject("title").getString("$t") : "");
    this.setSignature(jObj.containsKey("db:signature") ? jObj.getJSONObject("db:signature").getString("$t") : "");
    if (jObj.containsKey("link")) {
      JSONArray jArr = jObj.getJSONArray("link");
      for (int i = 0 ; i < jArr.size() ; i ++) {
        JSONObject linkObj = jArr.getJSONObject(i);
        this.addLink(linkObj.getString("@rel"), linkObj.getString("@href"));
      }
    }
    return this;
  }
  
  class Location {

    private String id = "";
    private String screenName = "";

    /**
     * @return the id
     */
    public String getId() {
      return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
      this.id = id;
    }

    /**
     * @return the screenName
     */
    public String getScreenName() {
      return screenName;
    }

    /**
     * @param screenName the screenName to set
     */
    public void setScreenName(String screenName) {
      this.screenName = screenName;
    }
  }
}
