package com.dongxuexidu.douban4j.model.v2;

import com.dongxuexidu.douban4j.model.IDoubanObject;
import com.google.api.client.util.Key;

/**
 * 
 * @author Sean Guo <seanguo85@qq.com>
 *
 */
public class DoubanRatingObj implements IDoubanObject {
  
  @Key
  private int max;
  
  @Key
  private float average;
  
  @Key
  private int stars;
  
  @Key
  private int min;

  @Override
  public String getObjName() {
    return "DoubanRatingObj";
  }

  public int getMax() {
    return max;
  }

  public float getAverage() {
    return average;
  }

  public int getStars() {
    return stars;
  }

  public int getMin() {
    return min;
  }

  @Override
  public String toString() {
    return "DoubanRatingObj [max=" + max + ", average=" + average + ", stars=" + stars + ", min=" + min + "]";
  }
}
