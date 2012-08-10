/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dongxuexidu.douban4j.model.common;

import com.dongxuexidu.douban4j.model.IDoubanObject;
import net.sf.json.JSON;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanTagObj implements IDoubanObject{

  @Override
  public String getObjName() {
    return "tag";
  }
  
  private String name;

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

  @Override
  public IDoubanObject ConvertFrom(JSON json) {
    throw new UnsupportedOperationException("Not supported yet.");
  }
  
}
