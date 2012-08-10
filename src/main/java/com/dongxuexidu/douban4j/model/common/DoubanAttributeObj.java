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
public class DoubanAttributeObj implements IDoubanObject {

  @Override
  public String getObjName() {
    return "attribute";
  }
  
  private String name;
  private String value;
  private String lang = "";

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

  /**
   * @return the lang
   */
  public String getLang() {
    return lang;
  }

  /**
   * @param lang the lang to set
   */
  public void setLang(String lang) {
    this.lang = lang;
  }
  
  @Override
  public IDoubanObject ConvertFrom(JSON json) {
    JSONObject obj = (JSONObject)json;
    this.setLang(obj.containsKey("@lang") ? obj.getString("@lang") : "");
    this.setName(obj.containsKey("@name") ? obj.getString("@name") : "");
    this.setValue(obj.containsKey("$t") ? obj.getString("$t") : "");
    return this;
  }
  
}
