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
public class DoubanRatingObj implements IDoubanObject{

  @Override
  public String getObjName() {
    return "rating";
  }
  
  @Key("@min")
  private int min = 1;
  
  @Key("@max")
  private int max = 5;
  
  @Key("@value")
  private String value = "";

  /**
   * @return the min
   */
  public int getMin() {
    return min;
  }

  /**
   * @param min the min to set
   */
  public void setMin(int min) {
    this.min = min;
  }

  /**
   * @return the max
   */
  public int getMax() {
    return max;
  }

  /**
   * @param max the max to set
   */
  public void setMax(int max) {
    this.max = max;
  }

  /**
   * @return the value
   */
  public String getValue() {
    return value;
  }

  /**
   * @param value the value to set
   */
  public void setValue(String value) {
    this.value = value;
  }
  
}
