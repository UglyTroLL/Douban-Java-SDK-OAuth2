/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dongxuexidu.douban4j.model.common;

import com.dongxuexidu.douban4j.model.IDoubanObject;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class PlainTextObj implements IDoubanObject{
  
  private String value;
  
  public PlainTextObj () {
    
  }
  
  public PlainTextObj (String val) {
    this.value = val;
  }

  @Override
  public String getObjName() {
    return "plaintext";
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
