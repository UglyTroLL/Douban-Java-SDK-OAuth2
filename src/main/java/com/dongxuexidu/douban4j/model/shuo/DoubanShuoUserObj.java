package com.dongxuexidu.douban4j.model.shuo;

import com.dongxuexidu.douban4j.model.IDoubanObject;
import com.google.api.client.util.Key;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanShuoUserObj implements IDoubanObject{
  
  @Key("city")
  private String city;
  
  @Key("icon_avatar")
  private String iconNormal;
  
  @Key("statuses_count")
  private int totalStatusCount = 0;
  
  @Key("uid")
  private String uid;
  
  @Key("url")
  private String url;
  
  @Key("created_at")
  private String createdDate;
  
  //What the hell is this?
  @Key("new_site_to_vu_count")
  private int newSiteCount = 0;
  
  @Key("large_avatar")
  private String iconLarge;
  
  @Key("screen_name")
  private String screenName;
  
  @Key("location")
  private String location;
  
  @Key("small_avatar")
  private String iconSmall;
  
  @Key("following")
  private boolean following = false;
  
  @Key("verified")
  private boolean verified = false;
  
  @Key("is_first_visit")
  private boolean isFirstVisit = false;
  
  @Key("type")
  private String type;
  
  @Key("id")
  private String id;
  
  @Key("description")
  private String description;
  
  @Key("original_site_url")
  private String siteUrl;

  @Override
  public String getObjName() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  /**
   * @return the city
   */
  public String getCity() {
    return city;
  }

  /**
   * @param city the city to set
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * @return the iconNormal
   */
  public String getIconNormal() {
    return iconNormal;
  }

  /**
   * @param iconNormal the iconNormal to set
   */
  public void setIconNormal(String iconNormal) {
    this.iconNormal = iconNormal;
  }

  /**
   * @return the totalStatusCount
   */
  public int getTotalStatusCount() {
    return totalStatusCount;
  }

  /**
   * @param totalStatusCount the totalStatusCount to set
   */
  public void setTotalStatusCount(int totalStatusCount) {
    this.totalStatusCount = totalStatusCount;
  }

  /**
   * @return the uid
   */
  public String getUid() {
    return uid;
  }

  /**
   * @param uid the uid to set
   */
  public void setUid(String uid) {
    this.uid = uid;
  }

  /**
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * @param url the url to set
   */
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   * @return the createdDate
   */
  public String getCreatedDate() {
    return createdDate;
  }

  /**
   * @param createdDate the createdDate to set
   */
  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }

  /**
   * @return the newSiteCount
   */
  public int getNewSiteCount() {
    return newSiteCount;
  }

  /**
   * @param newSiteCount the newSiteCount to set
   */
  public void setNewSiteCount(int newSiteCount) {
    this.newSiteCount = newSiteCount;
  }

  /**
   * @return the iconLarge
   */
  public String getIconLarge() {
    return iconLarge;
  }

  /**
   * @param iconLarge the iconLarge to set
   */
  public void setIconLarge(String iconLarge) {
    this.iconLarge = iconLarge;
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
   * @return the location
   */
  public String getLocation() {
    return location;
  }

  /**
   * @param location the location to set
   */
  public void setLocation(String location) {
    this.location = location;
  }

  /**
   * @return the iconSmall
   */
  public String getIconSmall() {
    return iconSmall;
  }

  /**
   * @param iconSmall the iconSmall to set
   */
  public void setIconSmall(String iconSmall) {
    this.iconSmall = iconSmall;
  }

  /**
   * @return the following
   */
  public boolean isFollowing() {
    return following;
  }

  /**
   * @param following the following to set
   */
  public void setFollowing(boolean following) {
    this.following = following;
  }

  /**
   * @return the verified
   */
  public boolean isVerified() {
    return verified;
  }

  /**
   * @param verified the verified to set
   */
  public void setVerified(boolean verified) {
    this.verified = verified;
  }

  /**
   * @return the isFirstVisit
   */
  public boolean isIsFirstVisit() {
    return isFirstVisit;
  }

  /**
   * @param isFirstVisit the isFirstVisit to set
   */
  public void setIsFirstVisit(boolean isFirstVisit) {
    this.isFirstVisit = isFirstVisit;
  }

  /**
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * @param type the type to set
   */
  public void setType(String type) {
    this.type = type;
  }

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
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * @return the siteUrl
   */
  public String getSiteUrl() {
    return siteUrl;
  }

  /**
   * @param siteUrl the siteUrl to set
   */
  public void setSiteUrl(String siteUrl) {
    this.siteUrl = siteUrl;
  }
  
  
}
