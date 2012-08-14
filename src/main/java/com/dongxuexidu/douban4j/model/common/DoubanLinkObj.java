package com.dongxuexidu.douban4j.model.common;

import com.dongxuexidu.douban4j.model.IDoubanObject;
import com.google.api.client.util.Key;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanLinkObj implements IDoubanObject{
  
  @Key("@href")
  private String href;
  
  @Key("@rel")
  private String rel;
  
  public DoubanLinkObj (String href, String rel) {
    this.href = href;
    this.rel = rel;
  }
  
  public DoubanLinkObj() {
    //do nothing here at this point
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

  @Override
  public String getObjName() {
    return "doubanlink";
  }
  
}
