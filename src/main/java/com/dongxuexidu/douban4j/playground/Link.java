/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dongxuexidu.douban4j.playground;

import com.google.api.client.util.Key;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class Link {

  @Key("@href")
  private String href;
  
  @Key("@rel")
  private String rel;
  
  public Link(String href, String rel) {
    this.href = href;
    this.rel = rel;
  }
  
  @Override
  public String toString() {
    
    return "\thref : " + getHref() + " , rel : " + getRel();
    
  }

  /**
   * @return the href
   */
  public String getHref() {
    return href;
  }

  /**
   * @param href the href to set
   */
  public void setHref(String href) {
    this.href = href;
  }

  /**
   * @return the rel
   */
  public String getRel() {
    return rel;
  }

  /**
   * @param rel the rel to set
   */
  public void setRel(String rel) {
    this.rel = rel;
  }
}
