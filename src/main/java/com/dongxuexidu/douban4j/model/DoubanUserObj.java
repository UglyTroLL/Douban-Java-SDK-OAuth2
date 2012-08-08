package com.dongxuexidu.douban4j.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanUserObj implements IDoubanObject {

  private String idStr = "";
  private long idNum = 0;
  private Location location;
  private String signature;
  private String screenName;
  private String uri;
  private String content;
  private Map<String, String> links = new HashMap<String, String>();

  @Override
  public String getName() {
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
    return location.getId();
  }
  
  public String getLocationName() {
    return location.getScreenName();
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
  
  class Location {

    private String id;
    private String screenName;

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
