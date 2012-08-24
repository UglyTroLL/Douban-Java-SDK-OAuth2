package com.dongxuexidu.douban4j.model.common;

import com.dongxuexidu.douban4j.model.IDoubanObject;
import com.google.api.client.util.Key;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanWhenObj implements IDoubanObject{
  
  @Key("@endTime")
  private String endTime;
  
  @Key("@startTime")
  private String startTime;

  @Override
  public String getObjName() {
    return "doubanwhen";
  }

  /**
   * @return the endTime
   */
  public String getEndTime() {
    return endTime;
  }

  /**
   * @param endTime the endTime to set
   */
  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  /**
   * @return the startTime
   */
  public String getStartTime() {
    return startTime;
  }

  /**
   * @param startTime the startTime to set
   */
  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }
  
}
