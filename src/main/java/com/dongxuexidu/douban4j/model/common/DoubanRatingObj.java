/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dongxuexidu.douban4j.model.common;

import com.dongxuexidu.douban4j.model.IDoubanObject;
import net.sf.json.JSON;
import net.sf.json.JSONObject;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanRatingObj implements IDoubanObject{

  @Override
  public String getObjName() {
    return "rating";
  }
  
  private int min = 1;
  private int max = 5;
  private String value = "";

  @Override
  public IDoubanObject ConvertFrom(JSON json) {
    JSONObject obj = (JSONObject)json;
    this.setMin(obj.containsKey("@min") ? obj.getInt("@min") : 1);
    this.setMax(obj.containsKey("@max") ? obj.getInt("@max") : 5);
    this.setValue(obj.containsKey("@value") ? obj.getString("@value") : "");
    return this;
  }

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
