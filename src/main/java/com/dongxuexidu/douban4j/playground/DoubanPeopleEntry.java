/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dongxuexidu.douban4j.playground;

import com.google.api.client.util.Key;
import java.util.List;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanPeopleEntry {
  
  @Key
  private String id;
  
  @Key
  private String title;
  
  @Key ("link")
  private List<Link> links;
  
  @Key
  private String content;
  
  @Key ("db:location")
  private Location location;
  
//  @Key ("db:location/@id")
//  private String locationId;
  
  @Key ("db:signature")
  private String signature;
  
  @Key ("db:uid")
  private String uid;
  
  @Key
  private String uri;
  
  @Override
  public String toString() {
    
    String result = "id : " + id + "\n"
            + "title : " + title + "\n";
    for (Link l : links) {
      result = result + l.toString() + "\n";
    }
    result = result + "content : " + content + "\n"
            + "location : " + location + "\n"
            //+ "location id : " + locationId + "\n"
            + "sign : " + signature + "\n"
            + "uid : " + uid + "\n"
            + "uri : " + uri;
    return result;
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
  public List<Link> getLinks() {
    return links;
  }

  /**
   * @param links the links to set
   */
  public void addLink(String href, String rel) {
    this.links.add(new Link(href, rel));
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
//  public String getLocation() {
//    return location;
//  }

  /**
   * @param location the location to set
   */
//  public void setLocation(String location) {
//    this.location = location;
//  }

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
