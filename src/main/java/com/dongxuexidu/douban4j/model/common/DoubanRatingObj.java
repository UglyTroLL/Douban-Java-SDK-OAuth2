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
  private int value = 0;
  
  @Key("@average")
  private float average = 0.0f;
  
  @Key("@numRaters")
  private int numberOfRaters = 0;

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
  public int getValue() {
    return value;
  }

  /**
   * @return the numberOfRaters
   */
  public int getNumberOfRaters() {
    return numberOfRaters;
  }

  /**
   * @param numberOfRaters the numberOfRaters to set
   */
  public void setNumberOfRaters(int numberOfRaters) {
    this.numberOfRaters = numberOfRaters;
  }

  /**
   * @param value the value to set
   */
  public void setValue(int value) {
    this.value = value;
  }

  /**
   * @return the average
   */
  public float getAverage() {
    return average;
  }

  /**
   * @param average the average to set
   */
  public void setAverage(float average) {
    this.average = average;
  }
  
}
