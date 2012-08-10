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
public class DoubanAuthorObj implements IDoubanObject {

  @Override
  public String getObjName() {
    return "author";
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
    JSONObject obj = (JSONObject) json;
    this.setName(obj.containsKey("name") ? obj.getJSONObject("name").getString("$t") : "");
    return this;
  }
  
}
