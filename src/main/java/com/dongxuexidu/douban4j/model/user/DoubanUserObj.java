package com.dongxuexidu.douban4j.model.user;

import com.dongxuexidu.douban4j.model.IDoubanObject;
import com.dongxuexidu.douban4j.model.common.DoubanLinkObj;
import com.dongxuexidu.douban4j.model.common.DoubanLocationObj;
import com.google.api.client.util.Key;
import java.util.List;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanUserObj implements IDoubanObject {

  @Key
  private String id;
  
  @Key
  private String title;
  
  @Key ("link")
  private List<DoubanLinkObj> links;
  
  @Key
  private String content;
  
  @Key ("db:location")
  private DoubanLocationObj location;

  @Key ("db:signature")
  private String signature;
  
  @Key ("db:uid")
  private String uid;
  
  @Key
  private String uri;

  @Override
  public String getObjName() {
    return "doubanuser";
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
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * @param title the title to set
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * @return the links
   */
  public List<DoubanLinkObj> getLinks() {
    return links;
  }
  
  public void setLinks (List<DoubanLinkObj> links) {
    this.links = links;
  }

  /**
   * @param links the links to set
   */
  public void addLink(String href, String rel) {
    this.links.add(new DoubanLinkObj(href, rel));
  }
  
  public String getLinkByRel (String rel) {
    for (DoubanLinkObj obj : this.links) {
      if (obj.getRel().equalsIgnoreCase(rel)) {
        return obj.getHref();
      }
    }
    return null;
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

  /**
   * @return the location
   */
  public DoubanLocationObj getLocation() {
    return location;
  }

  /**
   * @param location the location to set
   */
  public void setLocation(DoubanLocationObj location) {
    this.location = location;
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
   * @return the uri
   */
  public String getUri() {
    return uri;
  }

  /**
   * @param uri the uri to set
   */
  public void setUri(String uri) {
    this.uri = uri;
  }
 

}
