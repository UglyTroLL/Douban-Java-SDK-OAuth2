/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dongxuexidu.douban4j.model.common;

import com.dongxuexidu.douban4j.model.IDoubanObject;
import com.google.api.client.util.Key;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanTagObj implements IDoubanObject{

  @Override
  public String getObjName() {
    return "tag";
  }
  
  @Key("@name")
  private String name;
  
  @Key("@count")
  private String count;

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the count
   */
  public String getCount() {
    return count;
  }

  /**
   * @param count the count to set
   */
  public void setCount(String count) {
    this.count = count;
  }
  
}
