package com.dongxuexidu.douban4j.model.shuo;

import com.dongxuexidu.douban4j.model.IDoubanObject;
import com.google.api.client.util.Key;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanShuoMediaObj implements IDoubanObject{
  
  @Key
  private String src;
  
  @Key
  private String href;
  
  @Key("original_src")
  private String originalSrc;
  
  @Key("type")
  private String type;

  @Override
  public String getObjName() {
    return "doubanshuomedia";
  }

  /**
   * @return the src
   */
  public String getSrc() {
    return src;
  }

  /**
   * @param src the src to set
   */
  public void setSrc(String src) {
    this.src = src;
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
   * @return the originalSrc
   */
  public String getOriginalSrc() {
    return originalSrc;
  }

  /**
   * @param originalSrc the originalSrc to set
   */
  public void setOriginalSrc(String originalSrc) {
    this.originalSrc = originalSrc;
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
  
}
